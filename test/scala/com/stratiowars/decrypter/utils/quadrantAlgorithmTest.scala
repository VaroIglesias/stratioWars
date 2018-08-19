package scala.com.stratiowars.decrypter.utils

import org.scalatest.FunSuite
import com.stratiowars.decrypter.algorithms.quadrantAlgorithm

class quadrantAlgorithmTest extends FunSuite{

  test("testSuccessfulDecryption"){
  val testvalue = "0a94"
  val expected: BigDecimal = 10
  assert(quadrantAlgorithm.process(testvalue) equals expected)
}

test("testIncorrectDataType"){
  val testvalue = 555
  assertDoesNotCompile("quadrantAlgorithm.process(testvalue)")
}

  test("testIncorrectDataFormat") {
  val testvalue = "zmcxiog34"
  assertThrows[java.lang.NumberFormatException]{
  quadrantAlgorithm.process(testvalue)
}
}

}
