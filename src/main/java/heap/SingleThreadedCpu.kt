package heap

import heap.twoheap.ScheduleTask
import java.util.PriorityQueue

/**
 * LeetCode : 1834
 * Given a tasks 0 to n-1 represented by 2D integer array tasks where
 * tasks[i] = [enqueueTime,processingTime]
 * you have single threaded CPU that can process one task at a time
 * Input: tasks = [[1,2],[2,4],[3,2],[4,1]]
 * Output: [0,2,3,1]
 */

data class Task(val procTime:Int, val index:Int)

/**
 * Solution
 * 1. First create minHeap that will have list of(procurement time, index)
 * 2. Now we will traverse the task list(start_time,proc_time,index)
 * 3. will create a minHeap(procTime,index),
 * 4. Initialize current time = first task time
 * 5. will add all task to min heap, where startTime of tasks <= currentTime
 * 6. and then  we will remove head from heap and update currentTime += task.procTime
 * 7. and add the root index to result array
 * 8. exit the loop when minHeap is empty
 */
object SingleThreadedCpu {
    fun getOrder(tasks: Array<IntArray>): IntArray {
        val n = tasks.size
        val output = IntArray(n)
        // create taskList which also has index
        val taskList = Array(n){IntArray(3)}
        for (i in 0 until n) {
            taskList[i][0] = tasks[i][0] // start time
            taskList[i][1] = tasks[i][1] // proc time
            taskList[i][2] = i // index
        }

        // create min-heap of tasks where task are sorted, based proc time, if same then index
        val minHeap = PriorityQueue<Task> { a, b ->
            if(a.procTime == b.procTime) a.index - b.index
            else a.procTime- b.procTime
        }
        // track currentTime
        var time = 0
        var i = 0
        var ansIndex = 0
        while(i < n || minHeap.isNotEmpty()) {
            if(minHeap.isEmpty())
                time = maxOf(time, taskList[i][0])
            while (i < n && time >= taskList[i][0]) {
                // add to minHeap
                minHeap.add(Task(taskList[i][1], taskList[i][2]))
                i++
            }
            // remove root and add index to output array
            val root = minHeap.poll()
            time += root.procTime
            output[ansIndex++] = root.index
        }
        return output
    }
}

fun main(){
    val output = SingleThreadedCpu.getOrder(arrayOf(
        intArrayOf(1,2),
        intArrayOf(2,4),
        intArrayOf(3,2),
        intArrayOf(4,1)))

    println("output array is ${output.joinToString(" ")}")
}
