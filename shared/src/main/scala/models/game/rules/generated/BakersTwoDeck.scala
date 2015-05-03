// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object BakersTwoDeck extends GameRules(
  id = "bakerstwodeck",
  title = "Baker's Two-Deck",
  description = "A two-deck version of ^bakers^ games.",
  deckOptions = DeckOptions(
    numDecks = 2
  ),
  foundations = Seq(
    FoundationRules(
      numPiles = 8,
      wrapFromKingToAce = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 10,
      initialCards = InitialCards.RestOfDeck,
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = TableauFillEmptyWith.Aces
    )
  ),
  cells = Some(
    CellRules(
      numPiles = 8
    )
  ),
  complete = false
)

