// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object Bucket extends GameRules(
  id = "bucket",
  title = "Bucket",
  like = Some("canister"),
  description = "A ^canister^ variation which ends up looking rather like ^freecell^ without the cells. Naturally, it ends up being rather difficul" +
  "t.",
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      wrapFromKingToAce = true,
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
  complete = false
)

