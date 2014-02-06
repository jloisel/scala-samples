package fr.jloisel.scala.samples

trait Expr {
	def eval : Int
	def show : String
}

case class Number(x: Int) extends Expr {
	def eval = x
	def show = x.toString
}

sealed abstract class Operation(left: Expr, right: Expr) extends Expr {
  final def eval = apply(left, right)
  final def show = left.show + " " + operator + " " + right.show
  
  protected def apply(left: Expr, right: Expr) : Int
  protected def operator : String
}

case class Sum(left: Expr, right: Expr) extends Operation(left, right) {
  protected def apply(left: Expr, right: Expr) = left.eval + right.eval
  protected def operator = "+"
}

case class Product(left: Expr, right: Expr) extends Operation(left, right) {
  protected def apply(left: Expr, right: Expr) = left.eval * right.eval
  protected def operator = "*"
}