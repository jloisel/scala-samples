package fr.jloisel.scala.samples

import scala.collection.immutable._

object Parenthesing extends App {

  def balance(chars: List[Char]): Boolean = {
    def balancer(chars: List[Char], counter: Int): Boolean = {
      if(counter < 0) false
      chars match {
        case Nil => counter == 0
        case head :: tail => {
          head match {
            case '(' => balancer(tail, counter + 1)
            case ')' => balancer(tail, counter - 1)
            case _ => balancer(tail, counter)
          }
        }
      }
    }
    
    balancer(chars, 0)
  }
  
  def balance(str: String): Boolean = balance(str.toList)
  
  println(balance("(if (zero? x) max (/ 1 x))"))
}