package models.database.queries.audit

import java.util.UUID

import models.audit.ClientTraceResult
import models.database.Row
import models.database.queries.BaseQueries
import org.joda.time.LocalDateTime
import play.api.libs.json.{ JsObject, Json }

object ClientTraceQueries extends BaseQueries[ClientTraceResult] {
  override protected val tableName = "client_trace"
  override protected val columns = Seq("id", "player", "data", "created")
  override protected val searchColumns = Seq("id::text", "player::text", "data::text")

  def getById(id: UUID) = getBySingleId(id)
  val insert = Insert
  val removeById = RemoveById
  val search = Search
  def searchCount(q: String, groupBy: Option[String] = None) = new SearchCount(q, groupBy)

  override protected def fromRow(row: Row) = {
    val id = UUID.fromString(row.as[String]("id"))
    val player = UUID.fromString(row.as[String]("player"))
    val data = Json.parse(row.as[String]("data")).as[JsObject]
    val created = row.as[LocalDateTime]("created")
    ClientTraceResult(id, player, data, created)
  }

  override protected def toDataSeq(ct: ClientTraceResult) = Seq(ct.id, ct.player, Json.prettyPrint(ct.data), ct.created)
}
