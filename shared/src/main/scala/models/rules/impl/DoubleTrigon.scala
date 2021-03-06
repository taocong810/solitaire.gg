package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Auto-move cards to foundation (F0a): 1 (Whenever possible)
 *   Tableau initial cards (T0d): -1 (1 to n cards)
 *   Tableau cards face down (T0df): 100
 *   Empty tableau is filled with (T0f): 1 (Kings only)
 *   Tableau piles (T0n): 9
 *   Tableau suit match rule for building (T0s): 1 (In same suit)
 *   Tableau suit match rule for moving stacks (T0ts): 1 (In same suit)
 *   Deal cards from stock (dealchunk): 1 (One by one)
 *   Similar to (like): trigon
 *   Maximum deals from stock (maxdeals): 0
 *   Number of decks (ndecks): 2 (2 decks)
 */
object DoubleTrigon extends GameRules(
  id = "doubletrigon",
  completed = true,
  title = "Double Trigon",
  like = Some("trigon"),
  links = Seq(Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/double_trigon.htm")),
  description = "A two-deck version of ^trigon^ or maybe a version of ^doubleklondike^ with building in suit. I suppose it depends on how you look " +
    "at it.",
  layout = "swf|:t",
  deckOptions = DeckOptions(
    numDecks = 2
  ),
  stock = Some(StockRules()),
  waste = Some(WasteRules()),
  foundations = Seq(
    FoundationRules(
      numPiles = 8,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 9,
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.SameSuit,
      emptyFilledWith = FillEmptyWith.HighRank
    )
  )
)
