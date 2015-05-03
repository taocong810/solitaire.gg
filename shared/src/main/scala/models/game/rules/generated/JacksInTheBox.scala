// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object JacksInTheBox extends GameRules(
  id = "jacksinthebox",
  title = "Jacks in the Box",
  like = Some("deuces"),
  description = "A variation on ^deuces^ which has fewer tableau piles but adds some cells.",
  deckOptions = DeckOptions(
    numDecks = 2,
    lowRank = Rank.Jack
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
      initialCards = 8,
      wrapFromKingToAce = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 6,
      initialCards = InitialCards.Count(1),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = TableauFillEmptyWith.Aces
    )
  ),
  cells = Some(CellRules()),
  complete = false
)

