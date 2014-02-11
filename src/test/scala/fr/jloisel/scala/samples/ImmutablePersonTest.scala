package fr.jloisel.scala.samples

import org.junit.Test
import org.scalatest.FlatSpec
import org.scalatest.Matchers

class ImmutablePersonTest extends FlatSpec with Matchers {
  
  "list of person " should " be filtered by age and return firstnames using for loop" in {
    val jerome = new ImmutablePerson("Jerome", "L", 30)
    val justin = new ImmutablePerson("Justin", "B", 18)
    val persons = List(jerome, justin)
    
    ImmutablePerson nameOfPersonsOlderThan(20, persons) should be (List(jerome.firstname))
  }
  
  
  "list of person " should " be filtered by age and return firstnames using filter" in {
    val jerome = new ImmutablePerson("Jerome", "L", 30)
    val justin = new ImmutablePerson("Justin", "B", 18)
    val persons = List(jerome, justin)
    
    ImmutablePerson nameOfPersonsOlderThan2(20, persons) should be (List(jerome.firstname))
  }
}