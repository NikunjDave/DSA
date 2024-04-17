package string01

/**
 * Given a string s consisting of words and spaces,
 * return the length of the last word in the string.
 *
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 *
 */
object LengthOfLastWord {
      fun lenOfLastWorld(words :String): Int{
          val substrings = words.trimEnd().split(" ")
          return substrings.get(substrings.size-1).length
      }

        // Without using inbuilt api
        fun lengthOfLastWord(words: String): Int {
            var count = 0
            for (i in words.length - 1 downTo 0) {
                when{
                    words[i] == ' ' && count == 0 -> continue
                    words[i] != ' ' -> count++
                    else -> break
                }
            }
            return count
        }
}