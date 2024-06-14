package heap

import java.util.*

/**
 * Given a string, str, rearrange it so that any two adjacent characters are not the same. If such a reorganization of
 * the characters is possible, output any possible valid arrangement. Otherwise, return an empty string.
 *
 * Input : "aaabc"
 * output : "abaca" or "acaba"
 * Input = "aaaab" o/p = ""
 */
object ReorganizeString {
    fun reorganizeString(s: String): String {
        val result = StringBuilder()
        val charCounter  = mutableMapOf<Char,Int>()
        // store frequency
        for(char in s){
            val freq = charCounter.getOrDefault(char,0)+1
            charCounter[char]= freq
        }
        val maxFreqChar = PriorityQueue<Map.Entry<Char, Int>>(compareByDescending { it.value })
        maxFreqChar.addAll(charCounter.entries)
        var prev : Map.Entry<Char,Int>? = null
        while(maxFreqChar.isNotEmpty() || prev != null){
            // check if string is invalid like aaab, we could not rearrange
            if(prev != null && maxFreqChar.isEmpty())
                return ""
            // pop first element
            val currentEntry = maxFreqChar.poll()
            // add to result and decrease count
            result.append(currentEntry.key)
            val count = currentEntry.value - 1
            //  The previous variable stores the previous character that we used so that we don’t use that character again.
            if(prev != null){
                maxFreqChar.add(prev)
                prev = null
            }
            // create a new entry and then add it to the queue
            if(count != 0){
                prev = AbstractMap.SimpleEntry(currentEntry.key,count)
            }
        }
        return result.toString()
    }
}

/**
 * Time Complexity : O(nlog(c)) c is the distinct char in string
 * Space Complexity : we are using fixed size of hashmap that is fix size of 26, O(1)
 */
fun main(){
    val result = ReorganizeString.reorganizeString("aaabc")
    println("output is $result")
}