// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object Tabbycat extends GameRules(
  id = "tabbycat",
  title = "Tabbycat",
  description = "An easier version of ^manx^ which allows a sequence to be parkted in the tail. Also invented by Rick Holzgrafe of Solitaire Til Da" +
  "wn.",
  stock = Some(
    StockRules(
      dealTo = StockDealTo.TableauFirstSet,
      maximumDeals = Some(1)
    )
  ),
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      suitMatchRule = SuitMatchRule.Any,
      wrapFromKingToAce = true,
      moveCompleteSequencesOnly = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 4,
      initialCards = InitialCards.Count(1),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.Any,
      wrapFromKingToAce = true,
      suitMatchRuleForMovingStacks = SuitMatchRule.Any,
      emptyFilledWith = TableauFillEmptyWith.Aces
    ),
    TableauRules(
      name = "Tail",
      setNumber = 1,
      numPiles = 1,
      initialCards = InitialCards.Count(0),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.None,
      suitMatchRuleForMovingStacks = SuitMatchRule.Any,
      rankMatchRuleForMovingStacks = RankMatchRule.Any,
      emptyFilledWith = TableauFillEmptyWith.Aces
    )
  ),
  complete = false
)

