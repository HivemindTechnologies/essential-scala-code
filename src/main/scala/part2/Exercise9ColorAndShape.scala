package part2

// ----------------------------------------------

// Write a definition for Color here!

/*
ADT - algebraic data type
// product type: case class, tuple, ...

case class Foo(a: Boolean, b: Boolean) // 4
foo _has_ an a
foo _has_ a b

// sum type
sealed trait Bar

case class B(value: Boolean) extends Bar
case class U(value: Unit) extends Bar

B _is_ a Bar
U _is_ a Bar

*/

// Write definitions for Shape, Circle, and Rect here!
case class Color(r: Int, g: Int, b: Int) 

// companion-object
object Color {
  val black = Color(0, 0, 0)
  val white = Color(255, 255, 255)
  
}

sealed trait Shape {
  val area: Double
  val perimeter: Double
  val color: Color
}
case class Circle(radius: Double, color: Color) extends Shape {
  val area: Double = Math.PI * radius * radius
  val perimeter: Double = Math.PI * radius * 2
}
case class Rect(width: Double, height: Double, color: Color) extends Shape {
  val area: Double = width * height
  val perimeter: Double = 2 * (width + height)
}
// ----------------------------------------------


object Exercise9ColorAndShape {
  def main(args: Array[String]): Unit = {

    println("color")
    println(Color(1, 1, 0))
    println("color")
    println(Color(1, 1, 0))
    println(Color(1, 0, 1))

    println("circle")
    val circle = Circle(30, Color(1, 1, 0))
    println(circle)
    println(circle.area)
    println(circle.perimeter)

    // println("rect")
    // val rect = Rect(50, 30, Color(1, 0, 1))
    // println(rect)
    // val rect = Rect(50, 30, Color(1, 0, 1))
    // println(rect)
    // val rect = Rect(50, 30, Color(1, 0, 1))
    // println(rect)
    // val rect = Rect(50, 30, Color(1, 0, 1))
    // println(rect)
    // val rect = Rect(50, 30, Color(1, 0, 1))
    // println(rect)
    // println(rect.area)
    // println(rect.perimeter)
  }
}
