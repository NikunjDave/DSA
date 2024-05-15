package twopointer

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 */
object LengthOfLongestSubString {
    fun lengthOfLongestSubstring(s: String): Int {
        val visited = Array<Boolean>(256){false}
        var left = 0
        var right = 0
        var result = 0
        while(right < s.length){
            while (visited[s[right].code]){
                visited[s[left].code] = false
                left ++
            }
            visited[s[right].code] = true
            right ++
            result = maxOf(result,right - left)
        }
        return result
    }

    fun withoutTwoPointer(s: String): Int {
        var strTemp = StringBuilder()
        var result = 0
        for(char in s){
            if(!strTemp.contains(char)){
                strTemp.append(char)
            }else{
             // substring till the char
               val index = strTemp.indexOf(char)
               strTemp = strTemp.replace(0,index,"")
               strTemp.append(char)
            }
            result = maxOf(result,strTemp.length)
        }

        return result
    }

}

fun main(){
    val length = LengthOfLongestSubString.withoutTwoPointer("abcab")
    println("length is $length")
}