package settings

import phaser.card.CardSet

object PlayerSettings {
  val default = PlayerSettings()
}

case class PlayerSettings(
  cardSet: CardSet = CardSet.default,
  cardBack: CardBack = CardBack.A,
  cardBackground: CardBackground = CardBackground.A,
  cardFaces: CardFaces = CardFaces.A,
  cardLayout: CardLayout = CardLayout.A,
  cardRanks: CardRanks = CardRanks.A,
  cardSuits: CardSuits = CardSuits.A
)
