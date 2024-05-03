package array01

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 1
 *
 */
object SingleNumber {
    fun findSingleNumber(nums: IntArray): Int {
        val numberCountMap = mutableMapOf<Int, Int>()

        // Count occurrences of each number
        for (num in nums) {
            numberCountMap[num] = numberCountMap.getOrDefault(num, 0) + 1
        }

        // Find the number with only one occurrence
        for ((number, count) in numberCountMap) {
            if (count == 1) {
                return number
            }
        }
        return -1 // Return -1 if no single number is found
    }
}

fun main(){
    val output = SingleNumber.findSingleNumber(intArrayOf(4,1,2,1,2))
    println("Single number is $output")
}
