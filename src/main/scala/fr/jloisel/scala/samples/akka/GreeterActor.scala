package fr.jloisel.scala.samples.akka

import akka.actor.Actor
import scala.concurrent._
import akka.actor.Props

object Greeter {
	case object Greet
	case object Done
}

class Greeter extends Actor {
	import context.dispatcher
	
	def receive = {
	  case Greeter.Greet => sender ! Greeter.Done
	}
}