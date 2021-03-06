package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Can move cards from foundation (F0mb): 1 (Always)
 *   Tableau initial cards (T0d): 1 (1 card)
 *   Empty tableau is filled with (T0f): 0 (Any card)
 *   Tableau piles (T0n): 8
 *   Tableau suit match rule for building (T0s): 4 (In alternating colors)
 *   Tableau suit match rule for moving stacks (T0ts): 4 (In alternating colors)
 *   Number of waste piles (W0n): 0
 *   Deal cards from stock (dealto): 2 (To all tableau piles)
 *   Similar to (like): missmilligan
 *   Create pocket when stock runs out (millres): 2 (For one stack of cards)
 *   Number of decks (ndecks): 2 (2 decks)
 */
object ImperialGuards extends GameRules(
  id = "imperialguards",
  completed = true,
  title = "Imperial Guards",
  like = Some("missmilligan"),
  links = Seq(
    Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/imperial_guards.htm"),
    Link("BVS Solitaire Collection", "www.bvssolitaire.com/rules/imperial-guards.htm"),
    Link("Rapture Technologies KingSol", "www.rapturetech.com/KingSol/Rules/ImperialGuards.htm")
  ),
  description = "A version of ^missmilligan^ where empty tableau spaces can be filled with any card instead of Kings only. Since empty spaces are c" +
    "ommon in these games, this greatly simplifies the game.",
  layout = "sf|.t",
  deckOptions = DeckOptions(
    numDecks = 2
  ),
  stock = Some(
    StockRules(
      dealTo = StockDealTo.Tableau,
      maximumDeals = Some(1),
      createPocketWhenEmpty = true
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
      initialCards = InitialCards.Count(1),
      cardsFaceDown = TableauFaceDownCards.Count(0)
    )
  )
)
