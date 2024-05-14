package string02

/**
 * CountAndSay : 38
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the run-length encoding of countAndSay(n - 1).
 *
 * Input: n = 4
 *
 * Output: "1211"
 *
 * Explanation:
 *
 * countAndSay(1) = "1"
 * countAndSay(2) = RLE of "1" = "11"
 * countAndSay(3) = RLE of "11" = "21"
 * countAndSay(4) = RLE of "21" = "1211"
 *
 */
object CountAndSay {

    fun countAndSay(n: Int): String? {
        if (n <= 0) {
            return null
        }
        var result = "1"
        var i = 1
        while (i++ < n) {
            val sb = StringBuilder()
            var count = 1
            var j = 1
            while (j < result.length) {
                if (result[j] == result[j - 1]) {
                    count++
                } else {
                    sb.append(count)
                    sb.append(result[j - 1])
                    count = 1
                }
                j++
            }
            sb.append(count)
            sb.append(result[result.length - 1])
            result = sb.toString()
        }
        return result
    }
}

fun main(){
    val result = CountAndSay.countAndSay(29)
    println(result)
}