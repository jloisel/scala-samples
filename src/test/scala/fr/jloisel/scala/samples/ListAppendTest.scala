package fr.jloisel.scala.samples

import org.junit.Test
import scala.collection.immutable._

class ListAppendTest {
	@Test def shouldReturnExpectedList = {
			val person = new ListAppending
			assert(List(1,2,3) equals person.getA)
	}
}