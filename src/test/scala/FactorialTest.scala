import org.junit.Test
import fr.jloisel.scala.samples.Factorial._

class FactorialTest {

  /**
   * 0! == 1
   */
  @Test def shouldReturnOneOfZero() {
    assert(1 == factorial(0))
  }
  
   /**
   * 1! == 1
   */
  @Test def shouldReturnOne() {
    assert(1 == factorial(1))
  }
  
    /**
   * 3! == 6
   */
  @Test def shouldReturnSix() {
    assert(6 == factorial(3))
  }
}