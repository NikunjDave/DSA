package heap

import java.util.PriorityQueue

/**
 * Leetcode : 826
 * You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:
 *
 * difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
 * worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
 * Every worker can be assigned at most one job, but one job can be completed multiple times.
 *
 * For example, if three workers attempt the same job that pays $1, then the total profit will be $3.
 * If a worker cannot complete any job, their profit is $0.
 * Return the maximum profit we can achieve after assigning the workers to the jobs.
 *
 * Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * Output: 100
 * Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get a profit of [20,20,30,30] separately.
 */
object MostProfitAssignment {
    fun maxProfit(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
        var maxProfit = 0
        val jobList = mutableListOf<Pair<Int,Int>>()
        for(i in profit.indices){
            jobList.add(Pair(difficulty[i],profit[i]))
        }
        jobList.sortBy { it.first }
        //worker.sort()
        val maxHeapProfit = PriorityQueue<Int>{a,b -> b-a}
        for(w in worker){
            var jobIndex = 0;
            while(jobIndex < jobList.size && jobList[jobIndex].first <= w){
                maxHeapProfit.offer(jobList[jobIndex].second)
                jobIndex ++
            }
            if(maxHeapProfit.isNotEmpty()) {
                // now add most profit to profit
                maxProfit += maxHeapProfit.poll()!!
                maxHeapProfit.clear()
            }
        }
        return maxProfit
    }

    fun maxProfit2(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
        val map = mutableMapOf<Int, Int>()

        for (i in profit.indices) {
            val current = map.getOrDefault(profit[i], Int.MAX_VALUE)
            map[profit[i]] = minOf(current, difficulty[i])
        }

        profit.sort()
        var res = 0
        worker.sort()

        // the profits that we have already checked
        var prev = profit.size - 1

        for (i in worker.indices.reversed()) {
            // start from the profit that n- 1th worker could achieve
            // As the workers are sorted as per their capabilities they can not achieve more profit than the previously checked worker
            for (j in prev downTo 0) {
                if (map[profit[j]]!! <= worker[i]) {
                    res += profit[j]
                    prev = j
                    break
                }
            }
        }

        return res
    }



}
fun main(){
    /*val profit = MostProfitAssignment.maxProfit(intArrayOf(2,4,6,8,10),
        intArrayOf(10,20,30,40,50), intArrayOf(4,5,6,7)
    )*/
    val profit = MostProfitAssignment.maxProfit2(intArrayOf(64,88,97),
        intArrayOf(53,86,89), intArrayOf(98,11,6)
    )


    println("profit is $profit")
}