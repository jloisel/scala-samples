package fr.jloisel.scala.samples

import org.junit.Test

class MathTest {
  
  @Test def shouldReturnSum() {
    val sum = new Math
    assert(1 == sum.sum(1))
  }
  
    @Test def shouldReturnSum2() {
    val sum = new Math
    assert(6 == sum.sum(3))
  }
}