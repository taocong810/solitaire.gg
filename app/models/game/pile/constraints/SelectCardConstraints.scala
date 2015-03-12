package models.game.pile.constraints

import models.game.Card
import models.game.pile.Pile

object SelectCardConstraints {
  def never(pile: Pile, card: Card) = false
  def isTopCard(pile: Pile, card: Card) = pile.cards.lastOption == Some(card)

  def apply(key: Option[String]) = key match {
    case Some(k) => k match {
      case "top-card-only" => isTopCard _
      case _ => throw new IllegalArgumentException("Invalid select card constraint [" + k + "].")
    }
    case None => never _
  }
}