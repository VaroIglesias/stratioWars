package com.stratiowars.decrypter.algorithms

import com.stratiowars.decrypter.utils.inputAnalyser.hex

object quadrantAlgorithm {
  def process(encQuadrant: String): BigDecimal = {
    val quad2List: List[String] = encQuadrant.toLowerCase.map(x => x.toString).toList
    quad2List.map(x => hex(x)).max
  }
}

