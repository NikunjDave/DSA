package heap

import heap.twoheap.SlidingWindowMedian
import java.util.PriorityQueue
import kotlin.math.max

/**
 * Leetcode : 239
 * You are given an array of integers nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers in the window. Each time the
 * sliding window moves right by one position.
 * Input = Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 */
object SlidingWindowMaximum {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val outputArray = IntArray(n - k +1){0}
        // maxheap of k number
        val maxHeap = PriorityQueue<Int> { a, b -> b - a }
        for (i in 0 until k) {
            maxHeap.add(nums[i])
        }
        // hashmap to add out number and frequency
        var i = k
        val hashmap = mutableMapOf<Int, Int>()
        var outputIndex = 0
        while (true) {
            outputArray[outputIndex] = maxHeap.peek()
            outputIndex ++
            if (i == n)
                break
            val inNum = nums[i]
            val outNum = nums[i-k]
            i++
            // add the highest number to array

            // add outnumber to hashmap
            val freq = hashmap.getOrDefault(outNum, 0) + 1
            hashmap[outNum] = freq

            // now add in num to maxHeap
            maxHeap.add(inNum)
            // check if the peek number is in hashmap then it should be removed from heap
            while (maxHeap.size > 0 && hashmap.containsKey(maxHeap.peek()) && hashmap[maxHeap.peek()]!! > 0) {
                // remove it from heap and also reduce freq
                hashmap[maxHeap.peek()] = hashmap[maxHeap.peek()]!! - 1
                maxHeap.poll()
            }
        }
        return outputArray
    }
}

fun main() {
    ///val result = SlidingWindowMaximum.maxSlidingWindow(intArrayOf(1,3,-1,-3,5,3,6,7),3)
    val result = SlidingWindowMaximum.maxSlidingWindow(intArrayOf(1),1)
    println("output is ${result.joinToString(", ")}")
}