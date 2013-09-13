import org.junit.Test
import fr.jloisel.scala.samples.ImmutablePerson

class ImmutablePersonTest {
  @Test def shouldModifyFirstname = {
    val person = new ImmutablePerson("Jerome", "Loisel")
    assert("Loisel" equals person.lastname)
  }
}