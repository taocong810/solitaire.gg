// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object AlexanderTheGreat extends GameRules(
  id = "alexanderthegreat",
  title = "Alexander the Great",
  related = Seq("cloverleaf"),
  description = "Thomas Warfield's more challenging variation of ^cloverleaf^.",
  foundations = Seq(
    FoundationRules(
      name = "Red Foundation",
      numPiles = 2,
      initialCards = 2,
      wrapFromKingToAce = true,
      autoMoveCards = true
    ),
    FoundationRules(
      name = "Black Foundation",
      setNumber = 1,
      numPiles = 2,
      lowRank = FoundationLowRank.DeckHighRank,
      initialCards = 2,
      rankMatchRule = RankMatchRule.Down,
      wrapFromKingToAce = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      name = "Fan",
      numPiles = 12,
      initialCards = InitialCards.Count(4),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      rankMatchRuleForBuilding = RankMatchRule.UpOrDown,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = TableauFillEmptyWith.KingsOrAces
    )
  ),
  complete = false
)

