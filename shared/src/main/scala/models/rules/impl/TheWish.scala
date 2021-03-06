package models.rules.impl

import models.card.Rank
import models.rules._

/**
 * Original Settings:
 *   Foundation low rank (F0b): 20 (Any Card)
 *   Enable stock (Sn): 0 (No stock)
 *   Tableau initial cards (T0d): 4 (4 cards)
 *   Empty tableau is filled with (T0f): 5 (No card)
 *   Tableau piles (T0n): 8
 *   Tableau suit match rule for building (T0s): 0 (May not build)
 *   Number of waste piles (W0n): 0
 *   Left mouse interface function (leftfunc): 1
 *   Card removal method (pairs): 1 (Remove pairs of same rank)
 *   Ranks in use (ranks): 8129
 */
object TheWish extends GameRules(
  id = "thewish",
  completed = true,
  title = "The Wish",
  links = Seq(
    Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/the_wish.htm"),
    Link("Solitaire Till Dawn", "www.semicolon.com/Solitaire/Rules/TheWish.html")
  ),
  description = "This easy pair-removal game uses a short deck and no stock, but is otherwise similar to ^doublets^.",
  layout = "f|t",
  cardRemovalMethod = CardRemovalMethod.RemovePairsOfSameRank,
  deckOptions = DeckOptions(
    ranks = Seq(Rank.Seven, Rank.Eight, Rank.Nine, Rank.Ten, Rank.Jack, Rank.Queen, Rank.King, Rank.Ace)
  ),
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      lowRank = FoundationLowRank.AnyCard,
      autoMoveCards = true,
      visible = false
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 8,
      initialCards = InitialCards.Count(4),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.None,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = FillEmptyWith.None
    )
  )
)
