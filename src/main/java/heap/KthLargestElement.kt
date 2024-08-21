package heap

import java.util.PriorityQueue

/**
 * Given an infinite stream of integers (sorted or unsorted), nums, design a class to find the 𝑘𝑡ℎ largest element in a
 * stream.
 * Input  = 3,6,9,12, k = 3
 * output  = 6
 */
object KthLargestElement {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int>()
        for(num in nums){
            if(queue.size < k) {
                queue.offer(num)
                continue
            }
            if(num > queue.peek()){
               queue.poll()
                queue.offer(num)
            }
        }
        return queue.peek()
    }

}

/**
 * Time complexity : O(nlogk) adding into heap takes O(logk)
 * Space Complexity : O(k)
 */
fun main(){
    val result = KthLargestElement.findKthLargest(intArrayOf(6,3,9,12),3)
    println("largest is $result")
}