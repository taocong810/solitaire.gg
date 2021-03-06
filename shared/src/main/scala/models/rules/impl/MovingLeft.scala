package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Auto-fill an empty tableau from (T0af): -1 (Next tableau column)
 *   Tableau initial cards (T0d): -1 (1 to n cards)
 *   Tableau cards face down (T0df): 100
 *   Empty tableau is filled with (T0f): 1 (Kings only)
 *   Tableau piles (T0n): 10
 *   Tableau suit match rule for building (T0s): 4 (In alternating colors)
 *   Tableau suit match rule for moving stacks (T0ts): 4 (In alternating colors)
 *   Number of decks (ndecks): 2 (2 decks)
 *   Related games (related): tripleleft, singleleft
 */
object MovingLeft extends GameRules(
  id = "movingleft",
  completed = true,
  title = "Moving Left",
  related = Seq("tripleleft", "singleleft"),
  links = Seq(Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/moving_left.htm")),
  description = "A variant of ^gargantua^ or ^doubleklondike^ where empty spaces are automatically filled from the next column.",
  layout = "swf|.t",
  deckOptions = DeckOptions(
    numDecks = 2
  ),
  stock = Some(
    StockRules(
      maximumDeals = Some(1)
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
      autoFillEmptyFrom = TableauAutoFillEmptyFrom.NextPile,
      emptyFilledWith = FillEmptyWith.HighRank
    )
  )
)
