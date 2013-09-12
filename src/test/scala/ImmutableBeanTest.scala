import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test
import fr.jloisel.scala.samples.ImmutableBean

class ImmutableBeanTest {

  @Test def shouldReturnName = {
    var bean = new ImmutableBean("name", "")
    assert("name" equals (bean getName))
  }
  
    @Test def shouldReturnDescription = {
    var bean = new ImmutableBean("", "description")
    assert("description" equals (bean getDescription))
  }
}