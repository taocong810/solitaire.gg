// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object Corona extends GameRules(
  id = "corona",
  title = "Corona",
  related = Seq("quadrangle"),
  description = "A game similar to ^fortyandeight^ where spaces are autofilled from the waste and stock. The best way to win seems to be to get luc" +
  "ky.",
  deckOptions = DeckOptions(
    numDecks = 2
  ),
  stock = Some(
    StockRules(
      maximumDeals = Some(1)
    )
  ),
  waste = Some(WasteRules()),
  foundations = Seq(
    FoundationRules(
      numPiles = 8,
      wrapFromKingToAce = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 12,
      initialCards = InitialCards.Count(3),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      autoFillEmptyFrom = TableauAutoFillEmptyFrom.WasteThenStock,
      emptyFilledWith = TableauFillEmptyWith.Aces
    )
  ),
  complete = false
)

