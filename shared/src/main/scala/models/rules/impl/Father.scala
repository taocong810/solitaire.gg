package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Number of foundation piles (F0n): 4 (4 stacks)
 *   Initial card restriction (F0u): 2 (Unique suits)
 *   Foundation low rank (F1b): 22 (Deck's high card)
 *   Number of foundation piles (F1n): 4 (4 stacks)
 *   Foundation rank match rule (F1r): 32 (Build down)
 *   Initial card restriction (F1u): 2 (Unique suits)
 *   Foundation Sets (Fn): 2
 *   Auto-fill an empty tableau from (T0af): 0 (Nowhere)
 *   Tableau initial cards (T0d): 1 (1 card)
 *   Maximum cards per tableau (T0m): 2 (2 cards)
 *   Tableau piles (T0n): 12
 *   May move to non-empty tableau from (T0o): 2 (waste)
 *   Tableau rank match rule for building (T0r): 8191 (Regardless of rank)
 *   Tableau suit match rule for building (T0s): 5 (Regardless of suit)
 *   Similar to (like): grandfather
 *   Maximum deals from stock (maxdeals): 2 (2)
 *   Number of decks (ndecks): 2 (2 decks)
 */
object Father extends GameRules(
  id = "father",
  completed = false,
  title = "Father",
  like = Some("grandfather"),
  links = Seq(Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/father.htm")),
  description = "This variation of ^grandfather^ by Thomas Warfield adds difficulty by reducing the number of tableau piles, and adds strategy by e" +
    "liminating the automatic filling of empty spaces, but it's still a pretty easy game.",
  layout = "swff|t",
  deckOptions = DeckOptions(
    numDecks = 2
  ),
  stock = Some(
    StockRules(
      maximumDeals = Some(2)
    )
  ),
  waste = Some(WasteRules()),
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      initialCardRestriction = Some(FoundationInitialCardRestriction.UniqueSuits),
      autoMoveCards = true
    ),
    FoundationRules(
      setNumber = 1,
      numPiles = 4,
      lowRank = FoundationLowRank.DeckHighRank,
      initialCardRestriction = Some(FoundationInitialCardRestriction.UniqueSuits),
      rankMatchRule = RankMatchRule.Down,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 12,
      initialCards = InitialCards.Count(1),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.Any,
      rankMatchRuleForBuilding = RankMatchRule.Any,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      mayMoveToNonEmptyFrom = Seq("waste"),
      maxCards = 2
    )
  )
)
