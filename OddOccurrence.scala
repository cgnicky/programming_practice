/**
A non-empty zero-indexed array A consisting of N integers is given. 
The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, 
except for one element that is left unpaired.

Example:
Given Array[2, 5, 6, 2, 6, 5, 8]
The answer is 8
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
