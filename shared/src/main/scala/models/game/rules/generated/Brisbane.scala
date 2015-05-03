// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object Brisbane extends GameRules(
  id = "brisbane",
  title = "Brisbane",
  like = Some("yukon"),
  description = "Just like ^yukon^, but the starting layout is a bit different and you build regardless of suit.",
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      wrapFromKingToAce = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      initialCards = InitialCards.Custom,
      customInitialCards = Seq(
        "UUUUU",
        "DUUUUU",
        "DDUUUUU",
        "DDDUUUU",
        "DDDDUUUU",
        "DDDDDUUUU",
        "DDDDDDUUUU"
      ),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.Any,
      suitMatchRuleForMovingStacks = SuitMatchRule.Any,
      rankMatchRuleForMovingStacks = RankMatchRule.Any,
      emptyFilledWith = TableauFillEmptyWith.Kings
    )
  ),
  complete = false
)

