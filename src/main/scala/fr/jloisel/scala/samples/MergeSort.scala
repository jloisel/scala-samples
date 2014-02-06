package fr.jloisel.scala.samples

object MergeSort {
	def apply[T](list: List[T])(implicit ord: Ordering[T]) : List[T] = {
		val middle = list.length / 2
		if(middle == 0) list
		else {
			def merge(first: List[T], second: List[T]) : List[T] = (first, second) match {
				case (f, Nil) => first
				case (Nil, s) => second
				case (x :: xt, y :: yt) => if(ord lt (x,y)) x :: merge(xt, second) else y :: merge(first, yt)
			}
			val (first, second) = list splitAt middle
			merge(apply(first), apply(second))
		}
	}
}
