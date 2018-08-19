package scala.com.stratiowars.decrypter.utils

import com.stratiowars.decrypter.algorithms.starSystemAlgorithm
import org.scalatest.FunSuite

class starSystemAlgorithmTest extends FunSuite {
  test("testSuccessfulDecryption") {
    val testvalue1 = "446b"
    val testvalue2 = "8bcb"
    val expected: BigDecimal = 42
    assert(starSystemAlgorithm.process(testvalue1, testvalue2) equals expected)
  }

  test("testIncorrectDataType") {
    val testvalue1 = 555
    val testvalue2 = "8bcb"
    assertDoesNotCompile("starSystemAlgorithm.process(testvalue1, testvalue2)")
  }

  test("testIncorrectDataFormat") {
    val testvalue1 = "446bzz"
    val testvalue2 = "8bcbac"
    assertThrows[java.lang.NumberFormatException] {
      starSystemAlgorithm.process(testvalue1,testvalue2)
    }
  }
}
