package array01

/**
 * Given a sorted array [1,1,3,4,4,5] remove duplicate element in array
 * in the same array the return array output : [1,3,4,5,_,_,_]
 */
object RemoveDuplicate {

    fun removeDuplicates(input : IntArray): IntArray{
        var counter = 1
        for (i in 1 until  input.size){
            if(input[i] != input[i-1]){
                input[counter] = input[i]
                counter ++
            }
        }
        return input
    }
}

fun main(){
    val output = RemoveDuplicate.removeDuplicates(intArrayOf(1,1,3,3,4,5))
    println(output.joinToString(" "))

}