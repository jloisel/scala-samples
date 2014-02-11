package fr.jloisel.scala.samples

class ImmutablePerson(val firstname: String, val lastname: String, val age: Int) {

	override def toString = firstname + ", " + lastname + " (" + age + ")"
}

object ImmutablePerson {
	def nameOfPersonsOlderThan(age: Int, persons: List[ImmutablePerson]) : List[String] = {
			for(person <- persons if person.age >= age) yield person.firstname
	}

	def nameOfPersonsOlderThan2(age: Int, persons: List[ImmutablePerson]) : List[String] = {
			persons filter (_.age >= age) map (_.firstname)
	}
}