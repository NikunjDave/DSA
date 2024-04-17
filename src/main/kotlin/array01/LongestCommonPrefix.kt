package array01
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
object LongestCommonPrefix {

    fun findCommonPrefix(stringArray: Array<String>): String{
        var prefix = ""
        var charIndex = 1
        while (charIndex < stringArray[0].length){
            prefix = stringArray[0].substring(0,charIndex)
            for (i in 1..<stringArray.size){
                if(stringArray[i].length > charIndex && stringArray[i].substring(0,charIndex) == prefix)
                    continue
                else
                    return prefix.substring(0,prefix.length-1)
            }
            charIndex++
        }
        return prefix
    }

    fun findCommonPrefix2(stringArray: Array<String>): String{
        var prefix = ""
        var charIndex = 0
        if(stringArray.size ==1 )return stringArray[0]
        while (charIndex < stringArray[0].length){
            prefix = stringArray[0].substring(0,charIndex+1)
            for (i in 1..<stringArray.size){
                if(stringArray[i].startsWith(prefix))
                    continue
                else
                    return prefix.substring(0,prefix.length-1)
            }
            charIndex++
        }
        return prefix
    }
}