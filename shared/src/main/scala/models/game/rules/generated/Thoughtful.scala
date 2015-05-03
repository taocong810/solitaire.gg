// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object Thoughtful extends GameRules(
  id = "thoughtful",
  title = "Thoughtful",
  like = Some("klondike"),
  related = Seq("auntmary"),
  description = "^klondike^ with all cards in the tableau starting face up. Also known as \"Saratoga\".",
  stock = Some(
    StockRules(
      cardsDealt = StockCardsDealt.Count(3)
    )
  ),
  waste = Some(WasteRules()),
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      wrapFromKingToAce = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      cardsFaceDown = TableauFaceDownCards.Count(0),
      emptyFilledWith = TableauFillEmptyWith.Kings
    )
  ),
  complete = false
)

