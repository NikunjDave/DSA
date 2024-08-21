package array02

/**
 * Problem Statement: Given an array containing both positive and negative integers,
 * we have to find the length of the longest subarray with the sum of all elements equal to zero.
 *
 * Example 1:
 * Input Format
 * : N = 6, array[] = {9, -3, 3, -1, 6, -5}
 * Result
 * : 5
 * Explanation
 * : The following subarrays sum to zero:
 * {-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
 * Since we require the length of the longest subarray, our answer is 5!
 *
 *
 */
object LongestSubArrayWithZeroSum {

    fun findLengthOfLongestSubArray(nums : IntArray) : Int{
        val hashMap = HashMap<Int,Int>()
        var sum = 0
        var maxCount = 0
        for(i in nums.indices){
            sum += nums[i]
            if(sum == 0){
              maxCount = i+1
            }else{
                if(hashMap.containsKey(sum)){
                    maxCount = maxOf(maxCount,i- hashMap.get(sum)!!)
                }else{
                    hashMap.put(sum,i)
                }
            }
        }
        return maxCount
    }
}

fun main(){
    val maxCount = LongestSubArrayWithZeroSum.findLengthOfLongestSubArray(intArrayOf(9, -3, 3, -1, 6, -5))
    println("max count is $maxCount")

}