// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object WaveMotion extends GameRules(
  id = "wavemotion",
  title = "Wave Motion",
  related = Seq("flow", "wadingpool"),
  description = "In David Bernazzani's variation on ^freecell^ and ^scorpion^, all cards start on the reserve. They need to be arranged into sequen" +
  "ces on the tableau.",
  victoryCondition = VictoryCondition.AllOnTableauSorted,
  tableaus = Seq(
    TableauRules(
      name = "Reserve",
      numPiles = 8,
      initialCards = InitialCards.RestOfDeck,
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.None,
      suitMatchRuleForMovingStacks = SuitMatchRule.None
    ),
    TableauRules(
      setNumber = 1,
      numPiles = 8,
      initialCards = InitialCards.Count(0),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.SameSuit,
      emptyFilledWith = TableauFillEmptyWith.Aces
    )
  ),
  complete = false
)

