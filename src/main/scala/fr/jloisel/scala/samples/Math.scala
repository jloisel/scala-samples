package fr.jloisel.scala.samples

class Math {
  def sum(i: Int): Int = {
    var sum = 0
    for(j <- intWrapper(1) to i)
      sum += j
    return sum
  }
}