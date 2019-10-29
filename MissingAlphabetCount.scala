/**
Find the count of missing 'a' in a given string. 
There is expected to have 2 and not more than 3 char 'a' before and after the non-char 'a' alphabet.
If there is more than 3 char 'a' in the string, 0 should be returned.
Example:
Given S = "aabaca", Answer is 2 as the expected string should be "aaba'a'ca'a'"
**/

object MissingAlphabetCount {
  def main(args: Array[String]): Unit = {
    val s = "aabaca"
    println(solution(s))
  }

  def solution(s: String): Int ={
    if (s.contains("aaa")) return 0
    var count = 2
    val len = s.length
    for (i <- 0 until len) {
      if (s.charAt(i) == 'a') count -= 1
      else count += 2
    }
    count
  }
}
