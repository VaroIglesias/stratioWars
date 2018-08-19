package com.stratiowars.decrypter.algorithms

import com.stratiowars.decrypter.utils.inputAnalyser.hex

object galaxyAlgorithm {
  def process(encGalaxy: String): BigDecimal = {
    val galaxy2List: List[String] = encGalaxy.toLowerCase.map(x => x.toString).toList
    galaxy2List.map(x => hex(x)).sum
  }
}
