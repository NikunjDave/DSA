package string01
/**
 * Given two strings s and t, return true if s is a subsequence of t,
 * or false otherwise.
 *
 * ex. Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * */
object SubSequence {
    fun isSubsequence(s: String, t: String): Boolean {
        if(s.isEmpty())
            return true
        if(s.isEmpty() && t.isEmpty())
            return true
        if(t.isEmpty())
            return false
        if(s.length > t.length)
            return false
        var index = 0
        var subIndex = 0
        while(index < t.length){
            if(t[index] == s[subIndex])
                subIndex++
            if(subIndex == s.length)
                return true
            index ++
        }
        return false
    }
}