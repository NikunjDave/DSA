package mergeinterval

import kotlin.math.sign

object InsertInterval {

    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val outputList = mutableListOf<IntArray>()
        val newStart = newInterval[0]
        val newEnd = newInterval[1]
        var i  = 0
        val n = intervals.size
        // add all interval that starts before new start interval
        while (i < n && intervals[i][0] < newStart){
            outputList.add(intervals[i])
            i++
        }

        // If the new interval starts after the end of the last interval appended to the output list,
        // just append the new interval to the output list.
        if(outputList.size == 0 || outputList[outputList.size -1][1] < newStart){
            outputList.add(newInterval)
        }else{
            val maxEnd = maxOf(outputList[outputList.size -1][1],newEnd)
            outputList[outputList.size-1][1] = maxEnd
        }

        // Now add the remaining interval to output list and also merge them if they overlap that is by checking
        // end of last interval in output list is less than start of next interval
        while (i < n){
            val existingInterval = intervals[i]
            val start = existingInterval[0]
            val end = existingInterval[1]
            if(outputList[outputList.size -1][1] < start){
                outputList.add(existingInterval)
            }else{
                // merge them
                val maxEnd = maxOf(end,outputList[outputList.size-1][1])
                outputList[outputList.size-1][1] = maxEnd
            }
            i++
        }
        return outputList.toTypedArray()
    }
}
fun main(){
    val output = InsertInterval.insert(arrayOf(intArrayOf(1,3),intArrayOf(6,9)),
        intArrayOf(2,5)
    )
    //1,2],[3,5],[6,7],[8,10],[12,16]

    val output2 = InsertInterval.insert(
        arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16)),
        intArrayOf(4,8)
    )
    output2.forEach {
        println(it.joinToString())
    }
}