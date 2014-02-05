package fr.jloisel.scala.samples

abstract class Bool {
	def ifThenElse[T](t: => T, e: => T) : T
	
	def && (x : => Bool) : Bool = ifThenElse(x, False)
	def || (x : => Bool) : Bool = ifThenElse(True, x)
	def unary_! : Bool = ifThenElse(False, True)
	
	def == (x: Bool) = ifThenElse(x, x.unary_!)
	def != (x: Bool) = ifThenElse(x.unary_!, x)
	
	def < (x: Bool) = ifThenElse(False, x)
}

object True extends Bool {
  def ifThenElse[T](t: => T, e: => T) = t
}

object False extends Bool {
  def ifThenElse[T](t: => T, e: => T) = e
}