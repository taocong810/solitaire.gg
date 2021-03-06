package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Number of cells (C0n): 4
 *   Enable stock (Sn): 0 (No stock)
 *   Tableau initial cards (T0d): -3 (Fill rows with rest of deck)
 *   *T0db (T0db): 0
 *   Tableau piles (T0n): 8
 *   Tableau suit match rule for building (T0s): 1 (In same suit)
 *   Number of waste piles (W0n): 0
 *   Related games (related): bakerstwodeck
 *   Enable super moves, whatever those are (supermoves): 1
 */
object Bakers extends GameRules(
  id = "bakers",
  completed = true,
  title = "Baker's",
  related = Seq("bakerstwodeck"),
  links = Seq(
    Link("Michael Keller's amazing FreeCell FAQ", "solitairelaboratory.com/fcfaq.html"),
    Link("Wikipedia", "en.wikipedia.org/wiki/Baker's_Game"),
    Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/bakers_game.htm"),
    Link("Xolitaire", "www.escapedivision.com/xolitaire/en/games/bakers_game.html"),
    Link("AisleRiot", "help.gnome.org/users/aisleriot/stable/Bakers_Game.html.en"),
    Link("Zonora", "www.zonora.com/mysolitaire/rules/freecell/bakers_game.htm")
  ),
  description = "A predecessor of ^freecell^ invented by C. L. Baker. The rules are the same as FreeCell, except that you build down in suit instea" +
    "d of in alternating colors.",
  layout = "fc|t",
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 8,
      initialCards = InitialCards.RestOfDeck,
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.None
    )
  ),
  cells = Some(CellRules())
)
