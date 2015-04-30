// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object ThreeCell extends GameRules(
  id = "threecell",
  title = "ThreeCell",
  description = "A variation of ^freecell^ with only three cells.",
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      wrapFromKingToAce = true,
      canMoveFrom = FoundationCanMoveFrom.Never,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 8,
      initialCards = InitialCards.RestOfDeck,
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = TableauFillEmptyWith.Aces
    )
  ),
  cells = Some(
    CellRules(

      numPiles = 3
    )
  ),
  complete = false
)
