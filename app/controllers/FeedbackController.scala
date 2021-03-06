package controllers

import java.util.UUID

import models.audit.UserFeedback
import models.queries.audit.UserFeedbackQueries
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import services.database.Database
import services.email.EmailService
import utils.{Application, DateUtils}

import scala.concurrent.Future

@javax.inject.Singleton
class FeedbackController @javax.inject.Inject() (override val app: Application, emailService: EmailService) extends BaseController {
  def feedbackForm = req("form") { implicit request =>
    Future.successful(Ok(views.html.feedback()))
  }

  def submitFeedback = req("submit") { implicit request =>
    request.body.asFormUrlEncoded match {
      case Some(form) => form.get("feedback") match {
        case Some(feedback) =>
          val obj = UserFeedback(
            id = UUID.randomUUID,
            deviceId = UUID.randomUUID,
            activeGameId = None,
            feedback = feedback.mkString("\n\n"),
            occurred = DateUtils.now
          )

          emailService.feedbackSubmitted(obj)

          Database.execute(UserFeedbackQueries.insert(obj)).map { x =>
            Redirect(routes.FeedbackController.feedbackForm()).flashing("success" -> "Your feedback has been submitted. Thanks!")
          }
        case None => Future.successful(Redirect(routes.FeedbackController.feedbackForm()).flashing("error" -> "Please include some feedback."))
      }
      case None => Future.successful(Redirect(routes.FeedbackController.feedbackForm()).flashing("error" -> "Please include some feedback."))
    }
  }
}
