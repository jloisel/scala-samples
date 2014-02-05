package fr.jloisel.scala.samples

import java.util.NoSuchElementException

abstract class LinkedList[+T] {
	def isEmpty : Boolean
	def head : T
	def tail : LinkedList[T]
	def addToHead[B >: T](value : B) : LinkedList[B]
	def addToTail[B >: T](value : B) : LinkedList[B]
}

case object EmptyLinkedList extends LinkedList[Nothing] {
	def isEmpty = true
	def head = throw new NoSuchElementException("Nil.head")
	def tail = throw new NoSuchElementException("Nil.tail")
	def addToHead[B >: Nothing](value : B) = this addToTail value
	def addToTail[B >: Nothing](value : B) = new Node(value)
}

case class Node[T](head: T, tail: LinkedList[T]) extends LinkedList[T] {
	def this(head: T) = this(head, EmptyLinkedList)
	def isEmpty = false
	def addToHead[B >: T](value : B) = new Node(value, this)
	def addToTail[B >: T](value : B) = new Node(head, tail addToTail value)
}

object LinkedList {
	def nth[T](index: Int, list: LinkedList[T]): T = {
		if(list.isEmpty) throw new IndexOutOfBoundsException
		if(index == 0) list.head
		nth(index - 1, list.tail)
	}
	
	def apply[T]() : LinkedList[T] = EmptyLinkedList
	def apply[T](first: T) = new Node(first)
	def apply[T](first: T, second: T) = new Node(first) addToTail second
}