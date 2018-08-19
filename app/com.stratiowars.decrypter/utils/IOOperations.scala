package com.stratiowars.decrypter.utils


import com.typesafe.scalalogging.LazyLogging
import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._
import scala.collection.mutable.ArrayBuffer
import com.stratiowars.decrypter.utils.inputAnalyser.decCoord


object IOOperations extends LazyLogging {

  case class Coordinates(galaxy: String, quadrant: String, starsystem1: String, starsystem2: String, planet: String)


  //method to validate contents of json file
  def jsonvalidator(json: JsValue): Either[List[Coordinates], JsValue] = {
    implicit val coordinatesReads: Reads[Coordinates] = (
      (JsPath \ "galaxy").read[String].filter(JsonValidationError("galaxy field is not format compliant"))(x => x.forall(_.isLetterOrDigit) && x.length == 8) and
        (JsPath \ "quadrant").read[String].filter(JsonValidationError("quadrant field is not format compliant"))(x => x.forall(_.isLetterOrDigit) && x.length == 4) and
        (JsPath \ "starsystem1").read[String].filter(JsonValidationError("starsystem1 field is not format compliant"))(x => x.forall(_.isLetterOrDigit) && x.length == 4) and
        (JsPath \ "starsystem2").read[String].filter(JsonValidationError("starsystem2 field is not format compliant"))(x => x.forall(_.isLetterOrDigit) && x.length == 4) and
        (JsPath \ "planet").read[String].filter(JsonValidationError("planet field is not format compliant"))(x => x.forall(_.isLetterOrDigit) && x.length == 12)
      ) (Coordinates.apply _)

    val validatedjson: Either[List[Coordinates], JsValue] = json.validate[List[Coordinates]] match {
      case success: JsSuccess[List[Coordinates]] => {
        Left(success.get)
      }
      case err: JsError => {
        Right(JsError.toJson(err))
      }
    }
    validatedjson
  }

  def decCoord2Json(decCoordList: ArrayBuffer[decCoord]): JsValue = {
    implicit val decCoordWrites: Writes[decCoord] = (
      (JsPath \ "galaxy").write[BigDecimal] and
        (JsPath \ "quadrant").write[BigDecimal] and
        (JsPath \ "starsystem").write[BigDecimal] and
        (JsPath \ "planet").write[String]
      ) (unlift(decCoord.unapply))

    Json.toJson(decCoordList)
  }


}
