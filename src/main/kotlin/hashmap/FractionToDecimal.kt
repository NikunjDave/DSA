package hashmap

import java.io.DataOutput
import java.lang.StringBuilder
import java.util.HashMap
import java.util.LinkedHashMap
import java.util.TreeMap
import kotlin.math.abs

/**
 * LC : 166
 */
object FractionToDecimal {
    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        val result = StringBuilder()
        val reminderMap = HashMap<Long,Int>()
        if(numerator == 0)
            return "0"
        // if anyone of then has - sign
        if((numerator < 0) xor (denominator < 0))
            result.append("-")

        val num = abs(numerator.toLong())
        val den = abs(denominator.toLong())

        var quotient = num/den
        var reminder = (num % den) * 10
        result.append(quotient)
        if(reminder == 0L)
            return result.toString()
        else {
            result.append(".")
            while(reminder != 0L){
                if(reminderMap.containsKey(reminder)){
                    val beginning = reminderMap[reminder]!!
                    val output = result.toString().substring(0,beginning)+"("+result.toString().substring(beginning)+")"
                    return output
                }else {
                    reminderMap[reminder] = result.length
                    quotient = reminder / den
                    reminder = (reminder % den) * 10
                    result.append(quotient)
                }
            }
        }
        return result.toString()
    }
}




fun main(){
    val result = FractionToDecimal.fractionToDecimal(8,666)
    println("output is $result")
}