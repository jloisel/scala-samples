package fr.jloisel.scala.samples.pouring

import org.scalatest.Matchers
import org.scalatest.FlatSpec

class PouringSpec extends FlatSpec with Matchers {

  "A problem of two glasses " should " have 6 possibles moves" in {
    val problem = new Pouring(Vector(4, 7))
    problem.moves.size should be (6)
  }
  
  "A problem of three glasses " should " have 12 possibles moves" in {
    val problem = new Pouring(Vector(4, 7, 9))
    problem.moves.size should be (12)
  }
  
    "A problem of two glasses of 1 and 3 liters" should " have a solution with 2 liters poured in one" in {
	  val problem = new Pouring(Vector(1, 3))
	  problem.solution(3).head
  }
}