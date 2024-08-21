package hashmap

/**
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 *
 *
 * Example 1:
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 */
object WordPattern {
    fun wordPattern(pattern: String, s: String): Boolean {
        val hashmap = hashMapOf<Char, String>()
        val arrayOfString = s.split(" ")
        val arrayOfChar = pattern.toCharArray()
        if(arrayOfChar.size != arrayOfString.size)
            return false
        var index = 0
        while (index in arrayOfChar.indices){
            val key = arrayOfChar[index]
            val value = arrayOfString[index]
            if(hashmap.contains(key)){
                // current string should match
                if(hashmap.get(key) != value)
                    return false
            }else if(hashmap.containsValue(value)) {
                    return false
            }else{
                hashmap.put(key, arrayOfString[index])
            }
            index ++
        }
        return true
    }

    fun wordPattern2(pattern: String, s: String): Boolean {

        val words = s.split(" ")

        if(words.size != pattern.length) return false

        if(words.toSet().size != pattern.toSet().size) return false

        val map = mutableMapOf<Char, String>()

        for(i in pattern.indices) {
            map[pattern[i]]?.let { if(it != words[i]) return false }
            map[pattern[i]] = words[i]
        }

        return true
    }
}