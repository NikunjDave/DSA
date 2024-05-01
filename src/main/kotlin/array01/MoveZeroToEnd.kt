package array01

/**
 * Given an array like "1,0,4,5,2,0" move all 0 to end and output should
 * be like : 0,0,1,4,5,2
 */
object MoveZeroToEnd {
    fun moveZeroes(nums: IntArray): IntArray {
        var index = 0
        for(i in nums.indices){
            if(nums[i] != 0){
                nums[index] = nums[i]
                index ++
            }
        }
        while(index < nums.size){
            nums[index] = 0
            index ++
        }
       return nums
    }
}

fun main(){
    val output = MoveZeroToEnd.moveZeroes(intArrayOf(0,1,4,0,1,))
    println(output.joinToString(" "))

}