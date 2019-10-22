object AliceBobApplesCollection {
  def main(args: Array[String]): Unit = {
    val arr = Array(6, 1, 4 ,6, 3, 2, 7, 4)
    val k = 3
    val l = 2

    collectApples(arr, k, l)
  }
  
  def collectApples(arr: Array[Int], k: Int, l: Int): Int ={
    var sum = 0
    var aliceApples = 0
    var bobApples = 0
    var totalApples = 0

    val aliceCollected = new mutable.HashMap[Int, Int]()
    val bobCollected = new mutable.HashMap[Int, Int]()

    val loop = new Breaks

    if (k + l > arr.length) totalApples = -1
    else {
      loop.breakable {
        for (i <- arr.indices) {
          sum = 0
          if (k + i > arr.length) loop.break()
          for (j <- i until k + i) {
            sum += arr(j)
          }
          aliceCollected.put(i, sum)
        }
      }

      loop.breakable{
        for (i <- arr.indices) {
          sum = 0
          if (l + i > arr.length) loop.break()
          for (j <- i until l + i) {
            sum += arr(j)
          }
          bobCollected.put(i, sum)
        }
      }
    }

    for (i <- aliceCollected) {
      bobApples = 0
      aliceApples = i._2

      if (i._1 + k < bobCollected.size) {
        for (i <- i._1 + k until bobCollected.size) {
          if (bobApples < bobCollected(i)) bobApples  = bobCollected(i)
        }
        if (totalApples < aliceApples + bobApples) totalApples = aliceApples + bobApples
      }
    }

    totalApples

    //println(totalApples)
    //aliceCollected.foreach(println)
    //bobCollected.foreach(println)
  }
}
