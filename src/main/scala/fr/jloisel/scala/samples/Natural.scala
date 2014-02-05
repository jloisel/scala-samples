package fr.jloisel.scala.samples

sealed abstract class Natural {
	def isZero : Boolean
	def predecessor : Natural
	final def successor = new Succ(this)
	def + (that: Natural) : Natural
	def - (that: Natural) : Natural
}

object Zero extends Natural {
  def isZero = true
  def predecessor = throw new UnsupportedOperationException
  def + (that: Natural) = that
  def - (that: Natural) = if(that.isZero) this else throw new UnsupportedOperationException
}

class Succ(n: Natural) extends Natural {
  def isZero = false
  def predecessor = n
  def + (that: Natural) = new Succ(n + that)
  def - (that: Natural) = if(that.isZero ) this else n - that.predecessor
}