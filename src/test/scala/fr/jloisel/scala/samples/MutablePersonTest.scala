package fr.jloisel.scala.samples

import org.junit.Test

class MutablePersonTest {
  @Test def shouldModifyFirstname = {
    val person = new MutablePerson("Jerome", "Loisel")
    person.lastname = "Dupont"
    assert("Dupont" equals person.lastname)
  }
}