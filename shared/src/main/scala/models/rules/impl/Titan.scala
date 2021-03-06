package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Can move cards from foundation (F0mb): 1 (Always)
 *   Tableau initial cards (T0d): 3 (3 cards)
 *   Tableau piles (T0n): 8
 *   Tableau suit match rule for building (T0s): 4 (In alternating colors)
 *   Tableau suit match rule for moving stacks (T0ts): 4 (In alternating colors)
 *   Number of waste piles (W0n): 0
 *   Deal cards from stock (dealto): 2 (To all tableau piles)
 *   Similar to (like): giant
 *   Number of decks (ndecks): 2 (2 decks)
 */
object Titan extends GameRules(
  id = "titan",
  completed = true,
  title = "Titan",
  like = Some("giant"),
  links = Seq(Link("Solsuite Solitaire", "www.solsuite.com/games/titan.htm")),
  description = "A version of ^giant^ that starts with more cards on the tableau.",
  layout = "sf|.t",
  deckOptions = DeckOptions(
    numDecks = 2
  ),
  stock = Some(
    StockRules(
      dealTo = StockDealTo.Tableau,
      maximumDeals = Some(1)
    )
  ),
  foundations = Seq(
    FoundationRules(
      numPiles = 8,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 8,
      initialCards = InitialCards.Count(3),
      cardsFaceDown = TableauFaceDownCards.Count(0)
    )
  )
)
