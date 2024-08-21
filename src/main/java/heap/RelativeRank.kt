package heap

import java.util.PriorityQueue

/**
 * Leetcode : 506
 * You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition.
 * All the scores are guaranteed to be unique.
 *
 * Input: score = [10,3,8,9,4]
 * Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].
 *
 */
object RelativeRank {
    fun findRank(score: IntArray): Array<String>{
        val n = score.size
        val output = Array(n){""}
        val hashMap = mutableMapOf<Int, String>()
        // maxHeap with hashmap
        val maxHeapScore = PriorityQueue<Int>{a,b -> b - a}
        var index = 0
        maxHeapScore.addAll(score.toTypedArray())
        // iterate over queue and add rank
        while (index < n) {
            val root = maxHeapScore.poll()
            hashMap[root] = when (index) {
                0 -> "Gold Medal"
                1 -> "Silver Medal"
                2 -> "Bronze Medal"
                else -> (index+1).toString()
            }
            index++
        }
        // fill result array

        for(i in 0 until n){
            output[i] = hashMap.get(score[i])!!
        }
        return output
    }

    /**
     * Optimum way without using queue
     */
    fun findRelativeRanks(score: IntArray): Array<String> {
        val pairs = score.mapIndexed { index, value -> Pair(index, value) }.toMutableList()
        pairs.sortByDescending { it.second }
        val result = Array<String>(score.size) { "" }
        for (i in pairs.indices) {
            when (i) {
                0 -> result[pairs[i].first] = "Gold Medal"
                1 -> result[pairs[i].first] = "Silver Medal"
                2 -> result[pairs[i].first] = "Bronze Medal"
                else -> result[pairs[i].first] = "${i + 1}"
            }
        }
        return result
    }
}

fun main(){
    val output = RelativeRank.findRank(intArrayOf(10,3,8,9,4))
    println(output.joinToString(" "))

}