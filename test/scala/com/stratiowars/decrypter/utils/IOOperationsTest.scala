package scala.com.stratiowars.decrypter.utils

import com.stratiowars.decrypter.utils.IOOperations._
import com.stratiowars.decrypter.utils.inputAnalyser.decCoord
import org.scalatest.FunSuite
import play.api.libs.json.{JsValue, Json}
import scala.collection.mutable.ArrayBuffer


class IOOperationsTest extends FunSuite {

  test("testValidateCorrectJson") {
    val file: String = scala.io.Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("testDataCorrect.json")).mkString
    val json: JsValue = Json.parse(file)
    val expected = List(Coordinates(galaxy = "6f9c15fa",
      quadrant = "ef51",
      starsystem1 = "4415",
      starsystem2 = "afab",
      planet = "36218d76c2d9"))

    assert(jsonvalidator(json).left.get equals expected)
  }

  test("testValidateJsonWithIncorrectDataFormat") {
    val file: String = scala.io.Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("testDataWithInt.json")).mkString
    val json: JsValue = Json.parse(file)
    assert(jsonvalidator(json).isRight)
  }


  test("testValidateJsonWithFieldTooLong") {
    val file: String = scala.io.Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("testDataFieldTooLong.json")).mkString
    val json: JsValue = Json.parse(file)
    assert(jsonvalidator(json).isRight)
  }


  test("testValidateJsonWithFieldTooShort") {
    val file: String = scala.io.Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("testDataFieldTooShort.json")).mkString
    val json: JsValue = Json.parse(file)
    assert(jsonvalidator(json).isRight)
  }

  test("testValidateJsonWithCharNotLetterOrNumber") {
    val file: String = scala.io.Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("testDataFieldWithSymbol.json")).mkString
    val json: JsValue = Json.parse(file)
    assert(jsonvalidator(json).isRight)
  }

  test("testDecryptedCoordsToJsonValidData") {
    val file: String = scala.io.Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("testDataValidDecCoords.json")).mkString
    val expected: JsValue = Json.parse(file)
    val testValue = ArrayBuffer[decCoord]()
    testValue += decCoord(22, 10, 42, "edcb86430")

    assert(decCoord2Json(testValue) equals expected)
  }

}


