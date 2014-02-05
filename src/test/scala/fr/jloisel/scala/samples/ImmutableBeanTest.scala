package fr.jloisel.scala.samples

import org.junit.Test

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