package fr.jloisel.scala.samples

object Pascal extends App {

  def compute(c: Int, r: Int): Int = {
    c match {
      case 0 => 1
      case `r` => 1
      case _ => compute(c, r - 1) + compute(c - 1, r - 1)
    }
  }
  
  println(compute(2, 4))
}