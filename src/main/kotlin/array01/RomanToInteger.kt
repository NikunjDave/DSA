package array01

import java.lang.StringBuilder

/**
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 */
object RomanToInteger {
    val romanMap = HashMap<Char,Int>()
    init {
        romanMap.put('I',1)
        romanMap.put('V',5)
        romanMap.put('X',10)
        romanMap.put('L',50)
        romanMap.put('C',100)
        romanMap.put('D',500)
        romanMap.put('M',1000)
    }
    fun convertToRomanToInt(roman: String): Int{
        var result = 0
        var lastChar = ' '
        for(character in roman){
            val str = StringBuilder().append(lastChar).append(character).toString()
            if(isSpecialCase(str)) {
                result -= romanMap[lastChar]!!
                result += romanMap[character]!! - romanMap[lastChar]!!
            }
            else
                result += romanMap[character]!!

            lastChar = character
        }
        return result
    }

    fun specialNumber(str : String): Int = when(str){
            "IV" -> 4
            "IX" -> 9
            "XL" -> 40
            "XC" -> 90
            "CD" -> 400
            "CM" -> 900
            else -> {-1}
        }

    fun isSpecialCase(str : String): Boolean =
        when(str){
        "IV", "IX", "XL","XC", "CD", "CM" -> true
        else -> false
    }

}