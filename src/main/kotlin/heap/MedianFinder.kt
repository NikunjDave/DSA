package heap

import java.util.*

/**
 * Leetcode : 295
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 */
class MedianFinder{
    private val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
    private val minHeap = PriorityQueue<Int>()

    fun addNum(num: Int) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num)
        } else {
            minHeap.offer(num)
        }

        // Balance the two heaps so that
        // |maxHeap| >= |minHeap| and |maxHeap| - |minHeap| <= 1
        if (maxHeap.size < minHeap.size) {
            maxHeap.offer(minHeap.poll())
        } else if (maxHeap.size - minHeap.size > 1) {
            minHeap.offer(maxHeap.poll())
        }
    }

    fun findMedian(): Double {
        return if (maxHeap.size == minHeap.size) {
            (maxHeap.peek() + minHeap.peek()) / 2.0
        } else {
            maxHeap.peek().toDouble()
        }
    }

}

/**
 * Time Complexity
 * : Adding number in heap is O(n(log(n))/n = 0(log(n))
 *   and finding median is constant = O(1)
 *
 *  Space complexity  = O(n)
 */

fun main(){
    val numArray = intArrayOf(35, 22, 30, 25)
    val medianFinder = MedianFinder()
    for(num in numArray){
        medianFinder.addNum(num)
    }
    val median = medianFinder.findMedian()
    println("median is $median")

}