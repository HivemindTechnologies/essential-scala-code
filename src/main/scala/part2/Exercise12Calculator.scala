package part2

// ----------------------------------------------

// Step 1. Write a definition for Expr here!

/*
  val calc1 = Add(Num(1.1), Mul(Num(2.2), Num(3.3)))
  val calc2 = Mul(Add(Num(1.1), Num(2.2)), Num(3.3))
  val calc3 = Div(Num(1.0), Num(0.0))
  val calc4 = Sqrt(Num(-1.0))
*/

sealed abstract class Expr
{
  def stringify: String = {
    this match {
      case Num(value) => s"$value"
      case Add(x, y) => s"${x.stringify} + ${y.stringify}"
      case Sub(x, y) => s"${x.stringify} - ${y.stringify}"
      case Mul(x, y) => s"${setParenthesis(this, x)} * ${setParenthesis(this, y)}"
      case Div(x, y) => s"${setParenthesis(this, x)} / ${setParenthesis(this, y)}"
      case Sqrt(x) => s"sqrt(${x.stringify})"
    }
  }
  def setParenthesis(outer:Expr, inner:Expr): String =  {
      (outer, inner) match {
        case (Mul(_, _), Add(_,_)) => s"(${inner.stringify})"
        case (Div(_, _), Add(_,_)) => s"(${inner.stringify})"
        case _ => inner.stringify
      } 
  }
  
}

final case class Num(value: Double) extends Expr
final case class Add(x: Expr, y: Expr) extends Expr
final case class Sub(x: Expr, y: Expr) extends Expr
final case class Mul(x: Expr, y: Expr) extends Expr
final case class Div(x: Expr, y: Expr) extends Expr
final case class Sqrt(x: Expr) extends Expr

// Handle the following types of equation:
// - addition
// - subtraction
// - multiplication
// - division
// - square root

// Give it a `stringify` method
// that renders the expression as a string.

// ----------------------------------------------

// Step 2. Implement eval
// for each of the "calculator" objects below:

object Calculator {
  def eval(calc: Expr): Double = {
    calc match {
      case Num(value) => value
      case Add(x, y) => this.eval(x) + this.eval(y)
      case Sub(x, y) => this.eval(x) - this.eval(y)
      case Mul(x, y) => this.eval(x) * this.eval(y)
      case Div(x, y) => this.eval(x) / this.eval(y)
      case Sqrt(x) => Math.sqrt(this.eval(x))
    }
  }
}

object IntCalculator {
  def eval(calc: Expr): Int = {
    calc match {
      case Num(value) => value.toInt
      case Add(x, y) => this.eval(x) + this.eval(y)
      case Sub(x, y) => this.eval(x) - this.eval(y)
      case Mul(x, y) => this.eval(x) * this.eval(y)
      case Div(x, y) => this.eval(x) / this.eval(y)
      case Sqrt(x) => Math.sqrt(this.eval(x).toDouble).toInt
    }
  }
}

// ----------------------------------------------

// Step 3. Write some convenience methods
// for constructing common calculations:

// ----------------------------------------------

object Expr {
  def pythag(a: Double, b: Double): Expr = {
    Sqrt(Add(Mul(Num(a), Num(a)), Mul(Num(b), Num(b))))
  }

  def factorial(n: Int): Expr = {
    n match {
      case 0 => Num(1.0)
      case _ => Mul(Num(n.toDouble), factorial(n-1))
    }
  
  }
}

object Exercise12Calculator {
  // val calc1 = Add(Num(1.1), Mul(Num(2.2), Num(3.3)))
  // val calc2 = Add(Mul(Num(1.1), Num(2.2)), Num(3.3))

  def main(args: Array[String]): Unit = {
    println("stringify")
    // println(calc1.stringify)
    // println(calc2.stringify)

    println("Calculator.eval")
    // println(Calculator.eval(calc1))
    // println(Calculator.eval(calc2))

    println("IntCalculator.eval")
    // println(IntCalculator.eval(calc1))
    // println(IntCalculator.eval(calc2))

    println("pythag")
    // println(Expr.pythag(3, 4))
    // println(Calculator.eval(Expr.pythag(3, 4)))
    // println(IntCalculator.eval(Expr.pythag(3, 4)))

    println("factorial")
    // println(Expr.factorial(4))
    // println(Calculator.eval(Expr.factorial(4)))
    // println(IntCalculator.eval(Expr.factorial(4)))
  }
}
