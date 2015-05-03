// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object Tripleharp extends GameRules(
  id = "tripleharp",
  title = "Tripleharp",
  like = Some("harp"),
  description = "A three-deck version of ^harp^ invented by Thomas Warfield.",
  deckOptions = DeckOptions(
    numDecks = 3
  ),
  stock = Some(
    StockRules(
      maximumDeals = Some(4)
    )
  ),
  waste = Some(WasteRules()),
  foundations = Seq(
    FoundationRules(
      numPiles = 12,
      wrapFromKingToAce = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 12,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = TableauFillEmptyWith.Kings
    )
  ),
  complete = false
)

