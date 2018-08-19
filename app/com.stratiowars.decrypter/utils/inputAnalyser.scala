package com.stratiowars.decrypter.utils

import com.stratiowars.decrypter.algorithms._
import com.stratiowars.decrypter.utils.IOOperations.Coordinates
import com.typesafe.scalalogging.LazyLogging

object inputAnalyser extends LazyLogging {

  case class decCoord(decGalaxy: BigDecimal, decQuad: BigDecimal, decSs: BigDecimal, decPlanet: String)

  def hex(s: String): BigDecimal = {
    Integer.parseInt(s, 16)
  }

  def main(encryptedCoords: Coordinates): decCoord = {

    logger.info("decrypting galaxy")
    val decGal: BigDecimal = galaxyAlgorithm.process(encryptedCoords.galaxy)

    logger.info("decrypting quadrant")
    val decQuad: BigDecimal = quadrantAlgorithm.process(encryptedCoords.quadrant)

    logger.info("decrypting star system")
    val decSs: BigDecimal = starSystemAlgorithm.process(encryptedCoords.starsystem1, encryptedCoords.starsystem2)

    logger.info("decrypting planet")
    val decPlanet: String = planetAlgorithm.process(encryptedCoords.planet)

    new decCoord(decGal, decQuad, decSs, decPlanet)
  }
}
