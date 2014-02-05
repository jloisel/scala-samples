package fr.jloisel.scala.samples

import org.junit.Test

class ImmutablePersonTest {
  @Test def shouldModifyFirstname = {
    val person = new ImmutablePerson("Jerome", "Loisel")
    assert("Loisel" equals person.lastname)
  }
}