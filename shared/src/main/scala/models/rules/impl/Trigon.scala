package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Auto-move cards to foundation (F0a): 1 (Whenever possible)
 *   Tableau initial cards (T0d): -1 (1 to n cards)
 *   Tableau cards face down (T0df): 100
 *   Empty tableau is filled with (T0f): 1 (Kings only)
 *   Tableau piles (T0n): 7
 *   Tableau suit match rule for building (T0s): 1 (In same suit)
 *   Tableau suit match rule for moving stacks (T0ts): 1 (In same suit)
 *   Deal cards from stock (dealchunk): 1 (One by one)
 *   Similar to (like): klondike
 *   Maximum deals from stock (maxdeals): 0
 *   Related games (related): doubletrigon, quadrupletrigon, trigonleft
 */
object Trigon extends GameRules(
  id = "trigon",
  completed = true,
  title = "Trigon",
  like = Some("klondike"),
  related = Seq("doubletrigon", "quadrupletrigon", "trigonleft"),
  links = Seq(
    Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/trigon.htm"),
    Link("Jan Wolter's Experiments", "/article/trigon.html")
  ),
  description = "A variation of ^klondike^ where we build in suit instead of with alternating colors.",
  layout = "swf|t",
  stock = Some(StockRules()),
  waste = Some(WasteRules()),
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.SameSuit,
      emptyFilledWith = FillEmptyWith.HighRank
    )
  )
)
