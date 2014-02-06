package fr.jloisel.scala.samples

object ListOperation {
	def square(list: List[Int]) : List[Int] = list match {
	  case Nil => list
	  case head :: tail => head * head :: square(tail)
	}
	
	def squareList(list: List[Int]) : List[Int] = list map (x => x * x)
	
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
}