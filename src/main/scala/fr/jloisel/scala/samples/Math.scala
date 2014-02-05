package fr.jloisel.scala.samples

class Math {
  def sum(i: Int): Int = {
    var sum = 0
    for(j <- 1 to i)
      sum += j
    sum
  }
}