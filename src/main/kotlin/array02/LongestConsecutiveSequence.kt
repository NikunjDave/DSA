package array02

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 */
object LongestConsecutiveSequence {
    fun solution(nums: IntArray): Int {
        var maxCount = 0
        val numberSet = mutableSetOf<Int>()
        for (element in nums){
            numberSet.add(element)
        }

        for (element in nums){
            // pick the start element only
            if(!numberSet.contains(element -1)){
                var next = element + 1
                var count  = 1
                while (numberSet.contains(next)){
                    count ++
                    next += 1
                }
                maxCount = maxOf(count,maxCount)
            }
        }
        return maxCount
    }
}

fun main(){
    val count = LongestConsecutiveSequence.solution(intArrayOf(100, 200, 1, 2, 3, 4))
    println("longest consecutive count is $count")
}