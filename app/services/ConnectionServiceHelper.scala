package services

import java.util.UUID

import akka.actor.ActorRef
import models._
import play.api.libs.json.{ Json, JsObject }
import utils.metrics.InstrumentedActor

trait ConnectionServiceHelper extends InstrumentedActor { this: ConnectionService =>
  protected[this] def handleStartGame(gameType: String, seed: Option[Int]) {
    supervisor ! CreateGame(gameType, id, seed)
  }

  protected[this] def handleJoinGame(gameId: UUID) = {
    supervisor ! ConnectionGameJoin(gameId, id)
  }

  protected[this] def handleObserveGame(gameId: UUID, as: Option[UUID]) = {
    supervisor ! ConnectionGameObserve(gameId, id, as)
  }

  protected[this] def handleGameMessage(gm: GameMessage) = activeGame match {
    case Some(ag) => ag forward GameRequest(accountId, gm)
    case None => throw new IllegalArgumentException("Received game message [" + gm.getClass.getSimpleName + "] while not in game.")
  }

  protected[this] def handleGameStarted(id: UUID, gameService: ActorRef) {
    activeGameId = Some(id)
    activeGame = Some(gameService)
  }

  protected[this] def handleGameStopped(id: UUID) {
    if (activeGameId != Some(id)) {
      throw new IllegalStateException("Provided game [" + id + "] is not the active game.")
    }
    activeGameId = None
    activeGame = None
  }

  protected[this] def handleConnectionTrace() {
    val ret = TraceResponse(id, List(
      "accountId" -> accountId,
      "name" -> name,
      "game" -> activeGameId.map { i =>
        "<a href=\"" + controllers.admin.routes.AdminController.traceGame(i) + "\" class=\"trace-link\">" + i + "</a>"
      }.getOrElse("Not in game")
    ))
    sender() ! ret
  }

  protected[this] def handleClientTrace() {
    pendingDebugChannel = Some(sender())
    out ! SendDebugInfo
  }

  protected[this] def handleDebugInfo(data: String) = pendingDebugChannel match {
    case Some(dc) => dc ! TraceResponse(id, Json.parse(data).as[JsObject].fields)
    case None => log.warn("Received unsolicited DebugInfo [" + data + "] from [" + id + "].")
  }

  protected[this] def handleResponseMessage(rm: ResponseMessage) {
    out ! rm
  }
}
