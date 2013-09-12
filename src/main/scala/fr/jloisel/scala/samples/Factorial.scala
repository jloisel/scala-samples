package fr.jloisel.scala.samples

import BigInt._

/**
 * Computes n!.
 */
class Factorial {
	
	def compute(x: BigInt): BigInt = 
		if(x == 0) int2bigInt(1) else x * compute(x - int2bigInt(1))
}