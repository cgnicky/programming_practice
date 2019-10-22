object BinarySearch {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 6, 7, 9)

    //println(binarySearch(arr, 2))
    println(binarySearchRecursive(arr, 0, arr.length -1, 2))

  }

  def binarySearch(arr: Array[Int], target: Int): Int ={
    var low = 0
    var high = arr.length - 1

    while (low <= high) {
      val mid = (low + high) / 2
      println(s"High : $high Low : $low Mid : $mid")

      if (arr(mid) == target)
        return mid

      if (arr(mid) < target) {
        low = mid + 1
      } else {
        high = mid - 1
      }
    }

    -1
  }

  def binarySearchRecursive(arr: Array[Int], low: Int, high: Int, target: Int): Int = {
    if (low <= high) {
      val mid = (low + high) / 2

      println(s"High : $high Low : $low Mid : $mid")

      if (arr(mid) == target) return mid

      if (arr(mid) < target) {
        return binarySearchRecursive(arr, mid + 1, high, target)
      } else {
        return binarySearchRecursive(arr, low, mid - 1, target)
      }
    }
    -1
  }
}
