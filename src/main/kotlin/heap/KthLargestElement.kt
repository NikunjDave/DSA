package heap

import java.util.PriorityQueue

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
    val result = KthLargestElement.findKthLargest(intArrayOf(3,6,9,12),3)
    println("result is $result")
}