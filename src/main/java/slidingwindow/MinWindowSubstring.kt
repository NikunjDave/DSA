package slidingwindow

/**
 * Given two strings, s and t, find the minimum window substring in s, which has the following properties:
 * 1. It is the shortest substring of s that includes all of the characters present in t.
 * 2. It must contain at least the same frequency of each character as in t.
 * 3.The order of the characters does not matter here.
 * e.g. : s = "ACBBACA" and t = "ABA"
 *  output = "BACA"
 */
object MinWindowSubstring {
    fun minWindowString(s: String, t: String): String {
        // prepare map for char-frequency
        val requiredMap = mutableMapOf<Char, Int>()
        val windowMap = mutableMapOf<Char, Int>()
        for (char in t) {
            requiredMap.putIfAbsent(char, 0)
            requiredMap[char] = requiredMap[char]!! + 1
        }
        for (char in s) windowMap.putIfAbsent(char, 0)
        // we will increase current by 1 when frequency of single char matched
        var current = 0
        val required = requiredMap.size

        var minString = ""
        var minLength = Int.MAX_VALUE

        var left = 0
        for (right in s.indices) {
            val char = s[right]
            // fill map only when it is part of t
            if (t.indexOf(char) != -1) {
                windowMap[char] = windowMap[char]!! + 1
            }
            // when count are matched, increase current
            if (requiredMap.containsKey(char) && windowMap[char] == requiredMap[char]) {
                current++
            }
            while (current == required) {
                // calculate min string
                if ((right - left + 1) < minLength) {
                    minString = s.substring(left, right + 1)
                    minLength = right - left + 1
                }
                val leftChar = s[left]
                // remove left char from windowMap
                if (t.indexOf(leftChar) != -1) {
                    windowMap[leftChar] = windowMap[leftChar]!! - 1
                }
                // now if frequency is lower than decrease current count
                if (requiredMap.containsKey(leftChar) && windowMap[leftChar]!! < requiredMap[leftChar]!!) {
                    current--
                }
                left++
            }
        }
        return minString
    }
}
// time complexity = O(n+m) n is size of s and m is size of t
// in worst case it could be  = O(m+(n*m))

// space complexity is O(1). since regarding the length of string, it will always have 26 char in map
fun main(){
//    val result = MinWindowSubstring.minWindowString("ACBBACA","ABA")
    val result = MinWindowSubstring.minWindowString("ABDOEDECOBE","BC")
    println(result)
}