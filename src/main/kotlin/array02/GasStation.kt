package array02

import kotlin.math.cos
import kotlin.math.sign

/**
 * Given two integer arrays gas and cost, return the starting gas station's index
 * if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1. If there exists a solution, it is guaranteed to be unique
 *
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 *
 *
 */
object GasStation {
    // in complete solution,
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var totalGas = 0
        var indexCost = 0
        var indexGas = 0
        var visited = 0
        var startPointer = 0
        while (visited <= cost.size && startPointer < cost.size) {
            if(visited == cost.size)
                return startPointer
            indexGas %= gas.size
            indexCost %= cost.size
            totalGas += gas[indexGas]
            totalGas -= cost[indexCost]
            if (totalGas < 0) {
                visited = 0
                totalGas = 0
                startPointer ++
                indexGas = startPointer
                indexCost = startPointer
            } else {
                visited++
                indexGas++
                indexCost++
            }
        }
        return -1
    }

    fun canCompleteCircuit2(gas: IntArray, cost: IntArray): Int {
        var currRemaining = 0
        var totalRemaining = 0
        var start = 0
        for (i in cost.indices){
            val remaining = cost[i] - gas[i]
            if(currRemaining < 0){
                start = i
                currRemaining = remaining
            }else{
                currRemaining += remaining
            }
            totalRemaining += remaining
        }

        if (totalRemaining < 0)
            return -1
        else
            return start


    }

    fun canCompleteCircuit3(gas: IntArray, cost: IntArray): Int {
        var start = 0
        var surplus = 0
        var totalSurplus = 0

        for(i in gas.indices) {
            val gain = gas[i] - cost[i]
            totalSurplus += gain
            surplus += gain
            if(surplus < 0) {
                surplus = 0
                start = i+1
            }

        }

        if(totalSurplus < 0)
            return -1
        return start
    }

}