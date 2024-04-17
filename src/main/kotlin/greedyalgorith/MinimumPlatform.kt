package greedyalgorith

object MinimumPlatform {
    fun calculateMinPlatform(arrival: IntArray, depart: IntArray, size: Int): Int {
        var platformNeeded = 1 // to track max count in each loop
        //var count = 1
        var maxPlatform = 1
        var i = 1
        var j = 0

        while (i < size && j < size){
            // overlap condition
            if(arrival[i] <= depart[j]){
                platformNeeded ++
                i++
            } else if(arrival[i] < depart[j]){
                platformNeeded --
                j++
            }
            // update the max platform
            if(maxPlatform < platformNeeded)
                maxPlatform = platformNeeded
        }
        return maxPlatform
    }
}

fun main() {
    val output = MinimumPlatform.calculateMinPlatform(
        intArrayOf(900,940,950,1100,1500,1800),
        intArrayOf(910,1200,1120,1130,1900,2000),
        6)
    println("output is $output")
}