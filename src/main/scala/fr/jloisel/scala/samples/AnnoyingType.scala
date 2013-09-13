package fr.jloisel.scala.samples

import java.util.HashMap

/**
 * Field type is repeated in this case.
 * This kind of redundancy is not necessary.
 */
class Typing {
	val x: HashMap[Int, String] = new HashMap[Int, String]()
}