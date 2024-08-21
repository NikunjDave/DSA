package heap

import java.util.PriorityQueue

/**
 * Given an array of integers, arr, and an integer, k, return the k most frequent elements.
 * Input  = [1, 1, 1, 2, 2, 4, 5, 5], k = 3,
 * Output = [1,2,5]
 *
 */
object FrequentElement {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
       // val freqHeap = PriorityQueue<Pair<Int,Int>>()
        val freqHeap = PriorityQueue<Pair<Int, Int>> { e1, e2 -> e1.second - e2.second }

        val hashMap = mutableMapOf<Int,Int>()
        // store frequency
        for(num in nums){
            val freq = hashMap.getOrDefault(num,0) + 1
            hashMap[num] = freq
        }
        // add k element to queue from hashmap
        for(entry in hashMap){
            freqHeap.add(Pair(entry.key,entry.value))
            if(freqHeap.size > k)
                freqHeap.poll()
        }
        val output = IntArray(freqHeap.size)
        for(i in 0 until  freqHeap.size){
            output[i] = freqHeap.poll().first
        }
        return output
    }
    // different syntax
    fun topKFrequent2(nums: IntArray, k: Int): IntArray {
        // min heap
        val topKElement = PriorityQueue<Map.Entry<Int,Int>>({p1,p2 -> p1.value - p2.value})
        val hashmap = mutableMapOf<Int,Int>()
        // add frequency
        for(num in nums){
            val count = hashmap.getOrDefault(num,0) + 1
            hashmap[num] = count
        }

        for(entry in hashmap.entries){
            topKElement.add(entry)
            if(topKElement.size > k)
                topKElement.poll()
        }
        val output = IntArray(topKElement.size)
        var index = 0
        while(topKElement.size > 0){
            output[index++] = topKElement.poll().key
        }
        return output
    }

}

/**
 * Time Complexity  = O(n(log(k)) if k < n, if k =n than O(n(log(k))
 * Space Complexity = O(k+n)
 */
fun main(){
    val result = FrequentElement.topKFrequent2(intArrayOf(1, 1, 1, 2, 2, 4, 5, 5),3)
    println(result.joinToString())
}