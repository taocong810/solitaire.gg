package models.game.pile.constraints

import models.game.{Rank, Card}
import models.game.pile.{PileOption, Pile}

case class DragFromConstraint(override val id: String, f: (Pile, Seq[Card]) => Boolean) extends PileOption(id)

object DragFromConstraints {
  val never = DragFromConstraint("never", (pile, cards) => false)

  val topCardOnly = DragFromConstraint("top-card-only", (pile, cards) => cards.headOption == pile.cards.lastOption)

  val klondike = DragFromConstraint("klondike", (pile, cards) => if(cards.exists(!_.u)) {
    false
  } else {
    var valid = true
    var lastCard: Option[Card] = None

    for(c <- cards) {
      if(lastCard.isDefined) {
        if(c.s.color == lastCard.get.s.color) {
          valid = false
        }
        if(c.r == Rank.Ace || c.r.value != (lastCard.get.r.value - 1)) {
          valid = false
        }
      }
      lastCard = Some(c)
    }
    valid
  })
}
