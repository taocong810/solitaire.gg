package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Auto-move cards to foundation (F0a): 1 (Whenever possible)
 *   Tableau initial cards (T0d): 7 (7 cards)
 *   Tableau cards face down (T0df): 101
 *   Empty tableau is filled with (T0f): 1 (Kings only)
 *   Tableau piles (T0n): 7
 *   Tableau suit match rule for building (T0s): 1 (In same suit)
 *   Tableau suit match rule for moving stacks (T0ts): 1 (In same suit)
 *   Similar to (like): interchange
 *   Maximum deals from stock (maxdeals): 0
 *   Number of decks (ndecks): 2 (2 decks)
 *   Related games (related): singleinterchange
 */
object Unlimited extends GameRules(
  id = "unlimited",
  completed = true,
  title = "Unlimited",
  like = Some("interchange"),
  related = Seq("singleinterchange"),
  links = Seq(Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/unlimited.htm")),
  description = "An easier variant of ^interchange^, in which we are allowed unlimited redeals",
  layout = "swf|::t",
  deckOptions = DeckOptions(
    numDecks = 2
  ),
  stock = Some(StockRules()),
  waste = Some(WasteRules()),
  foundations = Seq(
    FoundationRules(
      numPiles = 8,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      initialCards = InitialCards.Count(7),
      cardsFaceDown = TableauFaceDownCards.EvenNumbered,
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.SameSuit,
      emptyFilledWith = FillEmptyWith.HighRank
    )
  )
)
