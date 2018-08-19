package com.stratiowars.decrypter

import com.typesafe.scalalogging.LazyLogging
import play.api.libs.json.{JsError, JsValue}

import scala.collection.mutable.ArrayBuffer
import com.stratiowars.decrypter.utils.IOOperations.Coordinates
import com.stratiowars.decrypter.utils.inputAnalyser.decCoord
import com.stratiowars.decrypter.utils.IOOperations
import com.stratiowars.decrypter.utils.inputAnalyser

object encryptionBreaker extends LazyLogging {
  def main(json: JsValue): JsValue = {
    val decryptedCoords = new ArrayBuffer[decCoord]

    logger.info("Validating contents of json")

    val encryptedCoords: Either[List[Coordinates], JsValue] = IOOperations.jsonvalidator(json: JsValue)

    try {
      logger.info("attempting to decrypt the coordinates")
      encryptedCoords.left.get.foreach(coordsToDecrypt => decryptedCoords += inputAnalyser.main(coordsToDecrypt: Coordinates))
    }
    catch {
      case e: Exception =>
        logger.error("Error validating the input json: " + encryptedCoords.right.get)
        return encryptedCoords.right.get
    }
    logger.info("coordinates decrypted. Parsing them to Json format and printing them on screen")
    IOOperations.decCoord2Json(decryptedCoords)
  }
}