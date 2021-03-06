package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Auto-move cards to foundation (F0a): 1 (Whenever possible)
 *   Tableau initial cards (T0d): 4 (4 cards)
 *   Tableau piles (T0n): 10
 *   Tableau suit match rule for building (T0s): 1 (In same suit)
 *   Tableau suit match rule for moving stacks (T0ts): 1 (In same suit)
 *   Similar to (like): fortythieves
 *   Number of decks (ndecks): 2 (2 decks)
 */
object Josephine extends GameRules(
  id = "josephine",
  completed = false,
  title = "Josephine",
  like = Some("fortythieves"),
  links = Seq(
    Link("Wikipedia", "en.wikipedia.org/wiki/Josephine_(solitaire)"),
    Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/josephine.htm"),
    Link("dogMelon", "www.dogmelon.com.au/solhelp/Josephine.shtml"),
    Link("BVS Solitaire Collection", "www.bvssolitaire.com/rules/josephine.htm"),
    Link("Solavant Solitaire", "www.solavant.com/solitaire/josephine.php"),
    Link("Zonora", "www.zonora.com/mysolitaire/rules/forty_thieves/josephine.htm")
  ),
  description = "Similar to ^fortythieves^, except that you can move sequences.",
  layout = "swf|t",
  deckOptions = DeckOptions(
    numDecks = 2
  ),
  stock = Some(
    StockRules(
      maximumDeals = Some(1)
    )
  ),
  waste = Some(WasteRules()),
  foundations = Seq(
    FoundationRules(
      numPiles = 8,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 10,
      initialCards = InitialCards.Count(4),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.SameSuit
    )
  )
)
