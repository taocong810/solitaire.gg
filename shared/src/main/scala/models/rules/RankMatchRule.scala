package models.rules

import models.card.Rank

sealed trait RankMatchRule {
  def check(l: Rank, r: Rank, lowRank: Rank, wrap: Boolean, pileIndex: Int): Boolean
}

object RankMatchRule {
  private[this] def upBy(i: Int, l: Rank, r: Rank, lowRank: Rank, wrap: Boolean) = {
    val highRank = lowRank.previous
    val target = (0 until i).foldLeft[Rank](l)((rank, i) => {
      if (rank == Rank.Unknown) {
        Rank.Unknown
      } else if (rank == highRank) {
        if (wrap) {
          rank.next
        } else {
          Rank.Unknown
        }
      } else {
        rank.next
      }
    })
    target == r
  }

  private[this] def downBy(i: Int, l: Rank, r: Rank, lowRank: Rank, wrap: Boolean) = {
    val target = (0 until i).foldLeft[Rank](l)((rank, i) => {
      if (rank == Rank.Unknown) {
        Rank.Unknown
      } else if (rank == lowRank) {
        if (wrap) {
          rank.previous
        } else {
          Rank.Unknown
        }
      } else {
        rank.previous
      }
    })
    target == r
  }

  case object None extends RankMatchRule {
    override def check(l: Rank, r: Rank, lowRank: Rank, wrap: Boolean, pileIndex: Int) = false
  }
  case object Up extends RankMatchRule {
    override def check(l: Rank, r: Rank, lowRank: Rank, wrap: Boolean, pileIndex: Int) = upBy(1, l, r, lowRank, wrap)
  }
  case object Down extends RankMatchRule {
    override def check(l: Rank, r: Rank, lowRank: Rank, wrap: Boolean, pileIndex: Int) = downBy(1, l, r, lowRank, wrap)
  }
  case object Equal extends RankMatchRule {
    override def check(l: Rank, r: Rank, lowRank: Rank, wrap: Boolean, pileIndex: Int) = l.index == r.index
  }
  case object UpOrDown extends RankMatchRule {
    override def check(l: Rank, r: Rank, lowRank: Rank, wrap: Boolean, pileIndex: Int) = {
      Up.check(l, r, lowRank, wrap, pileIndex) || Down.check(l, r, lowRank, wrap, pileIndex)
    }
  }
  case object UpBy2 extends RankMatchRule {
    override def check(l: Rank, r: Rank, lowRank: Rank, wrap: Boolean, pileIndex: Int) = upBy(2, l, r, lowRank, wrap)
  }
  case object DownBy2 extends RankMatchRule {
    override def check(l: Rank, r: Rank, lowRank: Rank, wrap: Boolean, pileIndex: Int) = downBy(2, l, r, lowRank, wrap)
  }
  case object UpBy3 extends RankMatchRule {
    override def check(l: Rank, r: Rank, lowRank: Rank, wrap: Boolean, pileIndex: Int) = upBy(3, l, r, lowRank, wrap)
  }
  case object DownBy3 extends RankMatchRule {
    override def check(l: Rank, r: Rank, lowRank: Rank, wrap: Boolean, pileIndex: Int) = downBy(3, l, r, lowRank, wrap)
  }
  case object UpBy4 extends RankMatchRule {
    override def check(l: Rank, r: Rank, lowRank: Rank, wrap: Boolean, pileIndex: Int) = upBy(4, l, r, lowRank, wrap)
  }
  case object DownBy4 extends RankMatchRule {
    override def check(l: Rank, r: Rank, lowRank: Rank, wrap: Boolean, pileIndex: Int) = downBy(4, l, r, lowRank, wrap)
  }
  case object UpByPileIndex extends RankMatchRule {
    override def check(l: Rank, r: Rank, lowRank: Rank, wrap: Boolean, pileIndex: Int) = upBy(pileIndex, l, r, lowRank, wrap)
  }
  case object Any extends RankMatchRule {
    override def check(l: Rank, r: Rank, lowRank: Rank, wrap: Boolean, pileIndex: Int) = true
  }
}
