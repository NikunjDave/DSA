package slidingwindow

import java.util.*
import kotlin.collections.ArrayDeque

/**
 * Find max number in given sliding window
 * Given an integer list, nums, find the maximum values
 * in all the contiguous subarrays (windows) of size w.
 * E.g. [4,2,-5,3,6] window size = 3
 * output = 2,3,6
 *
 */
object MaxNumber {
    fun cleanUp(i: Int, currentWindow: Deque<Int>, nums: IntArray): Deque<Int> {
        while (currentWindow.isNotEmpty() && nums[i] >= nums[currentWindow.last]) {
            currentWindow.removeLast()
        }
        return currentWindow
    }

    // Function to find the maximum in all possible windows
    fun findMaxSlidingWindow(nums: IntArray, w: Int): IntArray {
        if (nums.size == 1) {
            return nums
        }
        val output = IntArray(nums.size - w + 1)
        val currentWindow: Deque<Int> = LinkedList()
        for (i in 0 until w) {
            cleanUp(i, currentWindow, nums)
            currentWindow.add(i)
        }
        output[0] = nums[currentWindow.first]
        for (i in w until nums.size) {
            cleanUp(i, currentWindow, nums)
            if (currentWindow.isNotEmpty() && currentWindow.first <= (i - w)) {
                currentWindow.removeFirst()
            }
            currentWindow.add(i)
            output[i - w + 1] = nums[currentWindow.first]
        }
        return output
    }

}

fun main() {
    val result = MaxNumber.findMaxSlidingWindow(intArrayOf(4, 5, 6, 1, 2, 3), 3)
    println(result.joinToString(", "))
}