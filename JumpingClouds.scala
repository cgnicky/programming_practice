object JumpingClouds {
  def main(args: Array[String]): Unit = {
    //Move step - Either 1 or 2
    //Avoid the array index which having a value as 1
    //Calculate the minimum step cost
    val arr = Array(0, 0, 0, 1, 0, 0)
    var cost = 0
    var i = 0

    while (i < arr.length - 1) {
      if (i < arr.length - 2 && arr(i + 2) == 0) {
        i = i + 2
        cost += 1
      } else {
        i = i + 1
        cost += 1
      }
    }
    println(cost)
  }
}
