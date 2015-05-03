// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object Elevens extends GameRules(
  id = "elevens",
  title = "Elevens",
  like = Some("tens"),
  related = Seq("suitelevens"),
  description = "A set removal sets of cards adding to 15 or sets containing ten through king.",
  cardRemovalMethod = CardRemovalMethod.RemovePairsAddingToElevenOrJQK,
  stock = Some(
    StockRules(
      dealTo = StockDealTo.Never,
      maximumDeals = Some(1)
    )
  ),
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      wrapFromKingToAce = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 9,
      initialCards = InitialCards.Count(1),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.None,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      autoFillEmptyFrom = TableauAutoFillEmptyFrom.Stock
    )
  ),
  complete = false
)

