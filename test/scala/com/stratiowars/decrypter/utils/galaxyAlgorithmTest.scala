package scala.com.stratiowars.decrypter.utils

import org.scalatest.FunSuite
import com.stratiowars.decrypter.algorithms.galaxyAlgorithm

class galaxyAlgorithmTest extends FunSuite {
  test("testSuccessfulDecryption") {
    val testvalue = "6f9c15fa"
    val expected: BigDecimal = 73
    assert(galaxyAlgorithm.process(testvalue) equals expected)
  }

  test("testIncorrectDataType") {
    val testvalue = 555
    assertDoesNotCompile("galaxyAlgorithm.process(testvalue)")
  }

  test("testIncorrectDataFormat") {
    val testvalue = "zmcxiog34"
    assertThrows[java.lang.NumberFormatException] {
      galaxyAlgorithm.process(testvalue)
    }
  }

}
