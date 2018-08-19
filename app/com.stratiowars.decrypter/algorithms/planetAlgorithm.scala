package com.stratiowars.decrypter.algorithms

object planetAlgorithm {
  def process(encPlanet: String): String = {
    encPlanet.toLowerCase.distinct.sorted.reverse
  }
}
