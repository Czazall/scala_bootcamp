package com.xyzcorp.student

import org.scalatest.{FunSuite, Matchers}

class MethodsSpec extends FunSuite with Matchers {
  test("Case 1: A method is structured like the following:") {
    pending
  }

  test("Case 2: Also a method can be inlined if there is only one statement:") {
    pending
  }

  test("""Case 3: Methods can be embedded, in case one method is
      |  exclusively only being used by another""".stripMargin) {
    def foo(x: Int, y: Int): Int = {
      def bar(z: Int): Int = {
        z + 10
      }
      bar(x + y)
    }

    foo(4, 10) should be(24)
  }

  test("""Case 4: Recursion is supported just like another language,
      |  we can do a factorial using recursion""".stripMargin) {
        def factorial(n:Int):Int = 
        {
            require(n >= 0)
            if (n == 0) return 1;
            else
            {
              return n * factorial(n-1);
            }
        }

        factorial(1) should be (1)
        factorial(3) should be (6)
        factorial(4) should be (24) 
        factorial(0) should be (1)

        a [IllegalArgumentException] should be thrownBy {
          factorial(-1)
        }
  }

 test("""Case 4.5: Recursion is supported just like another language,
      |  we can do a factorial using recursion""".stripMargin) {
        def factorial(n:Int):Int = 
        {
          require(n >= 0)
          def fact(i:Int, acc:Int):Int =
          {
            if (i == 0) acc
            else
            {
              fact (i - 1, i * acc )
            }
          }
          fact(n, 1)
        }

        factorial(1) should be (1)
        factorial(2) should be (2)
        factorial(3) should be (6)
        factorial(4) should be (24) 
        factorial(0) should be (1)

        a [IllegalArgumentException] should be thrownBy {
          factorial(-1)
        }
      
  }


  test("""Case 5: Multi-parameter lists are groups or argument lists,
      |  the purpose are two fold: The get group like terms, and
      |  they make it easy to be partially applied""".stripMargin) {
    def multiParameters(w:Int)(x:Int)(y:String, z:String) = {
      y + (w + x) + z
    }
    multiParameters(10)(20)("<<", ">>") should be ("<<30>>")
  }


  test("""Case 6: Repeated parameters are the equivalent of varargs in Java, they
      |  allow additional parameters and inside the method they
      |  are just a collection called WrappedArray""".stripMargin) {

    def varargs[A, B](arg1: A, rest: B*) = {
      s"arg1=$arg1, rest=$rest"
    }

    pending
  }

  test("""Case 7: Repeated parameters can be sent a list or any other collection,
      |  but the problem is what happens when we just send collection
      |  it would treat it as a single unit instead you can expand the units
      |  with a :_*""".stripMargin) {

    def varargs[A, B](arg1: A, rest: B*) = {
      s"arg1=$arg1, rest=$rest"
    }

    pending
  }

  test("Case 8: Generics with methods: Convert the following with generics") {
    def decide[A](b:Boolean, x:A, y:A):A = if (b) x else y

    decide(false, 1 , 5) should be (5)
    decide(true, 1 , 5) should be (1)
  }

  test("Case 8.1: Generics with methods: Convert the following with generics") {
    def decide(b:Boolean, x:Any, y:Any):Any = if (b) x else y

        decide(false, 1 , 5) should be (5)
        decide(true, 1 , 5) should be (1)
  }

  test("""Case 9: Default methods have just methods that have a value
      |  in case you don't have one at the moment.
      |  Another item you'll see with this example
      |  is the named parameter. You can set a parameter
      |  explicitly by the name to avoid any confusion as to what you
      |  are setting""".stripMargin) {

    class Employee (val firstName:String,
                val middleName:Option[String] = None,
                val lastName:String)

    val KC = new Employee ("K.C.", None, "Morgan")

    KC.firstName should be ("K.C.")    
  }
}
