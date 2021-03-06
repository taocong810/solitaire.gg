package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Foundation Sets (Fn): 0
 *   Tableau initial cards (T0d): 1 (1 card)
 *   Tableau piles (T0n): 10
 *   Tableau rank match rule for building (T0r): 128 (Build up)
 *   Tableau suit match rule for building (T0s): 5 (Regardless of suit)
 *   Tableau wraps from king to ace (T0w): true
 *   Similar to (like): german
 *   Number of decks (ndecks): 2 (2 decks)
 *   Victory condition (victory): 3 (All cards on tableau sorted)
 *   *vrank (vrank): 128
 *   *vsuit (vsuit): 5
 */
object Bavarian extends GameRules(
  id = "bavarian",
  completed = true,
  title = "Bavarian",
  like = Some("german"),
  links = Seq(Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/bavarian_patience.htm")),
  description = "Thomas Warfield's easier version of ^german^ patience with a few extra tableau columns.",
  layout = "::::sw|t",
  victoryCondition = VictoryCondition.AllOnTableauSorted,
  deckOptions = DeckOptions(
    numDecks = 2
  ),
  stock = Some(
    StockRules(
      maximumDeals = Some(1)
    )
  ),
  waste = Some(WasteRules()),
  tableaus = Seq(
    TableauRules(
      numPiles = 10,
      initialCards = InitialCards.Count(1),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.Any,
      rankMatchRuleForBuilding = RankMatchRule.Up,
      wrap = true,
      suitMatchRuleForMovingStacks = SuitMatchRule.None
    )
  )
)
