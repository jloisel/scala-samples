package fr.jloisel.scala.samples

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class MergeSortSpec extends FlatSpec with Matchers {

  "An unsorted list" should "be sorted" in {
    val list = List(1, 3, 2, 5, 9, 4)
    MergeSort(list) should be (List(1, 2, 3, 4, 5, 9))
  }
}