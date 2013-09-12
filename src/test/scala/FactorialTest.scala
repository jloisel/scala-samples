import org.junit.Test

import fr.jloisel.scala.samples.Factorial

class FactorialTest {

  /**
   * 1! == 1
   */
  @Test def shouldReturnOne() {
    var fact = new Factorial
    assert(1 == fact.compute(BigInt.int2bigInt(1)))
  }
}