package hashmap

/**
 * LC : 266
 *
 * For a given string, st, find whether or not a permutation of this
 * string is a palindrome. You should return TRUE if such a permutation is possible and FALSE if it isn’t possible.
 *
 *  EX: abb -> true : aba
 *  abx -> no palindrome found
 *
 */
object PalindromePermutation {

    fun palindromePermutation(str: String): Boolean {
        val hashmap = mutableMapOf<Char, Int>()
        for (char in str) {
            // add char count in hashmap
            hashmap[char] = hashmap.getOrDefault(char, 0) + 1
        }
        // now if the count of char with odd number is > 1 then no palindrome exist
        var count = 0
        for (values in hashmap.values) {
            if (count > 1)
                return false
            if (values % 2 != 0)
                count++
        }
        return true
    }
}

fun main() {
    val output = PalindromePermutation.palindromePermutation("abb")
    println(output)
}