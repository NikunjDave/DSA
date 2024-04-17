package array02

/**
 * Given an integer array nums, return an array answer such that
 * answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in
 * a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using
 * the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
object ProductOfArray {
    //[1,2,3,4] [24,12,8,6]
    fun productExceptSelf(nums: IntArray): IntArray {
        val arrayLength = nums.size
        val prefixProducts = IntArray(arrayLength) { 1 }
        val suffixProducts = IntArray(arrayLength) { 1 }

        for (i in 1 until arrayLength) {
            prefixProducts[i] = nums[i - 1] * prefixProducts[i - 1]
        }

        for (i in arrayLength - 2 downTo 0) {
            suffixProducts[i] = nums[i + 1] * suffixProducts[i + 1]
        }

        val result = IntArray(arrayLength)
        for (i in 0 until arrayLength) {
            result[i] = prefixProducts[i] * suffixProducts[i]
        }

        return result
    }
}