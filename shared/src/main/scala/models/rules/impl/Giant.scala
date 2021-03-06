package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Can move cards from foundation (F0mb): 2 (Once the stock is empty)
 *   Tableau initial cards (T0d): 1 (1 card)
 *   Tableau piles (T0n): 8
 *   Tableau suit match rule for building (T0s): 4 (In alternating colors)
 *   Tableau suit match rule for moving stacks (T0ts): 4 (In alternating colors)
 *   Number of waste piles (W0n): 0
 *   Deal cards from stock (dealto): 2 (To all tableau piles)
 *   Number of decks (ndecks): 2 (2 decks)
 *   Related games (related): titan
 */
object Giant extends GameRules(
  id = "giant",
  completed = true,
  title = "Giant",
  related = Seq("titan"),
  links = Seq(
    Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/giant.htm"),
    Link("Solsuite Solitaire", "www.solsuite.com/games/giant.htm"),
    Link("Solitaire Game Rules.com", "solitaire-game-rules.com/games/giant.htm"),
    Link("Xolitaire", "www.escapedivision.com/xolitaire/en/games/giant.html"),
    Link("Zonora", "www.zonora.com/mysolitaire/rules/klondike/giant.htm"),
    Link("AisleRiot", "help.gnome.org/users/aisleriot/stable/Giant.html.en")
  ),
  description = "A ^missmilligan^ variant without a pocket but in which any card can be played to an empty space.",
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
      canMoveFrom = FoundationCanMoveFrom.EmptyStock,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 8,
      initialCards = InitialCards.Count(1),
      cardsFaceDown = TableauFaceDownCards.Count(0)
    )
  )
)
