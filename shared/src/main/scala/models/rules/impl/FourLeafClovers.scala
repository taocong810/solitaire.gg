package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Maximum cards for foundation (F0m): 0
 *   Number of foundation piles (F0n): 1 (1 stack)
 *   Foundation suit match rule (F0s): 5 (Regardless of suit)
 *   Enable stock (Sn): 0 (No stock)
 *   Tableau initial cards (T0d): 4 (4 cards)
 *   Empty tableau is filled with (T0f): 5 (No card)
 *   Tableau piles (T0n): 13
 *   Tableau rank match rule for building (T0r): 160 (Build up or down)
 *   Tableau suit match rule for building (T0s): 5 (Regardless of suit)
 *   Tableau wraps from king to ace (T0w): true
 *   Number of waste piles (W0n): 0
 */
object FourLeafClovers extends GameRules(
  id = "fourleafclovers",
  completed = true,
  title = "Four Leaf Clovers",
  links = Seq(
    Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/four_leaf_clovers.htm"),
    Link("Solsuite Solitaire", "www.solsuite.com/games/four_leaf_clovers.htm"),
    Link("BVS Solitaire Collection", "www.bvssolitaire.com/rules/four-leaf-clovers.htm"),
    Link("Rapture Technologies KingSol", "www.rapturetech.com/KingSol/Rules/FourLeafClovers.htm")
  ),
  description = "A single foundation pile is built regardless of suit from ace to king and then from ace to king again with the help of a tableau w" +
    "here you can build both up and down.",
  layout = "::::::f|t",
  foundations = Seq(
    FoundationRules(
      suitMatchRule = SuitMatchRule.Any,
      maxCards = 0,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 13,
      initialCards = InitialCards.Count(4),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.Any,
      rankMatchRuleForBuilding = RankMatchRule.UpOrDown,
      wrap = true,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = FillEmptyWith.None
    )
  )
)
