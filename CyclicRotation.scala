/**
An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, 
and the last element of the array is moved to the first place. 
For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] 
(elements are shifted right by one index and 6 is moved to the first place).

Example:
For example, given
    A = [3, 8, 9, 7, 6]
    K = 3

the function should return [9, 7, 6, 3, 8]. Three rotations were made:
    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
**/

object CyclicRotation {
  def main(args: Array[String]): Unit = {
    val arr = Array(2, 5, 1, 6, 9)
    val arr2 = Array(1, 2, 3, 4)
    val k = 10

    solution(arr2, k).foreach(println)
  }

  def solution(a: Array[Int], k: Int): Array[Int] ={
    val n = a.length
    //to check only one element in array
    if (n < 2) a
    else {
      val new_arr = new Array[Int](n)
      for (i <- 0 until n) {
        var new_index = 0
        if (i + k < n) new_index = i + k
        else new_index = (i + k) % n
        new_arr(new_index) = a(i)
      }
      new_arr
    }
  }
}
