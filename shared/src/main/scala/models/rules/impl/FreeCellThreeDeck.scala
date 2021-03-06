package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Number of cells (C0n): 12
 *   Enable stock (Sn): 0 (No stock)
 *   Tableau initial cards (T0d): -3 (Fill rows with rest of deck)
 *   Tableau piles (T0n): 12
 *   Tableau suit match rule for building (T0s): 4 (In alternating colors)
 *   Number of waste piles (W0n): 0
 *   Similar to (like): triplefreecell
 *   Number of decks (ndecks): 3 (3 decks)
 *   Related games (related): freecellfourdeck
 *   Enable super moves, whatever those are (supermoves): 1
 */
object FreeCellThreeDeck extends GameRules(
  id = "freecellthreedeck",
  completed = true,
  title = "FreeCell Three Deck",
  like = Some("triplefreecell"),
  related = Seq("freecellfourdeck"),
  links = Seq(Link("Solsuite Solitaire", "www.solsuite.com/games/freecell_three_decks.htm")),
  description = "Yet another three-deck version of ^freecell^.",
  layout = "f|c|t",
  deckOptions = DeckOptions(
    numDecks = 3
  ),
  foundations = Seq(
    FoundationRules(
      numPiles = 12,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 12,
      initialCards = InitialCards.RestOfDeck,
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForMovingStacks = SuitMatchRule.None
    )
  ),
  cells = Some(
    CellRules(
      numPiles = 12
    )
  )
)
