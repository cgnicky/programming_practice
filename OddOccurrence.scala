/**
Given an array of positive integers. 
All numbers occur even number of times except one number which occurs odd number of times. 
Find the number in O(n) time & constant space.

Examples:
Input : arr = {1, 2, 3, 2, 3, 1, 3}
Output : 3

Input : arr = {5, 7, 2, 7, 5, 2, 5}
Output : 5
**/

object OddOccurrence {
  def main(args: Array[String]): Unit = {
      val arr = Array(1, 4, 1, 5, 4, 7, 7)

      solution2(arr)
  }

  def badSolution(arr: Array[Int]): Int ={
    arr.groupBy(identity).mapValues(_.size).filter(_._2 == 1).map(_._1).head
  }

  def solution(arr: Array[Int]): Int ={
    var map = Map[Int, Int]()
    val len = arr.length
    var res = 0
    for (i <- arr) {
      if (!map.contains(i)) map += (i -> 1)
      else map += (i -> (map(i) + 1))
    }
    //map.map{ case (k, v) => if (v == 1) res = k }
    for (k <- map.keySet) {
      if (map(k) % 2 != 0) res = k
    }
    res
  }

  def solution2(arr: Array[Int]): Int ={
    var res = 0
    for (i <- arr) {
      res ^= i
    }
    res
  }
}
