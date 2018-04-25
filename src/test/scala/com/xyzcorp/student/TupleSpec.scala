package com.xyzcorp.student

import org.scalatest.{FunSuite, Matchers}

class TupleSpec extends FunSuite with Matchers {
  test("Case 1: Creating a tuple") {
     val t = (1,"Foo")

     t._1 should be (1)
  }

  test("Case 2: Getting information from a tuple") {
    val t2 = (1,"Foo","baz")

     t2._3 should be ("baz")
  }

  test("Case 3: Swapping a Tuple2") {
     val t3 = (1,"Baz")
     val t4 = t3.swap
     t3._2 should be ("Baz")
     t4._2 should be (1)
  }

  test("Case 4: Syntactic sugar for Tuple2") {
     val t = 15 -> "Woot!"
     t._2 should be ("Woot!")
  }
}
