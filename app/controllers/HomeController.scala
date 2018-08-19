package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import com.typesafe.scalalogging.LazyLogging
import com.stratiowars.decrypter.encryptionBreaker
/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with LazyLogging {

  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def decrypter = Action { request =>
    logger.info("parsing provided json")
    val json: JsValue = request.body.asJson.get
    logger.info("initiating decryption process")

    Ok(encryptionBreaker.main(json))
  }
}
