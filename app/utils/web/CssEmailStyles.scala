package utils.web

import models.ui.Colors

case class CssEmailStyles(colorId: String) {
  val colorHex = Colors.allById(colorId)
  val alignRight = "text-align: right;"

  val body = s"background-color: #$colorHex; text-align: center; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;"

  val logoSource = s"https://solitaire.gg/assets/images/ui/favicon/favicon-$colorId.png"
  val logo = "width: 64px; height: 64px;"

  val title = "color: #ffffff; font-size: 125%;"
  val subtitle = "color: #ffffff;"

  val module = "background-color: #ffffff; margin: 10px; padding: 10px; border-radius: 10px; text-align: left;"

  val table = "width: 100%;"
  val tr = ""
  val th = "padding: 5px;"
  val td = "padding: 5px; border-top: 1px solid #ddd;"
}
