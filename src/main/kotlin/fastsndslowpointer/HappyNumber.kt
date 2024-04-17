package fastsndslowpointer

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * A number is called happy number if sum of square of digit is 1.
 * e.g 23 is happy number -> (4+9) -> 13 -> (1+9) = 10 -> (1 + 0) -> 1
 * to identify the happy number we can use fast and slow pointer.
 * Note : slow take 1 step and fast take 2 step, so basically these help to identify cycle
 * so if both slow and fast reached to same spot(it means there is cycle)
 * Steps
 * 1. init slow = number, and fast = square of number
 * if fast =1 return true,  if fast == slow return false (cycle detected)
 * else continue step, move slow by and fast by 2.
 */
class HappyNumber {
    fun isHappyNumber(input: Int): Boolean{
        var slow = input
        var fast = squareOfNumber(input)
        while(fast != 1 && slow != fast){
            slow = squareOfNumber(slow)
            fast = squareOfNumber(squareOfNumber(fast))
        }
        return fast == 1
    }


    private fun squareOfNumber(number: Int): Int {
        var num = number
        var total = 0
        while (num > 0) {
            val digit = num % 10
            num /= 10
            total +=  digit.toDouble().pow(2).toInt()
        }
        return total
    }
}