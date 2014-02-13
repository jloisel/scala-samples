package fr.jloisel.scala.samples

class MapExperiment {
	val capitalOfCountry = Map("US" -> "Washington", "France" -> "Paris")
	
	def capitalOf(country: String) = (capitalOfCountry get country orElse Some("missing data")).mkString
	
	def showCapitalOf(country: String) = capitalOfCountry get country match {
	  case Some(capital) => println(capital)
	  case None => println("Missing data")
	}
}