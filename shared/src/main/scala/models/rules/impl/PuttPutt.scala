package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Foundation low rank (F0b): 20 (Any Card)
 *   Foundation initial cards (F0d): 1 (1 cards)
 *   Maximum cards for foundation (F0m): 0
 *   Number of foundation piles (F0n): 1 (1 stack)
 *   Foundation rank match rule (F0r): 160 (Build up or down)
 *   Foundation suit match rule (F0s): 5 (Regardless of suit)
 *   Foundation wraps from king to ace (F0w): true
 *   *S0cardsShown (S0cardsShown): 16
 *   Tableau initial cards (T0d): 5 (5 cards)
 *   Empty tableau is filled with (T0f): 5 (No card)
 *   Tableau piles (T0n): 7
 *   Tableau rank match rule for building (T0r): 0 (May not build)
 *   Tableau suit match rule for building (T0s): 0 (May not build)
 *   Number of waste piles (W0n): 0
 *   Deal cards from stock (dealto): 6 (To all foundation piles)
 *   Left mouse interface function (leftfunc): 2
 *   Similar to (like): golf
 *   Related games (related): lincolngreens
 *   Touch interface function (touchfunc): 2
 *   Victory condition (victory): 5 (All cards on foundation or stock)
 */
object PuttPutt extends GameRules(
  id = "puttputt",
  completed = true,
  title = "Putt Putt",
  like = Some("golf"),
  related = Seq("lincolngreens"),
  links = Seq(
    Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/putt_putt.htm"),
    Link("Solitaire Central", "www.solitairecentral.com/rules/PuttPutt.html"),
    Link("Rapture Technologies KingSol", "www.rapturetech.com/KingSol/Rules/Puttputt.htm"),
    Link("Jan Wolter's Experiments", "/article/golf.html")
  ),
  description = "An easier variation of ^golf^ where wrapping from King to Ace is allowed.",
  layout = "s:::::f|t",
  victoryCondition = VictoryCondition.AllOnFoundationOrStock,
  stock = Some(
    StockRules(
      cardsShown = 16,
      dealTo = StockDealTo.Foundation,
      maximumDeals = Some(1)
    )
  ),
  foundations = Seq(
    FoundationRules(
      lowRank = FoundationLowRank.AnyCard,
      initialCards = 1,
      suitMatchRule = SuitMatchRule.Any,
      rankMatchRule = RankMatchRule.UpOrDown,
      maxCards = 0,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      initialCards = InitialCards.Count(5),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.None,
      rankMatchRuleForBuilding = RankMatchRule.None,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = FillEmptyWith.None
    )
  )
)
