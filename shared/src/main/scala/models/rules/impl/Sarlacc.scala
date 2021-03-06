package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Number of cells (C0n): 6
 *   Pyramid name (P0Nm): Tableau
 *   *P0ds (P0ds): +-+-
 *   Empty pyramid is filled with (P0f): 0 (Any card)
 *   *P0n (P0n): 10
 *   Pyramid suit match rule for building (P0s): 4 (In alternating colors)
 *   Number of pyramids (Pn): 1 (1 pyramid)
 *   Enable stock (Sn): 0 (No stock)
 *   Tableau sets (Tn): 0 (0 tableau sets)
 *   Number of waste piles (W0n): 0
 *   Enable super moves, whatever those are (supermoves): 1
 */
object Sarlacc extends GameRules(
  id = "sarlacc",
  completed = true,
  title = "Sarlacc",
  description = "A ^freecell^ variant with a tableau of interlocking columns.",
  layout = ":f|c|:p",
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      autoMoveCards = true
    )
  ),
  cells = Some(
    CellRules(
      numPiles = 6
    )
  ),
  pyramids = Seq(
    PyramidRules(
      name = "Tableau",
      height = 5,
      suitMatchRuleForBuilding = SuitMatchRule.AlternatingColors,
      rankMatchRuleForBuilding = RankMatchRule.Down,
      rankMatchRuleForMovingStacks = RankMatchRule.Down,
      mayMoveToNonEmptyFrom = Seq("Waste", "Tableau", "Pyramid", "Foundation"),
      mayMoveToEmptyFrom = Seq("Waste", "Tableau", "Pyramid", "Foundation"),
      emptyFilledWith = FillEmptyWith.Any
    )
  )
)
