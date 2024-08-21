package array01

import kotlin.math.max
import kotlin.math.min

/**
 * Return the minimum number of jumps to reach nums[n - 1].
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * i.p [2,3,0,1,4]
 * o.p : 2
 */
object JumpGame2 {
    //[1,2,1,1,1]
    fun findMinJum(nums: IntArray): Int {
        var curr = 0
        var step = 0
        var last = 0
        val size = nums.size
        for (i in 0 until size) {
            if (i > last) {
                // this to make sure you only increase step when you reached the max step
                // basicall if prev is 3 and index is 1, it should not increase step until it reached beyond 3
                last = curr
                step++
            }
            curr = max(curr, nums[i] + i)
            if (curr >= size - 1) {
                return step + 1
            }
        }
        return step
    }
}