// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object QuadrupleYukon extends GameRules(
  id = "quadrupleyukon",
  title = "Quadruple Yukon",
  like = Some("doubleyukon"),
  description = "A four-deck variation of ^yukon^",
  deckOptions = DeckOptions(
    numDecks = 4
  ),
  foundations = Seq(
    FoundationRules(
      numPiles = 16,
      wrapFromKingToAce = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 16,
      initialCards = InitialCards.Custom,
      customInitialCards = Seq(
        "U",
        "DUUUUUU",
        "DDUUUUUU",
        "DDDUUUUUU",
        "DDDDUUUUUU",
        "DDDDDUUUUUU",
        "DDDDDDUUUUUU",
        "DDDDDDDUUUUUU",
        "DDDDDDDDUUUUUU",
        "DDDDDDDDDUUUUUU",
        "DDDDDDDDDDUUUUUU",
        "DDDDDDDDDDDUUUUUU",
        "DDDDDDDDDDDDUUUUUU",
        "DDDDDDDDDDDDDUUUUU",
        "DDDDDDDDDDDDDDUUUUU",
        "DDDDDDDDDDDDDDDUUUUU"
      ),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForMovingStacks = SuitMatchRule.Any,
      rankMatchRuleForMovingStacks = RankMatchRule.Any,
      emptyFilledWith = TableauFillEmptyWith.Kings
    )
  ),
  complete = false
)

