package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Auto-move cards to foundation (F0a): 1 (Whenever possible)
 *   Tableau initial cards (T0d): 1 (1 card)
 *   Tableau piles (T0n): 12
 *   Tableau suit match rule for building (T0s): 1 (In same suit)
 *   Tableau suit match rule for moving stacks (T0ts): 1 (In same suit)
 *   Left mouse interface function (leftfunc): 0x2|0x20
 *   Similar to (like): busyaces
 *   Number of decks (ndecks): 2 (2 decks)
 *   Enable super moves, whatever those are (supermoves): 0
 */
object Stages extends GameRules(
  id = "stages",
  completed = false,
  title = "Stages",
  like = Some("busyaces"),
  links = Seq(Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/stages.htm")),
  description = "An easier variation of ^busyaces^ that allows stack moves.",
  layout = "swf|t",
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
      numPiles = 12,
      initialCards = InitialCards.Count(1),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.SameSuit
    )
  )
)
