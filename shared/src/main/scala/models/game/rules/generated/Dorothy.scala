// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object Dorothy extends GameRules(
  id = "dorothy",
  title = "Dorothy",
  description = "Another brainless variation of ^captivequeens^ and ^sixesandsevens^ with separate foundations for odds, evens and face cards.",
  stock = Some(
    StockRules(
      maximumDeals = Some(2)
    )
  ),
  waste = Some(WasteRules()),
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      lowRank = FoundationLowRank.SpecificRank(Rank.King),
      rankMatchRule = RankMatchRule.DownBy2,
      wrapFromKingToAce = true,
      maxCards = 5
    ),
    FoundationRules(
      setNumber = 1,
      numPiles = 4,
      lowRank = FoundationLowRank.SpecificRank(Rank.King),
      rankMatchRule = RankMatchRule.DownBy2,
      wrapFromKingToAce = true,
      maxCards = 5
    ),
    FoundationRules(
      setNumber = 2,
      numPiles = 4,
      lowRank = FoundationLowRank.SpecificRank(Rank.King),
      wrapFromKingToAce = true,
      maxCards = 3
    )
  ),
  complete = false
)

