/*
A number is called as a Jumping Number if all adjacent digits in it differ by 1. The difference between ‘9’ and ‘0’ is not considered as 1.
All single digit numbers are considered as Jumping Numbers. For example 7, 8987 and 4343456 are Jumping numbers but 796 and 89098 are not.

Given a positive number x, print all Jumping Numbers smaller than or equal to x. The numbers can be printed in any order.

Example:
Input: x = 20
Output:  0 1 2 3 4 5 6 7 8 9 10 12

Input: x = 105
Output:  0 1 2 3 4 5 6 7 8 9 10 12
         21 23 32 34 43 45 54 56 65
         67 76 78 87 89 98 101

Note: Order of output doesn't matter, 
i.e. numbers can be printed in any order
*/

import scala.collection.mutable._

object JumpingNumber {
  def main(args: Array[String]): Unit = {
    val x = 105
    val out = new ListBuffer[Int]()

    for (i <- 0 to x) {
      if (i < 10) out.+=(i)
      else {
        if (isJumpingNumber(i)) out.+=(i)
      }
    }

    out.foreach(println)
  }

  def isJumpingNumber(x: Int): Boolean ={
    val str = x.toString
    val len = str.length - 1
    var count = 0
    for (i <- 0 until len) {
      count += Math.abs(str(i) - str(i+1))
    }
    if (count == len) true
    else false
    }
}
