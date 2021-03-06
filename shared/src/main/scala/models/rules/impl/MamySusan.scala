package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Auto-move cards to foundation (F0a): 3 (When all stackable cards are off)
 *   Reserve initial cards (R0d): 5
 *   Number of reserve piles (R0n): 1
 *   Tableau initial cards (T0d): 4 (4 cards)
 *   Tableau piles (T0n): 10
 *   Tableau suit match rule for building (T0s): 4 (In alternating colors)
 *   Similar to (like): fortythieves
 *   Number of decks (ndecks): 2 (2 decks)
 */
object MamySusan extends GameRules(
  id = "mamysusan",
  completed = true,
  title = "Mamy Susan",
  like = Some("fortythieves"),
  links = Seq(
    Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/mamy_susan.htm"),
    Link("Rapture Technologies KingSol", "www.rapturetech.com/KingSol/Rules/MamySusan.htm")
  ),
  description = "A ^fortythieves^ variation from France with a five card reserve.",
  layout = "swf|r:t",
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
      initialCards = InitialCards.Count(4),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForMovingStacks = SuitMatchRule.None
    )
  ),
  reserves = Some(
    ReserveRules(
      name = "Reserve",
      numPiles = 1,
      initialCards = 5,
      cardsFaceDown = -1
    )
  )
)
