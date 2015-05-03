// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object Citadel extends GameRules(
  id = "citadel",
  title = "Citadel",
  like = Some("beleagueredcastle"),
  related = Seq("exiledkings"),
  description = "An easier variation of ^beleagueredcastle^ where cards are moved to the foundation during the deal.",
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      initialCards = 4,
      wrapFromKingToAce = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 8,
      initialCards = InitialCards.Count(6),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.Any,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = TableauFillEmptyWith.Aces,
      actionDuringDeal = PileAction.MoveToFoundation
    )
  ),
  complete = false
)

