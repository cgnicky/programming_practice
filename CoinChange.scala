/*
Given a value V, if we want to make change for V cents, 
and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, 
what is the minimum number of coins to make the change? 

Examples:
Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required
We can use one coin of 25 cents and one of 5 cents 

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required
We can use one coin of 6 cents and 1 coin of 5 cents
*/

object ChangeCoin {
  def main(args: Array[String]): Unit = {
    val coinList = Array(25, 10, 1)
    val cents = 31
    val len = coinList.length

    //println(findMinCoinsRecursive(coinList, len, cents))
    println(findMinCoinsDP(coinList, len, cents))
  }

  private def findMinCoinsRecursive(arr: Array[Int], n: Int, cents: Int): Int ={
    if (cents == 0) return 0
    var res = Integer.MAX_VALUE

    for (i <- 0 until n) {
      if (arr(i) <= cents) {
        val sub_res = findMinCoinsRecursive(arr, n, cents - arr(i))
        if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) {
          res = sub_res + 1
        }
        println(s"Current coin: ${arr(i)}, Cents: $cents, Sub-res: $sub_res, Res: $res")
      }
    }
    return res
  }

  private def findMinCoinsDP(arr: Array[Int], n: Int, cents: Int): Int ={
    var table = new Array[Int](cents + 1)
    table(0) = 0
    for (i <- 1 to cents) {
      table(i) = Integer.MAX_VALUE
    }

    for (i <- 1 to cents) {
      for (j <- 0 until n) {
        if (arr(j) <= i) {
          val sub_res = table(i - arr(j))
          if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table(i))
            table(i) = sub_res + 1
          println(s"Table pos: $i, Coin: ${arr(j)}, Sub-res: $sub_res, Table value: ${table(i)}")
        }
      }
    }
    table(cents)
  }
}
