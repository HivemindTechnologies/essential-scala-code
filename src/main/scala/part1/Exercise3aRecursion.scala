package part1

object Exercise3aRecursion {
  def greetNTimes(name: String, n: Int): Unit = {
    if(n > 1) greetNTimes(name, n - 1)
    if(n != 0) println(s"Hello $name")
    /* 
    if(n > 0) {
       println(s"Hello $name")
       greetNTimes(name, n-1)
    }
    */
  }

  def main(args: Array[String]): Unit = {
    println("greetNTimes")
    greetNTimes("world", 5)
    greetNTimes("nope", 0)
  }
}
// 