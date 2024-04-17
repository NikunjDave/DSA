package fastsndslowpointer

import java.util.*
import kotlin.math.abs

class CircularArrayLoop {

    fun hasCircularArrayLoop(numbers: IntArray): Boolean{
        for (i in numbers.indices) {
            val prevDirection = numbers[i] >= 0
            var slow = i
            var fast = i

            while (true) {
                 slow = getNextIndex(slow,numbers[slow],numbers)
                if(isNotCycle(prevDirection,numbers,slow))
                   break

                fast = getNextIndex(fast,numbers[fast],numbers)
                if(isNotCycle(prevDirection,numbers,slow))
                   break

                fast = getNextIndex(fast,numbers[fast],numbers)

                if(isNotCycle(prevDirection,numbers,slow))
                    break

                if(numbers[slow] == numbers[fast])
                    return true
            }
        }

        return false
    }

    private fun getNextIndex(pointer: Int, value: Int, numbers: IntArray) : Int {
        var result = (pointer + value) % numbers.size
        if (result < 0)
            result += numbers.size
        return result
    }

    /**
     * if direction changed and if current pointer has the value which take to same index{resulting in single element circular}
     */
    private fun isNotCycle(prevDirection : Boolean, numbers: IntArray,pointer : Int) : Boolean{
        val currentDirection = numbers[pointer] >= 0
        return currentDirection != prevDirection || abs(numbers[pointer] % numbers.size) == 0
    }


    fun  checkCircularLoop(){
        val input = arrayOf(
            intArrayOf(-2, -3, -9),
            intArrayOf(-5, -4, -3, -2, -1),
            intArrayOf(-1, -2, -3, -4, -5),
            intArrayOf(2, 1, -1, -2),
            intArrayOf(-1, -2, -3, -4, -5, 6),
            intArrayOf(1, 2, -3, 3, 4, 7, 1),
            intArrayOf(2, 2, 2, 7, 2, -1, 2, -1, -1)
        )

        for (i in input.indices) {
            println((i + 1).toString() + ".\tCircular array = " + Arrays.toString(input[i]) + "\n")
            val result: Boolean = hasCircularArrayLoop(input[i])
            println("\tFound Loop = $result")
            repeat(100){ print("----") }
            println()
        }
    }

}