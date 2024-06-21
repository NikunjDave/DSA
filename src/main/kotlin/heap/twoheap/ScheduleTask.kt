package heap.twoheap

import java.util.PriorityQueue

/**
 * We are given an input array, tasks, which contains the start and end times of 𝑛 tasks.
 * Your task is to find the minimum number of machines required to complete these n tasks.
 *  E.g
 *  Input = [(1,7),(6,7),(5,6),(10,14),(8,13)] // Start and end time array
 *  Output = 2 machines
 */
object ScheduleTask {
        fun machineRequired(tasksList: List<IntArray>): Int{
            var optimalMachines = 0

            // 0th index is task min time of end time and 1th is for total count
            val machinesAvailable = PriorityQueue(compareBy<IntArray> { it[0] })
            //val tasksQueue = PriorityQueue(compareBy<IntArray> { it[0] })
            val tasksQueue = PriorityQueue(compareBy<IntArray> { it[0] })
            // first add task to task queue
            for (task in tasksList){
                tasksQueue.offer(intArrayOf(task.get(0),task.get(1)))
            }
            while(tasksQueue.isNotEmpty()){
                val task = tasksQueue.poll()
                var machineInUse : IntArray
                // if task in not overlapping, update machineAvailable time
                if(machinesAvailable.isNotEmpty() && task[0] >= machinesAvailable.peek()[0]){
                    machineInUse = machinesAvailable.peek()
                    machineInUse[0] = task[1]
                }else{ // increase machine count
                    optimalMachines += 1
                    machineInUse = intArrayOf(task[1], optimalMachines)
                }
                machinesAvailable.offer(machineInUse)
            }
            return optimalMachines
        }
}

/**
 * Time complexity : O(n(log(n))) : n is size of the heap
 * Space complexity : O(n) + O(n) -> O(2n) as we are maintaining two heap
 */
fun main(){
    val input = mutableListOf<IntArray>(
        intArrayOf(1,7),intArrayOf(6,7),intArrayOf(5,6),intArrayOf(10,14),intArrayOf(8,13))
    val input2 = mutableListOf<IntArray>(
        intArrayOf(1,7),intArrayOf(1,7),intArrayOf(1,7),intArrayOf(1,7),intArrayOf(1,7))

    val machine = ScheduleTask.machineRequired(input2)
    println("required machine $machine")
}