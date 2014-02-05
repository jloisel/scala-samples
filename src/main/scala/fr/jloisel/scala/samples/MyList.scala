package fr.jloisel.scala.samples

import java.util.NoSuchElementException

trait MyList[+T] {
	def isEmpty : Boolean
	def head : T
	def tail : MyList[T]
	def addToHead[R >: T](value : R) : MyList[R]
	def addToTail[R >: T](value : R) : MyList[R]
}

case object EmptyList extends MyList[Nothing] {
	def isEmpty = true
	def head = throw new NoSuchElementException("Nil.head")
	def tail = throw new NoSuchElementException("Nil.tail")
	def addToHead[R >: Nothing](value : R) : MyList[R] = this addToTail value
	def addToTail[R >: Nothing](value : R) : MyList[R] = new Cell(value)
}

case class Cell[T](head: T, tail: MyList[T]) extends MyList[T] {
	def this(head: T) = this(head, EmptyList)
	def isEmpty = false
	def addToHead[R >: T](value : R) : MyList[R] = new Cell(value, this)
	def addToTail[R >: T](value : R) : MyList[R] = new Cell(head, tail addToTail value)
}

object MyList {
	def nth[T](index: Int, list: MyList[T]): T = {
		if(list.isEmpty) throw new IndexOutOfBoundsException
		if(index == 0) list.head
		nth(index - 1, list.tail)
	}
	
	def apply[T]() : MyList[T] = EmptyList
	def apply[T](first: T) : MyList[T] = new Cell(first)
	def apply[T](first: T, second: T) : MyList[T] = apply(first) addToTail second
	def apply[T](first: T, second: T, third: T) : MyList[T] = apply(first, second) addToTail third
}