package fr.jloisel.scala.samples

object ListOperation {
	def square(list: List[Int]) : List[Int] = list match {
	  case Nil => list
	  case head :: tail => head * head :: square(tail)
	}
	
	/**
	 * Computes The square of elements and returns the result list.
	 */
	def squareList(list: List[Int]) : List[Int] = list map (x => x * x)
	
	/**
	 * Applies the function f(x) to each element of the list, returning the 
	 * processed list.
	 */
	def map(list: List[Int])(f: Int => Int) : List[Int] = list match {
	  case Nil => list
	  case head :: tail => f(head) :: map(tail)(f)
	}
	
	/**
	 * Packs List("a", "a", "b") into List(List("a", "a"), List("b"))
	 */
	def pack[T](xs: List[T]): List[List[T]] = xs match {
    	case Nil      => Nil
    	case x :: xs1 => {
    	  val (first, rest) = xs span (y => y == x)
    	  first :: pack(rest)
    	}
	}
	
	/**
	 * Encodes List("a", "a", "b") into List(("a", 2), ("b",1))
	 */
	def encode[T](xs: List[T]): List[(T,Int)] = pack(xs) map (ys => (ys.head, ys.length))
	
	/**
	 * Concatenates the two input lists.
	 */
	def concat[T](xs: List[T], ys: List[T]): List[T] = (xs foldRight ys) (_ :: _)
	
	/**
	 * Applies the function f(x) to each element of the list, returning the 
	 * processed list.
	 */
	def mapFun[T, U](xs: List[T], f: T => U): List[U] = (xs foldRight List[U]())(f(_) :: _)

	/**
	 * Returns the length of the list.
	 */
	def lengthFun[T](xs: List[T]): Int = (xs foldRight 0)((x, y) => 1 + y)
}