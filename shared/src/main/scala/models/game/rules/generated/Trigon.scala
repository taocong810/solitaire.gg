// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object Trigon extends GameRules(
  id = "trigon",
  title = "Trigon",
  like = Some("klondike"),
  related = Seq("doubletrigon", "quadrupletrigon", "trigonleft"),
  description = "A variation of ^klondike^ where we build in suit instead of with alternating colors.",
  stock = Some(StockRules()),
  waste = Some(WasteRules()),
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      wrapFromKingToAce = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.SameSuit,
      emptyFilledWith = TableauFillEmptyWith.Kings
    )
  ),
  complete = false
)

