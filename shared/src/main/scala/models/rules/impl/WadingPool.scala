package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Foundation Sets (Fn): 0
 *   Enable stock (Sn): 0 (No stock)
 *   Tableau name (T0Nm): Reserve
 *   Tableau initial cards (T0d): -3 (Fill rows with rest of deck)
 *   Empty tableau is filled with (T0f): 5 (No card)
 *   Tableau piles (T0n): 8
 *   Tableau suit match rule for building (T0s): 1 (In same suit)
 *   Tableau suit match rule for moving stacks (T0ts): 0 (May not build)
 *   Tableau initial cards (T1d): 0 (None)
 *   Tableau piles (T1n): 8
 *   Tableau suit match rule for building (T1s): 1 (In same suit)
 *   Tableau suit match rule for moving stacks (T1ts): 1 (In same suit)
 *   Tableau sets (Tn): 2 (2 tableau sets)
 *   Number of waste piles (W0n): 0
 *   Similar to (like): wavemotion
 *   Victory condition (victory): 3 (All cards on tableau sorted)
 */
object WadingPool extends GameRules(
  id = "wadingpool",
  completed = true,
  title = "Wading Pool",
  like = Some("wavemotion"),
  links = Seq(Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/wading_pool.htm")),
  description = "An easier variation of ^wavemotion^ that permits building, but not stack moves, on the reserve.",
  layout = "t|t",
  victoryCondition = VictoryCondition.AllOnTableauSorted,
  tableaus = Seq(
    TableauRules(
      name = "Reserve",
      numPiles = 8,
      initialCards = InitialCards.RestOfDeck,
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = FillEmptyWith.None
    ),
    TableauRules(
      setNumber = 1,
      numPiles = 8,
      initialCards = InitialCards.Count(0),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.SameSuit
    )
  )
)
