package array02

/**
 * Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 *
 */
object MaxSubArray {

    fun maxSubarraySum(arr: IntArray): Long {
        var maxi: Long = Long.MIN_VALUE // maximum sum
        var sum: Long = 0
        for (element in arr) {
            sum += element
            if (sum > maxi) {
                maxi = sum
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0
            }
        }

        // To consider the sum of the empty subarray
        // uncomment the following check:
        // if (maxi < 0) maxi = 0

        return maxi
    }

// Same problem return sub-array it-self
fun subArrayWithMaxSum(arr: IntArray): IntArray {
    var maxi: Long = Long.MIN_VALUE // maximum sum
    var sum: Long = 0
    var start = 0
    var end = 0
    for (i in arr.indices) {
        sum += arr[i]
        if (sum > maxi) {
            maxi = sum
            end = i
        }
        // If sum < 0: discard the sum calculated
        if (sum < 0) {
            sum = 0
            start = i+1
        }
    }
    return arr.sliceArray(start..end)
}
}


fun main(){
    val sum =MaxSubArray.maxSubarraySum(intArrayOf(-2,1,-3,4,-1,2,1,-5,4))
    println("sum is $sum")

    val maxArray = MaxSubArray.subArrayWithMaxSum(intArrayOf(-2,1,-3,4,-1,2,1,-5,4))
    println(maxArray.joinToString( ))
}