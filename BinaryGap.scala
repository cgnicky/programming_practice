import scala.collection.mutable._

object BinaryGap {
  def main(args: Array[String]): Unit = {
    /**
    Find out the longest sequence of zeros in binary form, which begin and end with 1
    Example:
    10000010 - Longest sequence is 5
    1000000 - Longest sequence is 0 since there is no closing 1
    10010001 - Longest sequence is 3 instead of 2
    **/
    //println(toBinary(32))
    val n = 50
    val binary = n.toBinaryString
    println(s"Number: $n, Binary: $binary, Longest zero sequence: ${solution1(n)}")
  }

  def toBinary(n:Int, bin: List[Int] = List.empty[Int]): String = {
    if(n/2 == 1) (1:: (n % 2) :: bin).mkString("")
    else {
      val r = n % 2
      val q = n / 2
      toBinary(q, r::bin)
    }
  }

  //Get the indicies of each 1 and use sliding to get how many zeros between them
  def solution1(n: Int): Int ={
    val binary = n.toBinaryString
    val indicesList = new ArrayBuffer[Int]()
    for (i <- 0 until binary.length) {
      if (binary(i).equals('1')) indicesList.+=(i)
    }
    println(s"Number of 1: ${indicesList.length}")
    if (indicesList.length < 2) return 0
    else indicesList.sliding(2).map(x => x(1) - x(0)).max - 1
  }

  //Use Trailing zero recursive
  def solution2(n: Int): Int ={
    solution2Recursive(n >>> Integer.numberOfTrailingZeros(n), 0, 0)
  }

  def solution2Recursive(n: Int, max: Int, current: Int): Int ={
    if (n == 0) max
    else if ((n & 1) == 0 )
      solution2Recursive(n >>> 1, max, current + 1)
    else
      solution2Recursive(n >>> 1, Math.max(max, current), 0)
  }

  //Trim all the zeros at right side and split by 1 then get the maximum number of array element count
  def solution3(binary: String): Int={
    val arr = binary.replaceAll("0+$", "").split("1+")
    if (arr.isEmpty) 0
    else arr.map(_.size).max
  }
}
