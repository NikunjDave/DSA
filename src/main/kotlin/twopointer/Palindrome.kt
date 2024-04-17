package twopointer

class Palindrome {
    // write a function that check given string is palindrome [ a string called palindrome whose reverse is also same]
    // "abba", "sararas" are examp;e
    fun isPalindrome(input : String?) : Boolean{
        if(input.isNullOrEmpty())
            return false
        else{
            // initialize two pointer
            var start = 0
            var end = input.length-1
            val array = input.toCharArray()
            // middle point condition
            while(start < end){
                // check for identical
                if(array[start] != array[end])
                    return false
                start ++
                end--
            }
        }
        return true
    }

    //leetcode version
    fun isPalindrome2(s: String): Boolean {
        //string.replace(Regex("[^A-Za-z]"),"").lowercase()
        val input = s.replace(Regex("[^A-Za-z0-9]"),"").lowercase()
        if(input.isEmpty())
            return true
        var first = 0
        var last = input.length-1
        while(first < last){
            if(input[first] != input[last])
                return false
            else{
                first++
                last --
            }
        }
        return true
    }

}