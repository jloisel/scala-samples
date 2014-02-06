package fr.jloisel.scala.samples

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class ListOperationSpec extends FlatSpec with Matchers {

  "List(a,a,a,b,b) " should "be packed into List(List(a,a,a),List(b,b))" in {
    val list = List("a","a","a","b","b")
    ListOperation pack list should be (List(List("a","a","a"), List("b","b")))
  }
  
    "List(a,a,a,b,b) " should "be encoded into List((a,3),(b,2))" in {
    val list = List("a","a","a","b","b")
    ListOperation encode list should be (List(("a",3), ("b",2)))
  }
}