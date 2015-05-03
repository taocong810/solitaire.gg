// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object Adelaide extends GameRules(
  id = "adelaide",
  title = "Adelaide",
  like = Some("outback"),
  description = "This two-deck solitaire allows moving unsorted stacks, as in ^yukon^. It is exactly like ^outback^, but you get to do two passes t" +
  "hrough the deck.",
  deckOptions = DeckOptions(
    numDecks = 2
  ),
  stock = Some(
    StockRules(
      maximumDeals = Some(2)
    )
  ),
  waste = Some(WasteRules()),
  foundations = Seq(
    FoundationRules(
      numPiles = 8,
      wrapFromKingToAce = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 8,
      initialCards = InitialCards.Count(7),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.Any,
      rankMatchRuleForMovingStacks = RankMatchRule.Any,
      emptyFilledWith = TableauFillEmptyWith.Kings
    )
  ),
  complete = false
)

