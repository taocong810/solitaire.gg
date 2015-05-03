// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object Cromwell extends GameRules(
  id = "cromwell",
  title = "Cromwell",
  description = "A two-deck game with 26 tableau piles and a draw. Requires planning.",
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
      numPiles = 26,
      initialCards = InitialCards.Count(4),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.SameSuit
    )
  ),
  special = Some(
    SpecialRules(
      shuffleBeforeRedeal = false,
      drawsAllowed = 1
    )
  ),
  complete = false
)

