package binarysearch

import java.util.*

class RandomPickWithWeight {
    private var runningSums = mutableListOf<Int>()
    private var totalSum = 0

    constructor(weights: IntArray) {
        var runningSum = 0
        for (w in weights) {
            runningSum += w
            runningSums.add(runningSum)
        }
        totalSum = runningSum
    }

     fun pickIndex(): Int {
        val random = Random()
        val target = random.nextInt(totalSum) + 1
        var low = 0
        var high = runningSums.size
        while (low < high) {
            val mid = low + (high - low) / 2
            if (target > runningSums[mid]) {
                low = mid + 1
            } else {
                high = mid
            }
        }
        return low
    }

    companion object{
        fun sum(arr: IntArray): Int {
            var total = 0
            for (num in arr) {
                total += num
            }
            return total
        }


        fun randomPickWeightTest(){
            val counter = 900 // on small number result higher weight selection probabiliy may loa
            val weights = arrayOf(
                intArrayOf(5,4,3,2,1),
                intArrayOf(1, 12, 23, 34, 45, 56, 67, 78, 89, 90),
                intArrayOf(10, 20, 30, 40, 50),
                intArrayOf(1, 10, 23, 32, 41, 56, 62, 75, 87, 90),
                intArrayOf(12, 20, 35, 42, 55),
                intArrayOf(10, 10, 10, 10, 10),
                intArrayOf(10, 10, 20, 20, 20, 30),
                intArrayOf(1, 2, 3),
                intArrayOf(10, 20, 30, 40),
                intArrayOf(5, 10, 15, 20, 25, 30)
            )
            val map = HashMap<Int, Int>()
            for (i in weights.indices) {
                println((i + 1).toString() + ".\tList of weights: " + Arrays.toString(weights[i]) + ", pick_index() called " + counter + " times" + "\n")
                for (l in weights[i].indices) {
                    map[l] = 0
                }
                val sol = RandomPickWithWeight(weights[i])
                for (j in 0..<counter) {
                    val index: Int = sol.pickIndex()
                    map[index] = map[index]!! + 1
                }

                repeat(100){ print("-") }
                println()
                println(
                    "\t" + String.format(
                        "%-10s%-5s%-10s%-5s%-15s%-5s%-20s%-5s%-15s",
                        "Indexes",
                        "|",
                        "Weights",
                        "|",
                        "Occurrences",
                        "|",
                        "Actual Frequency",
                        "|",
                        "Expected Frequency"
                    )
                )
                //println(kotlin.String(CharArray(100)).replace('\u0000', '-'))
                repeat(100){ print("-") }
                println()
                for ((key,value) in map.entries){
                    println(
                        "\t" + String.format(
                            "%-10s%-5s%-10s%-5s%-15s%-5s%-20s%-5s%-15s",
                            key, "|", weights[i][key], "|", value, "|",
                            String.format("%.2f", value.toDouble() / counter * 100) + "%", "|",
                            String.format(
                                "%.2f",
                                weights[i][key].toDouble() / sum(weights[i]) * 100
                            ) + "%"
                        )
                    )
                }

                map.clear()
                repeat(100){ print("-") }
                println()
            }
        }
    }
}