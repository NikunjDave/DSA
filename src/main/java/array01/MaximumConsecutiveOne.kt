package array01

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * Example 2:
 *
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 *
 *
 *
 */
object MaximumConsecutiveOne {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var count = 0
        var maxCount = 0
        for(num in nums){
            if(num == 1) count ++
            else count = 0
            if(maxCount < count)
                maxCount = count
        }
        return maxCount
    }
}

fun main(){
    val count = MaximumConsecutiveOne.findMaxConsecutiveOnes(intArrayOf(1,1,0,1,0,1))
   println("max count of 1 is $count")
}