package adt.intlist

import org.scalatest.flatspec._
import org.scalatest.matchers.should.Matchers

class IntListSpec extends AnyFlatSpec with Matchers {
  // val ints = IntPair(1, IntPair(2, IntPair(3, IntNil())))

  "intList.contains" should "return true and false appropriately" in {
    pending
    // ints.contains(1) should equal(true)
    // ints.contains(2) should equal(true)
    // ints.contains(5) should equal(false)
  }

  "intList.add" should "increment every element in the list" in {
    pending
    // val expected1 = IntPair(2, IntPair(3, IntPair(4, IntNil())))
    // val expected5 = IntPair(6, IntPair(7, IntPair(8, IntNil())))
    // ints.add(1) should equal(expected1)
    // ints.add(5) should equal(expected5)
  }

  "intList.total" should "total all elements" in {
    pending
    // ints.total should equal(1 + 2 + 3)
  }
}
