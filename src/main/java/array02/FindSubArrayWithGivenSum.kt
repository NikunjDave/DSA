package array02

/**
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 */
object FindSubArrayWithGivenSum {

    fun findAllSubArraysWithGivenSum(arr: IntArray, k: Int): Int {
        val n = arr.size // size of the given array.
        val mpp = HashMap<Int, Int>()
        var preSum = 0
        var cnt = 0

        mpp[0] = 1 // Setting 0 in the map.
        for (i in 0 until n) {
            // add current element to prefix Sum:
            preSum += arr[i]

            // Calculate x-k:
            val remove = preSum - k

            // Add the number of subarrays to be removed:
            cnt += mpp.getOrDefault(remove, 0)

            // Update the count of prefix sum
            // in the map.
            mpp[preSum] = mpp.getOrDefault(preSum, 0) + 1
        }
        return cnt
    }

}

fun main(){
    val count = FindSubArrayWithGivenSum.findAllSubArraysWithGivenSum(intArrayOf(1,2,3,4,5,5),5)
    println("Count is $count")
}