// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object Antares extends GameRules(
  id = "antares",
  title = "Antares",
  description = "Thomas Warfield's combination of ^freecell^ and ^scorpion^ divides the tableau into two halves, one where we build in alternate co" +
  "lors and move cards by FreeCell rules, one where we build in the same suit and move by Scorpion rules.",
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      wrapFromKingToAce = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      name = "Left Tableau",
      numPiles = 4,
      initialCards = InitialCards.Count(7),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = TableauFillEmptyWith.Aces
    ),
    TableauRules(
      name = "Right Tableau",
      setNumber = 1,
      numPiles = 4,
      initialCards = InitialCards.Count(6),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.Any,
      rankMatchRuleForMovingStacks = RankMatchRule.Any,
      emptyFilledWith = TableauFillEmptyWith.Kings
    )
  ),
  cells = Some(CellRules()),
  complete = false
)

