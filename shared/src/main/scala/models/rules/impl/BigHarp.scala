package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Tableau initial cards (T0d): -1 (1 to n cards)
 *   Tableau cards face down (T0df): 100
 *   Empty tableau is filled with (T0f): 1 (Kings only)
 *   Tableau piles (T0n): 10
 *   Tableau suit match rule for building (T0s): 4 (In alternating colors)
 *   Tableau suit match rule for moving stacks (T0ts): 4 (In alternating colors)
 *   Deal cards from stock (dealchunk): 3 (Three at a time)
 *   Similar to (like): endlessharp
 *   Maximum deals from stock (maxdeals): 3 (3)
 *   Number of decks (ndecks): 2 (2 decks)
 */
object BigHarp extends GameRules(
  id = "bigharp",
  completed = false,
  title = "Big Harp",
  like = Some("endlessharp"),
  links = Seq(
    Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/big_harp.htm"),
    Link("Lena Games", "www.lenagames.com/bp_files/rul/big-harp.htm")
  ),
  description = "A two-deck ^klondike^ variation that is different than ^harp^ in several ways, without really being that much bigger.",
  layout = "swf|t",
  deckOptions = DeckOptions(
    numDecks = 2
  ),
  stock = Some(
    StockRules(
      maximumDeals = Some(3),
      cardsDealt = StockCardsDealt.Count(3)
    )
  ),
  waste = Some(WasteRules()),
  foundations = Seq(
    FoundationRules(
      numPiles = 8,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 10,
      emptyFilledWith = FillEmptyWith.HighRank
    )
  )
)
