package phaser.card

import com.definitelyscala.phaser.Point
import phaser.playmat.Playmat

object CardAnimation {
  private[this] val driftMax = 20
  private[this] val growthMax = 0.01

  def win(playmat: Playmat) = {
    val animationDimensions = (playmat.game.world.width / playmat.scale.x) -> (playmat.game.world.height / playmat.scale.y)
    val playmatOrigin = (playmat.x / playmat.scale.x) -> (playmat.y / playmat.scale.y)

    playmat.getCards.foreach { x =>
      val (card, _, _) = x
      var spin = Math.random() * 3
      var driftX = (Math.random() * (driftMax * 2)) - driftMax
      var driftY = (Math.random() * (driftMax * 2)) - driftMax
      var growthDelta = (Math.random() * (growthMax * 2)) - growthMax
      card.animation = Some(() => {
        card.angle += spin
        card.x += driftX
        card.y += driftY

        var scaleX = card.scale.x + growthDelta
        var scaleY = card.scale.y + growthDelta
        if (scaleX > 1.5 || scaleX < 0.5) {
          growthDelta = -growthDelta
        }
        card.scale = new Point(x = scaleX, y = scaleY)

        if ((card.x + playmatOrigin._1) < 0 || (card.x + playmatOrigin._1) > animationDimensions._1) {
          driftX = -driftX
        }
        if ((card.y + playmatOrigin._2) < 0 || (card.y + playmatOrigin._2) > animationDimensions._2) {
          driftY = -driftY
        }
      })
    }
  }
}
