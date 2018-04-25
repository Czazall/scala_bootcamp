package com.xyzcorp.student

import org.scalatest.{FunSuite, Matchers}

class ObjectsSpec extends FunSuite with Matchers {

    test("""Case 1: An object is a singleton, lets prove it""") {
        pending
    }

    test("""Case 2: A companion object has access to the private members of the class.
        | They have to be in the same file in the same name""".stripMargin) {
        pending
    }

    test("""Case 3: Use Object to create a 'static-like' method factory for the following Employee class""") {
      class Employee private (val firstName:String, val middleName:Option[String], val lastName:String)

      object Employee {
          def apply(firstName:String
                    ,middleName:String
                    ,lastName:String):Employee = new Employee (firstName
                                                               ,Some(middleName)
                                                               ,lastName)
          
          def apply(firstName:String
                    ,lastName:String):Employee = new Employee (firstName
                                                               ,None
                                                               ,lastName)
      }

      val emp = Employee.apply("Bob", "Barker")
      val emp2 = Employee("Tony", "Stark")

      

    }
}
