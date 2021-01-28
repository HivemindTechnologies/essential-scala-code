package part2

// ----------------------------------------------

// Write your Vec class (and companion object) here!
case class Vec(val x: Double, val y: Double) {
  def length: Double = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))
  def +(other: Vec): Vec = new Vec(this.x + other.x, this.y + other.y)
  def *(scalar: Double): Vec = new Vec(this.x * scalar, this.y * scalar)
}

object Vec {
  val zero: Vec = new Vec(0,0)
  val unitX: Vec = new Vec(1,0)
  val unitY: Vec = new Vec(0,1)
  def longest(vec1: Vec, vec2: Vec): Vec = if (vec1.length >= vec2.length) vec1 else vec2
  def longest(vecList:List[Vec]): Vec = 
    vecList match {
      case Nil => zero
      case head :: tail => longest(head, longest(tail))
        // vecList.maxBy(_.length)
    }
}
// ----------------------------------------------

object Exercise8Vec {
  val vec1 = new Vec(3, 4)
  val other = new Vec(5, 12)


  def main(args: Array[String]): Unit = {
    println("length")
    println(vec1.length)
    println(other.length)

    println("+")
    println(vec1 + other)
    println((vec1 + other).length)

    println("*")
    println(vec1 * 10)
    println((vec1 * 10).length)

    println("zero, x, y")
    println(Vec.zero)
    println(Vec.unitX * 3 + Vec.unitY * 4)

    println("longest(Vec, Vec)")
    println(Vec.longest(vec1, other))
    println(Vec.longest(Vec.unitX * 2, Vec.unitY))

    println("longest(List[Vec])")
    println(Vec.longest(List(Vec.unitX, Vec.unitX + Vec.unitY, Vec.unitY)))
    println(Vec.longest(Nil))
  }
}
