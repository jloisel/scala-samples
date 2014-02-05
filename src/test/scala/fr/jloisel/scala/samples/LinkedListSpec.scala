package fr.jloisel.scala.samples

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class MyLinkedListSpec extends FlatSpec with Matchers {

  "An empty list" should "be empty" in {
    val list = EmptyLinkedList
    list.isEmpty should be (true)
  }
  
  it should "throw NoSuchElementException if an empty list head is retrieved" in {
    val list = EmptyLinkedList
    a [NoSuchElementException] should be thrownBy {
      list.head
    }
  }
  
  it should "throw NoSuchElementException if an empty list tail is retrieved" in {
    val list = EmptyLinkedList
    a [NoSuchElementException] should be thrownBy {
      list.tail
    }
  }
}