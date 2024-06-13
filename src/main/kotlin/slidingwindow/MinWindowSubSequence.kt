package slidingwindow

/**
 * Statement
 * Given two strings, str1 and str2,
 * find the shortest substring in str1 such that str2 is a subsequence of that substring.
 * Let’s say you have the following two strings:
 * str1 = “abbcb”
 * str2 = “ac”
 * In this example, “abbc” is a substring of str1, from which we can derive str2 simply by deleting both
 * the instances of the character 𝑏
 */
object MinWindowSubSequence {
      fun minSequence(str1 : String, str2 : String) :String{
          // track substring index to returned
          var start = 0
          var end = 0
          var minSubLen = Int.MAX_VALUE
          var minSubSequence = ""
          // pointer for str1
          var indexS1 = 0
          // pointer for str2
          var indexS2= 0
          while (indexS1 < str1.length){
              if(str1[indexS1] == str2[indexS2]){
                  // if this is first char of str2, mark it as start of substring
                  if(indexS2 == 0)
                      start = indexS1
                  indexS2++
                   // when str2 fully traversed, update start and end
                  if(indexS2 == str2.length){
                      end = indexS1
                      // check current subsequence
                      if((end-start +1) < minSubLen ){
                          minSubLen = end - start +1
                          minSubSequence = str1.substring(start,end+1)
                      }

                     indexS1 = end + 1
                     indexS2  = 0
                     continue
                  }
              }
              indexS1++
          }
          return minSubSequence
      }

    fun minWindow(str1: String, str2: String): String {
        val sizeStr1 = str1.length
        val sizeStr2 = str2.length
        var length = Float.POSITIVE_INFINITY
        var indexS1 = 0
        var indexS2 = 0
        var start = 0
        var end = 0
        var minSubsequence = ""

        while (indexS1 < sizeStr1) {
            if (str1[indexS1] == str2[indexS2]) {
                indexS2 += 1
                if (indexS2 == sizeStr2) {
                    start = indexS1
                    end = indexS1
                    indexS2 -= 1
                    while (indexS2 >= 0) {
                        if (str1[start] == str2[indexS2]) {
                            indexS2 -= 1
                        }
                        start -= 1
                    }
                    start += 1
                    if ((end - start + 1) < length) {
                        length = (end - start + 1).toFloat()
                        minSubsequence = str1.substring(start, end + 1)
                    }
                    indexS1 = start
                    indexS2 = 0
                }
            }
            indexS1 += 1
        }
        return minSubsequence
    }
}

fun main(){
    val result = MinWindowSubSequence.minSequence("abbcadc","ac")
    println("output is $result")

}

