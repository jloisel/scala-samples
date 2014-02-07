package fr.jloisel.scala.samples.akka

import akka.actor.Actor
import akka.actor.Props

class HelloWorldActor extends Actor {
	override def preStart() {
			val greeter = context.actorOf(Props[Greeter], "greeter")
			greeter ! Greeter.Greet
	}

	def receive = {
		case Greeter.Done => context.stop(self)
	}
}

