import org.junit.Test
import fr.jloisel.scala.samples.Math
import fr.jloisel.scala.samples.Math

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