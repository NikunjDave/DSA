package hashmap

/**
 * Given two strings ransomNote and magazine,
 * return true if ransomNote can be constructed by
 * using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 */
object RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val magzineMap = mutableListOf<Char>()
        for (i in magazine) {
            magzineMap.add(i)
        }
        for(i in ransomNote){
             if(magzineMap.contains(i)){
                 magzineMap.remove(i)
                 continue
             } else
                 return false
        }
       return true
    }

}