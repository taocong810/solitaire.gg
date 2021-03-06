package models.audit

import java.util.UUID

import org.joda.time.LocalDateTime
import play.api.libs.json.JsObject

case class ClientTraceResult(
  id: UUID,
  traceType: String,
  player: UUID,
  data: JsObject,
  created: LocalDateTime
)
