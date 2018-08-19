package com.stratiowars.decrypter.algorithms

import com.stratiowars.decrypter.utils.inputAnalyser.hex

object starSystemAlgorithm {
  def process(encSs1: String, encSs2: String): BigDecimal = {
    val combinedStarSys: List[(Char, Char)] = encSs1.toLowerCase.zip(encSs2.toLowerCase).toList
    val maxElemSs: List[Char] = combinedStarSys.map(x => x._1 max x._2)
    maxElemSs.map(x => hex(x.toString())).sum
  }
}
