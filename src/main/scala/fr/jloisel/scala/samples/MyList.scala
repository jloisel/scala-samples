package fr.jloisel.scala.samples

import java.util.NoSuchElementException

trait MyList[T] {
	def isEmpty : Boolean
	def head : T
	def tail : MyList[T]
	def addToHead(value : T) : MyList[T]
	def addToTail(value : T) : MyList[T]
}

case class EmptyList[T] extends MyList[T] {
	def isEmpty = true
	def head = throw new NoSuchElementException("Nil.head")
	def tail = throw new NoSuchElementException("Nil.tail")
	def addToHead(value: T) = this addToTail value
	def addToTail(value: T) = new Cell(value)
}

case class Cell[T](head: T, tail: MyList[T]) extends MyList[T] {
	def this(head: T) = this(head, new EmptyList)
	def isEmpty = false
	def addToHead(value : T) = new Cell(value, new Cell(head, tail))
	def addToTail(value : T) = new Cell(head, tail addToTail value)
}

object MyList {
	def nth[T](index: Int, list: MyList[T]): T = {
		if(list.isEmpty) throw new IndexOutOfBoundsException
		if(index == 0) list.head
		nth(index - 1, list.tail)
	}
	
	def apply[T]() : MyList[T] = new EmptyList
	def apply[T](first: T) : MyList[T] = new Cell(first)
	def apply[T](first: T, second: T) : MyList[T] = apply(first) addToTail second
	def apply[T](first: T, second: T, third: T) : MyList[T] = apply(first, second) addToTail third
}