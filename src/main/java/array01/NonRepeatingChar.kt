package array01

/**
 * Find the first non-repeating char in string
 * e.g: "sara" -> s
 * eg. -> sasast -> t
 * eg -> "asdasd" ->
 */
class NonRepeatingChar {
    // using hashmap approach
    fun findNonRepeatingOne(input : String): Int{
        val mapCounter : HashMap<Char,Int> = hashMapOf()
        val inputArray = input.toCharArray()
        for (character in inputArray){
           // put the counter value in map
            mapCounter[character] = mapCounter.getOrDefault(character,0)+1
        }
        for(i in inputArray.indices){
            if(mapCounter[inputArray[i]] == 1)
                return i
        }
        return -1
    }

    fun firstUniqueCharSecond(input: String): Int{
        val count = IntArray(26)
        for (char in input.toCharArray()){
             count[char - 'a'] ++
        }

        for (i in input.toCharArray().indices){
           if(count[input.toCharArray()[i] - 'a'] == 1)
               return i
        }
        return -1
    }


}