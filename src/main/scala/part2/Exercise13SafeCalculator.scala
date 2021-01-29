package part2

// ----------------------------------------------

// Step 1. Implement a `Result` type

sealed abstract class Result

// A Result is:
//   - a Pass containing a Double result, or
//   - a Fail containing a String error message

case class Fail(msg: String) extends Result
case class Pass(result: Double) extends Result

// ----------------------------------------------

// Step 2. Implement eval below:

object SafeCalculator {
  def eval(calc: Expr): Result = {
    calc match {
      case Num(value) => Pass(value)
      case Add(x, y)  => Pass(0) // todo
      case Sub(x, y)  => eval(x) match {
        case Fail(xMsg) => Fail(xMsg)
        case Pass(xResult) => eval(y) match {
          case Fail(yMsg) => Fail(yMsg)
          case Pass(yResult) => Pass (xResult - yResult)
        }
      }
      case Mul(x, y)  => Pass(0) // todo
      case Div(x, y)  => eval(x) match {
        case Fail(xMsg) => Fail(xMsg)
        case Pass(xResult) => eval(y) match {
          case Fail(yMsg) => Fail(yMsg)
          case Pass(yResult) => if (yResult == 0) Fail("Division by 0 is not allowed") else Pass(xResult / yResult)
        }
      }
      case Sqrt(x) => eval(x) match {
        case Fail(msg) => Fail(msg)
        case Pass(result) => if (result < 0) Fail("Sqrt of negative numbers is not allowed") else Pass(Math.sqrt(result))
      }
    }
  }
}

// object SafeCalculator {
//   def eval(calc: Expr): Result = {
//     calc match {
//       case Num(value) => Pass(value)
//       //  case Add(x, y) => evalHelper(x, y, _ + _)
//       case Add(x, y) => (this.eval(x), this.eval(y)) match {
//         case (Pass(v1), Pass(v2)) => Pass(v1 + v2)
//         case _  => Fail("Error")
//       }
//       case Div(x, y) => (this.eval(x), this.eval(y)) match {
//         case (Pass(v1), Pass(v2)) if(v2 != 0) => Pass(v1 / v2)
//         case _  => Fail("Error")
//       }
//       case Mul(x, y) => (this.eval(x), this.eval(y)) match {
//         case (Pass(v1), Pass(v2)) => Pass(v1 * v2)
//         case _  => Fail("Error")
//       }
//       case Sqrt(x) => this.eval(x) match {
//         case Pass(v1) if(v1 >= 0) => Pass(Math.sqrt(v1))
//         case _  => Fail("Error")
//       }
//     }
//   }

//   def evalHelper(x:Expr, y:Expr, operation: (Double, Double) => Double): Result = {
//        (this.eval(x), this.eval(y)) match {
//         case (Pass(v1), Pass(v2)) => Pass(operation(v1, v2))
//         case _  => Fail("Error")
//       }
//   }
// }

object Exercise13SafeCalculator {
  def main(args: Array[String]): Unit = {
    println("SaveCalculator.eval")
    // println(SafeCalculator.eval(Add(Num(1), Num(2))))
    // println(SafeCalculator.eval(Sqrt(Num(-1))))
    // println(SafeCalculator.eval(Div(Num(1), Num(0))))
  }
}
