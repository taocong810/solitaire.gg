package models.rules.impl

import models.rules._

/**
 * Original Settings:
 *   Enable stock (Sn): 0 (No stock)
 *   Tableau initial cards (T0d): -3 (Fill rows with rest of deck)
 *   Tableau piles (T0n): 8
 *   Tableau suit match rule for building (T0s): 4 (In alternating colors)
 *   Tableau suit match rule for moving stacks (T0ts): 4 (In alternating colors)
 *   Number of waste piles (W0n): 0
 *   Similar to (like): canister
 *   Number of decks (ndecks): 1 (1 deck)
 */
object AmericanCanister extends GameRules(
  id = "americancanister",
  completed = true,
  title = "American Canister",
  like = Some("canister"),
  links = Seq(
    Link("Zonora", "www.zonora.com/games/a/american-canister.htm"),
    Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/american_canister.htm")
  ),
  description = "A difficult variation of ^canister^ with building by alternate colors.",
  layout = "::f|t",
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
      cardsFaceDown = TableauFaceDownCards.Count(0)
    )
  )
)
