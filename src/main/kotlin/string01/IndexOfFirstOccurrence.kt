package string01

/**
 * Given two strings needle and haystack,
 * return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0
 *
 * E.g. 2 -> haystack : "mississippi", needle ="issip"
 * return 4
 *
 */
object IndexOfFirstOccurrence {
    fun findFirstOccurrence(haystack: String, needle: String): Int {
        var index  = 0
        var charIndex = 0
        while (index < haystack.length && charIndex < needle.length){
            if(haystack[index] == needle[charIndex]) {
                charIndex++
                index ++
            }
            else {
                if(charIndex > 0)
                    index -= charIndex-1
               else
                   index++

                charIndex = 0
            }

        }
        if(charIndex == needle.length)
            return index - needle.length
        else
            return -1
    }

    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0
        if (haystack.isEmpty()) return -1
        if (haystack.length < needle.length) return -1
        for (i in 0..haystack.length - needle.length) {
            if (haystack.substring(i, i + needle.length) == needle) return i
        }
        return -1
    }

}