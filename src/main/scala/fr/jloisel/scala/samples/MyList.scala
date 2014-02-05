package fr.jloisel.scala.samples

import java.util.NoSuchElementException

trait MyList[+T] {
	def isEmpty : Boolean
	def head : T
	def tail : MyList[T]
}

object MyList {
	def nth[T](index: Int, list: MyList[T]): T = {
		if(list.isEmpty) throw new IndexOutOfBoundsException
		if(index == 0) list.head
		nth(index - 1, list.tail)
	}

	def singleton[T](value: T) : MyList[T] = new Cell(value, EmptyList)
}

case object EmptyList extends MyList[Nothing] {
	def isEmpty = true
	def head = throw new NoSuchElementException("Nil.head")
	def tail = throw new NoSuchElementException("Nil.tail")
}

case class Cell[T](val head: T, val tail: MyList[T]) extends MyList[T] {
	def isEmpty = false
}