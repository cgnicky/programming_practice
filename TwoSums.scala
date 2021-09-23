// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Output: Because nums[0] + nums[1] == 9, we return [0, 1].

object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        var hMap = Map.empty[Int, Int]
        
        for((v, i) <- nums.zipWithIndex) {
            hMap.get(v) match {
                case Some(r) => return Array(r, i)
                case None => hMap += (target - v -> i)
            }
        }
        
        Array(0, 0)
    }
}
