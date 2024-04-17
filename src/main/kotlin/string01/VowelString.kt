package string01

/**
 * Given two String str1, str2, find the vowel in str1 that present in str2
 * in alphabetic order
 * e.g. str1 = "ahosi",str2 = "ibaswodwa"
 * output = aio
 */
object VowelString {

    fun findVowel(str1 : String, str2: String): String{
        var index = 0
        val listOfChars = mutableListOf<Char>()
        while(index < str1.length){
            if(str1[index].isVowel() && str2.contains(str1[index])){
                listOfChars.add(str1[index])
            }
            index++
        }
       listOfChars.sort()
       return listOfChars.toString()
    }

    private fun Char.isVowel(): Boolean =when(this){
            'a','e','i','o','u'->  true
            else -> false
        }

}