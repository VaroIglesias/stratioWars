package scala.com.stratiowars.decrypter.utils

import com.stratiowars.decrypter.utils.IOOperations.Coordinates
import org.scalatest.FunSuite
import com.stratiowars.decrypter.utils.inputAnalyser._

class inputAnalyserTest extends FunSuite {
  test("testHexValueofletter") {
    val expected: Int = 14
    val testValue: String = "e"
    assert(hex(testValue) equals expected)
  }

  test("testHexValueOfNumericChar") {
    val expected: Int = 7
    val testValue: String = "7"
    assert(hex(testValue) equals expected)
  }

  test("testHexException") {
    val expected: Int = 7
    val testValue: String = "%"
    assertThrows[java.lang.NumberFormatException]{
      hex(testValue)
    }
  }

  test("testValidDecCoordObject") {
    val testvalue = Coordinates("6f9c15fa","ef51","4415","afab","36218d76c2d9")
    val expected = decCoord(73, 15, 46, "dc9876321")
    assert(main(testvalue) equals expected)
  }
}
