// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object ChallengeFreeCell extends GameRules(
  id = "challengefreecell",
  title = "Challenge FreeCell",
  like = Some("freecell"),
  related = Seq("superchallengefreecell"),
  description = "A version of ^freecell^ invented by Thomas Warfield where the aces and twos are always at the bottoms of the eight stacks.",
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      wrapFromKingToAce = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 8,
      initialCards = InitialCards.RestOfDeck,
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = TableauFillEmptyWith.Aces,
      pilesWithLowCardsAtBottom = 8
    )
  ),
  cells = Some(CellRules()),
  complete = false
)

