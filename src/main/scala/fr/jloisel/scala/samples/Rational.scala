package fr.jloisel.scala.samples

import scala.language.implicitConversions

trait Rational {
	implicit def int2Rational(x: Int) : Rational

	def unary_- : Rational
	def inverse : Rational = 1 / this
	def + (other: Rational) : Rational
	def * (other: Rational) : Rational
	final def - (other: Rational) = this + -other
	final def / (other: Rational) = this * other.inverse
}

case class FiniteRational(n : Int, d : Int) extends Rational {
	require(n > 0, "denominator must be positive")
	private val g = gcd(n, d)
	private val num = n / g
	private val denum = d / g

	private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

	override implicit def int2Rational(x: Int) : Rational = new FiniteRational(x, 1)

	override def unary_- = new FiniteRational(-num, denum)
	override def inverse = new FiniteRational(denum, num)

	override def + (other: Rational): Rational = other match {
		case FiniteRational(0, d) => this
		case FiniteRational(n,d) => new FiniteRational(num * d + n * denum, denum * d)
		case _ => throw new UnsupportedOperationException()
	}

	override def * (other: Rational): Rational = other match {
		case FiniteRational(n,d) => new FiniteRational(num * n, denum * d)
		case _ => throw new UnsupportedOperationException()
	}

	override def toString = num + "/" + denum
}
