package com.xyzcorp.student

import org.scalatest.{FunSuite, Matchers}

case class Stamp ( elements:String,  year:Int)

class ClassesSpec extends FunSuite with Matchers {
  test("""Case 1: Create a class, and the class should be
         |  instantiable with the elements, but without a val
         |  I cannot get information. Let's create a stamp with elements
         |  name and year""".stripMargin) {
      

      val stuff = new Stamp("Woot Woot", 2017)

      stuff
  }

  test("""Case 2: Case classes have automatic functionality for getters, toString,
          | equals, hashCode, apply, and basic pattern matching. Let's
          | create a case class Computer with make, model, and year""".stripMargin) {
       //Pattern matching, assignment

       val jimiStamp = Stamp("Jimi Hendrik", 2014)

      jimiStamp.toString should be ("Stamp(Jimi Hendrik,2014)")

      val Stamp(n, y) = jimiStamp
      n should be ("Jimi Hendrik")
      y should be (2014)
    
      val result = jimiStamp match {
        case Stamp (_, 2014) => "2014 good year for Stamps"
        case Stamp ("Jimi Hendrik", _) => "Excuse Me"
        case Stamp ("Janis Joplin", q) => s"Ah Janis and $q, a good year"
        case Stamp (_, q) if  q < 1980 => "Ah the classics"
        case _ => "I don't know what you're telling me"
      }

      result should be ("2014 good year for Stamps")
  }

  test("""Case 3: Preconditions can be made with require. Let's make sure that the name
      | for the stamp cannot be blank.""".stripMargin) {
      case class Stamp ( name:String,  year:Int)
      {
        require(!name.isEmpty, "Name cannot be empty")
      }

      //val f = new Stamp ("", 1201)
  }

  test("""Case 4: Subclassing. Let's create:
      |* Sports Card with year, manufacturer, and year
      |* Baseball Card with the same fields Sports Card but adding
      |  league and division""".stripMargin) {
    
      val bbCard = new BaseballCard ("Ken Griffy Jr.", "Tops", 1996, "American", "West")

      bbCard.year should be (1996)
      bbCard.name should be ("Ken Griffy Jr.")

      bbCard shouldBe a [BaseballCard]
      bbCard shouldBe a [SportsCard]
      bbCard shouldBe a [Collectible]
      bbCard shouldBe a [AnyRef]
      bbCard shouldBe a [Any]

      bbCard shouldBe a [AnyVal] // shouldn't be true, but with Scala Test!!
  }

  test("""Case 5: Abstract Classes. We can also add an abstract class called
      | Collectible with a field year. Verify that all types are
      | polymorphic""".stripMargin) {
    pending
  }

  test("""Case 6: Generic Classes, Let's create a box that will be generic that will
      | hold a baseball card or anything else for that matter""".stripMargin) {

        val bbCard = new BaseballCard ("Ken Griffy Jr.", "Tops", 1996, "American", "West")
        val box = new Box(bbCard)
        val boxInt = new Box(4)
        val boxString = new Box("Foo")
        val boxBaz = new Box("Baz")

        val result = box.tupleItWith(20)
  }
}
