package array02

/**
 * You are given an array 'a' of size 'n' and an integer 'k'.
 *
 *
 *
 * Find the length of the longest subarray of 'a' whose sum is equal to 'k'.
 *
 *
 *
 * Example :
 * Input: ‘n’ = 7 ‘k’ = 3
 * ‘a’ = [1, 2, 3, 1, 1, 1, 1]
 *
 * Output: 3
 *
 * Explanation: Subarrays whose sum = ‘3’ are:
 *
 * [1, 2], [3], [1, 1, 1] and [1, 1, 1]
 *
 * Here, the length of the longest subarray is 3, which is our final answer.
 *
 */
object LargestSubArray {
        fun findLargestSubArray(nums : IntArray,target :Int): Int{
            val len = nums.size
            var maxLen = 0
            var left = 0
            var right = 0
            var sum = nums[left]
            while (right < len){
                // when sum is more than target value in that case move left by 1
                // and update sum as well
                while(left <= right && sum > target){
                    sum -= nums[left]
                    left ++
                }
                if(sum == target){
                   maxLen = Math.max(maxLen,right-left + 1)
                   sum = 0
                } else {
                    sum += nums[right]
                }
                right ++
            }

            return maxLen
        }

}
fun main(){
    val output = LargestSubArray.findLargestSubArray(intArrayOf(1, 2, 3, 1, 1, 1, 1),5)
    println("size of largest sub-array is $output")
}