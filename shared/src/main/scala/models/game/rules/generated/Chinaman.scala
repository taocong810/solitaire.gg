// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object Chinaman extends GameRules(
  id = "chinaman",
  title = "Chinaman",
  like = Some("klondike"),
  description = "A ^klondike^ variant where we build by different suits.",
  stock = Some(
    StockRules(
      maximumDeals = Some(2),
      cardsDealt = StockCardsDealt.Count(3)
    )
  ),
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
      suitMatchRuleForBuilding = SuitMatchRule.DifferentSuits,
      suitMatchRuleForMovingStacks = SuitMatchRule.DifferentSuits,
      emptyFilledWith = TableauFillEmptyWith.Kings
    )
  ),
  complete = false
)

