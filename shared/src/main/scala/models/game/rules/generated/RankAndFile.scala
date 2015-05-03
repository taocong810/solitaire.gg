// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object RankAndFile extends GameRules(
  id = "rankandfile",
  title = "Rank and File",
  like = Some("numberten"),
  related = Seq("emperor"),
  description = "Like ^numberten^, but three cards in each stack are dealt face down.",
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
      wrapFromKingToAce = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 10,
      initialCards = InitialCards.Count(4),
      emptyFilledWith = TableauFillEmptyWith.Aces
    )
  ),
  complete = false
)

