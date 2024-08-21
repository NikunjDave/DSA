package hashmap

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 */
object ValidAnagram {

    fun isAnagram(s: String, t: String): Boolean {
        val listOfChar = s.toCharArray().toMutableList()
        if(s.length  != t.length)
            return false
        for(char in t){
            if(listOfChar.contains(char)){
                listOfChar.remove(char)
            }else {
               return false
            }
        }
        return true
    }

    fun isAnagram2(s: String, t: String): Boolean {
        var sCounter = count(s)
        var tCounter = count(t)
        return sCounter == tCounter

    }
    fun count(str: String): Map<Char, Int>{
        var result = hashMapOf<Char, Int>()
        for (char in str){
            var cntr = result.getOrDefault(char, 0)
            result[char] = cntr + 1
        }
        return result
    }

    // other approach without hashmap

    fun isAnagram3(s: String, t: String): Boolean {
       val letterArray = IntArray(26)
        for(letter in s){
          letterArray[letter - 'a']  += 1
        }
        for(letter in t){
            letterArray[letter - 'a'] -= 1
        }
        for (count in letterArray){
            if (count != 0)
                return false
        }
       return true
    }
}