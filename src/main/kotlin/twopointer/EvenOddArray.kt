package twopointer

/**
 * Given an array [13,10,21,20]
 * move event to start and odd to the end of the array
 */
object EvenOddArray {

    fun separateEvenOdd(nums : IntArray): IntArray{
        var start = 0
        var end = nums.size -1
        while (start < end){
            if(nums[start] % 2 == 0)
                start ++
            else{
                if(nums[end]%2 == 0){
                    // swap
                    val temp = nums[start]
                    nums[start] = nums[end]
                    nums[end] = temp
                    start ++
                }
                end--
            }

        }

        return nums
    }

}