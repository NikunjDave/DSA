package array02

/**
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters.
 * The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 */
object ReverseWord {
    fun reverseWords(s: String): String {
        val words = s.trim().split(" ").toTypedArray()
        var start = 0
        var last = words.size -1
        while (start < last){
            // swap last and first element
            val temp = words[start]
            words[start] = words[last]
            words[last] = temp
            start ++
            last --
        }
        val stringBuilder = StringBuilder()
        for(word in words){
            if(word.trim().isNotEmpty()){
                stringBuilder.append(word)
                stringBuilder.append(" ")
            }
        }
        return stringBuilder.toString().trim()
    }

    fun reverseWords2(s: String): String {
        val sb = StringBuilder()

        var l = 0
        var r = 0

        while(r <= s.length) {
            if(r == s.length || s[r] == ' ') {
                if(r - l > 0) {
                    if(sb.length > 0) {
                        sb.insert(0, ' ')
                    }
                    sb.insert(0, s.substring(l, r))
                }
                r++
                l = r
            } else {
                r++
            }
        }

        return sb.toString()
    }
}