package scala.com.stratiowars.decrypter.utils

import org.scalatest.FunSuite
import com.stratiowars.decrypter.algorithms.planetAlgorithm

class planetAlgorithmTest  extends FunSuite{
  test("testSuccessfulDecryption") {
    val testvalue = "448dc6e30b08"
    val expected: String = "edcb86430"
    assert(planetAlgorithm.process(testvalue) equals expected)
  }

  test("testIncorrectDataType") {
    val testvalue = 555
    assertDoesNotCompile("planetAlgorithm.process(testvalue)")
  }
}
