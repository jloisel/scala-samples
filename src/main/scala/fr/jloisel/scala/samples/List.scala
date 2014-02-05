package fr.jloisel.scala.samples

import java.util.NoSuchElementException

trait List[+T] {
	def isEmpty : Boolean
	def head : T
	def tail : List[T]
}

object List {
	def nth[T](index: Int, list: List[T]): T = {
		if(list.isEmpty) throw new IndexOutOfBoundsException
		if(index == 0) list.head
		nth(index - 1, list.tail)
	}

	def singleton[T](value: T) : List[T] = new Cell(value, Nil)
}

case object Nil extends List[Nothing] {
	def isEmpty = true
	def head = throw new NoSuchElementException("Nil.head")
	def tail = throw new NoSuchElementException("Nil.tail")
}

case class Cell[T](val head: T, val tail: List[T]) extends List[T] {
	def isEmpty = false
}