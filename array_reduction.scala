package application

object Sample3 {
  def main(args: Array[String]): Unit = {
    val arr = (1 to 5).toArray

    println(reductionCost(arr))

  }

  def reductionCost(num: Array[Int]): Int = {
    print(num.length)
    print("-")
    print(num.mkString(","))
    print("\n")
    // Write your code here
    if (num.length > 1) {
      val sortedNum = num.sorted.toBuffer
      val x1 = sortedNum.remove(0)
      val x2 = sortedNum.remove(0)
      val cost = x1 + x2
      sortedNum.append(cost)

      reductionCost(sortedNum.toArray)
    }
    else num(0)
  }

  def factorial(n: Int): Int = {
    if (n == 0) 1
    else n * factorial(n-1)
  }
}
