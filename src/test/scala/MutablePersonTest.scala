import org.junit.Test
import fr.jloisel.scala.samples.MutablePerson

class MutablePersonTest {
  @Test def shouldModifyFirstname = {
    val person = new MutablePerson("Jerome", "Loisel")
    person.lastname = "Dupont"
    assert("Dupont" equals person.lastname)
  }
}