package hashmap

/**
 * LC: 205
 */
object Isomorphic {
    fun isIsomorphic(s: String, t: String): Boolean {
        val charMap  = HashMap<Char,Char>()
        if(s.length != t.length)
            return false
        for(i in s.indices){
            if(charMap.containsKey(s[i])){
                if(charMap.get(s[i]) != t[i])
                    return false
            }else if(!charMap.containsValue(t[i])){
                charMap[s[i]] = t[i]
            }else{
                return false
            }
        }
        return true
    }
}
fun main(){
    val result = Isomorphic.isIsomorphic("paper","title")
    println(result)
}