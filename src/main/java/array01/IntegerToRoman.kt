package array01

/**
 * Input: 3
 * output = "III"
 *
 * Example 2:
 *
 * Input: s = "58"
 * output = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 */
object IntegerToRoman {

    private val romanNumberMap = mapOf<Int, String>(
        1 to "I",
        4 to "IV",
        5 to "V",
        9 to "IX",
        10 to "X",
        40 to "XL",
        50 to "L",
        90 to "XC",
        100 to "C",
        400 to "CD",
        500 to "D",
        900 to "CM",
        1000 to "M"
    )

    fun intToRoman1(num: Int): String {
        var romanNumber = ""
        var number = num
        while(number > 0) {
            val currentNumber = when {
                number >= 1000 -> 1000
                number >= 900 -> 900
                number >= 500 -> 500
                number >= 400 -> 400
                number >= 100 -> 100
                number >= 90 -> 90
                number >= 50 -> 50
                number >= 40 -> 40
                number >= 10 -> 10
                number == 9 -> 9
                number >= 5 -> 5
                number == 4 -> 4
                else -> 1
            }
            val count = (number / currentNumber)
            (0 until count).forEach {
                romanNumber += romanNumberMap[currentNumber].orEmpty()
            }
            number -= (currentNumber * count)
        }
        return romanNumber
    }

    fun intToRoman(num: Int): String {
        val values = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val symbols = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        val sb = StringBuilder()

        var number = num
        var i = 0
        while (i < values.size) {
            if (number == 0) {
                break
            }
            while (number >= values[i]) {
                number -= values[i]
                sb.append(symbols[i])
            }
            i++
        }

        return sb.toString()
    }


}