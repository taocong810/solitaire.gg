// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object BearRiver extends GameRules(
  id = "bearriver",
  title = "Bear River",
  description = "A ^fan^ variation where you can build up and down in suit, but are limited to three cards per pile.",
  deckOptions = DeckOptions(
    lowRank = Rank.Unknown
  ),
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      initialCards = 1,
      wrapFromKingToAce = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 15,
      initialCards = InitialCards.Count(3),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      rankMatchRuleForBuilding = RankMatchRule.UpOrDown,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      maxCards = 3
    ),
    TableauRules(
      name = "Hole",
      setNumber = 1,
      numPiles = 3,
      initialCards = InitialCards.Count(2),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      rankMatchRuleForBuilding = RankMatchRule.UpOrDown,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = TableauFillEmptyWith.Aces,
      maxCards = 3
    )
  ),
  complete = false
)

