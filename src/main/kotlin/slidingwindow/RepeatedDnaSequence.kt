package slidingwindow

/**
 * Given a string, s, that represents a DNA subsequence, and a number 𝑘, k
 * return all the contiguous subsequences (substrings) of length,
 *  that occur more than once in the string. The order of the returned subsequences does not matter.
 *  If no repeated substring is found, the function should return an empty set.
 *
 *  E.g. "GAGTCACAGTAGTTTCA" k = 3
 *  ouput : AGT, TCA
 */
object RepeatedDnaSequence {
    fun naiveApproach(input : String, k : Int) : List<String>{
        var start = 0
        val hashset = mutableSetOf<String>()
        val output = mutableListOf<String>()
        while(start <= input.length-k){
            val str = input.substring(start, start+k)
            if(hashset.contains(str)){
                output.add(str)
                hashset.remove(str)
            }else{
                hashset.add(str)
            }
            start++
        }
        return output
    }

}

fun main(){
    val result = RepeatedDnaSequence.naiveApproach("GAGTCACAGTAGTTTCA",3)
    println(result.joinToString(","))

}