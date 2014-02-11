package fr.jloisel.scala.samples

class Math {
  def sum(i: Int): Int = {
    var sum = 0
    for(j <- 1 to i)
      sum += j
    sum
  }
  
  def scalarProduct(xs: List[Double], ys: List[Double]) : Double = {
    (for((x, y) <- xs zip ys) yield x * y).sum
  }
}