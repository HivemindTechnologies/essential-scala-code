package part3

import films.Film

object Exercise17FoldLeftAndRight {
  def totalImdbRating(films: List[Film]): Double = {
    
    //foldLeft[B]    (z: B) (op: (B, A) =>               B): B
    //films.foldLeft (0)    (    (b, a) => b + a.imdRating): B
    films.foldLeft(0) { case(acc, current) => 
      acc + current.imdbRating
    }
  }

   def averageImdbRating(films: List[Film]): Double = {
    val (total, amount) = films.foldLeft((0.0, 0)) {
      case ((acc, counter), current) =>
        (acc + current.imdbRating, counter + 1)
    }
    total / amount
  }

  def reverseUsingFold[A](items: List[A]): List[A] = {
    items.foldLeft(List.empty[A])((acc, current) => current :: acc)
  }

  def filterUsingFold[A](items: List[A], pred: A => Boolean): List[A] = {
    items.foldLeft(List.empty[A])((acc, current) => 
      if(pred(current)) 
        acc.appended(current) 
      else 
        acc
    )
  }


 

  def main(args: Array[String]): Unit = {
    import films.TestData._

    println("totalImdbRating")
    // println(totalImdbRating(List(memento, outlawJoseyWales, thomasCrownAffair)))
    // println(totalImdbRating(Nil))

    println("averageImdbRating")
    // println(averageImdbRating(List(memento, outlawJoseyWales, thomasCrownAffair)))
    // println(averageImdbRating(Nil))

    println("reverseUsingFold")
    // println(reverseUsingFold(List(1, 2, 3)))
    // println(reverseUsingFold(Nil))

    println("filterUsingFold")
    // println(filterUsingFold(List(1, 2, 3, 4, 5), (n: Int) => n % 2 == 0))
    // println(filterUsingFold(Nil, (n: Int) => n % 2 == 0))
  }
}
