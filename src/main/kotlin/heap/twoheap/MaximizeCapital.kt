package heap.twoheap

import java.util.PriorityQueue

object MaximizeCapital {
    // capitals = 1,2,2,3
    // profits = 2,4,6,8
    // c = 1, k = 2
     fun totalProfit(capitals : IntArray, profits: IntArray, c: Int, k : Int): Int{
         val n = capitals.size
        var currentCapital = c

        // Min-heap based on capital required
        //val capitalMinHeap = PriorityQueue(compareBy<IntArray> { it[0] })
        val capitalMinHeap = PriorityQueue<IntArray> {a, b -> a[0] - b[0]}
        for (i in 0 until n) {
            capitalMinHeap.offer(intArrayOf(capitals[i], i))
        }
        // Max-heap based on profits
        //val profitsMaxHeap = PriorityQueue(compareByDescending<IntArray> { it[0] })
        val profitsMaxHeap = PriorityQueue<Int>{a,b -> b - a }
        var i = 0
        while (i < k) {
            while (capitalMinHeap.isNotEmpty() && capitalMinHeap.peek()[0] <= currentCapital) {
                val j = capitalMinHeap.poll()
                //profitsMaxHeap.offer(intArrayOf(profits[j[1]]))
                profitsMaxHeap.offer(profits[j[1]])
            }

            if (profitsMaxHeap.isEmpty()) {
                break
            }

            val x = profitsMaxHeap.poll()
            currentCapital += x
            i++
        }
        return currentCapital
    }

}

fun main(){
    val result = MaximizeCapital.totalProfit(intArrayOf(1,2,2,3), intArrayOf(2,4,6,8),1,2)
    println("total profit is $result")
}