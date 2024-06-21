package heap.twoheap

import java.util.PriorityQueue

/**
 * Given an integer array, nums, and an integer, k, there is a sliding window of size k,
 * which is moving from the very left to the very right of the array. We can only see the k numbers
 * in the window. Each time the sliding window moves right by one position.
 * E.g : input = [3,1,2,-1,0,5,8] and k = 4
 * output = [1.5,0.5,1.0,2.5]
 */
object SlidingWindowMedian {
    fun findMedians(nums: IntArray, k: Int): List<Double> {
        val n = nums.size
        val medianList = mutableListOf<Double>()
        // smallList for min number, max Heap
        val smallList = PriorityQueue<Int> { a, b -> b - a }
        // large list, min heap
        val largeList = PriorityQueue<Int>()
        // filled up the both list
        // first fill up the small list
        for (i in 0 until  k) {
            smallList.add(nums[i])
        }
        for (i in 0 until k / 2) {
            largeList.add(smallList.poll())
        }
        // hashmap to track outgoing nums
        val outNumMap = HashMap<Int, Int>()

        var i = k
        // keep track of balance both queue
        var balance = 0
        while (true) {
            // if size is odd
            val median =
                if ((k % 2) == 0)
                    smallList.peek() / 2.0 + largeList.peek() / 2.0
                else
                    smallList.peek().toDouble()

            println("median is $median")
            medianList.add(median)
            if(i == n)
                break

            val inNum = nums[i]
            val outNum = nums[i - k]
            i++
            // add out num to hashmap
            var count = outNumMap.getOrDefault(outNum, 0)
            outNumMap[outNum] = ++count
            // based on out-num balance variable
            if (outNum <= smallList.peek())
                balance -= 1
            else
                balance += 1

            if (inNum <= smallList.peek()) {
                balance += 1
                smallList.add(inNum)
            } else {
                balance -= 1
                largeList.add(inNum)
            }

            if (balance < 0)
                smallList.add(largeList.poll())
            else if (balance > 0)
                largeList.add(smallList.poll())

            balance  = 0
            // remove top element from small list if it contains in outNumMap
            while (smallList.size > 0 && outNumMap.containsKey(smallList.peek())&&
                outNumMap[smallList.peek()]!! > 0) {
                // reduce count
                var frq = outNumMap[smallList.peek()]
                outNumMap[smallList.poll()] = if (frq!! > 0) --frq else 0
            }

            // remove top element from small list if it contains in outNumMap
            while (largeList.size > 0 && outNumMap.containsKey(largeList.peek())&&
                outNumMap[largeList.peek()]!! > 0) {
                // reduce count
                var frq = outNumMap[largeList.peek()]
                outNumMap[largeList.poll()] = if (frq!! > 0) --frq else 0
            }

        }
        return medianList
    }

}

fun main(){
    val medians = SlidingWindowMedian.findMedians(intArrayOf(3,1,2,-1,0,5,8),4)
    println("median is ${medians.joinToString(", ")}")

}

