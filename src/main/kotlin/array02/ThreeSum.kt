package array02

/**
 *
 */
object ThreeSum {
    val nums2 = intArrayOf(-1,0,1,2,-1,-4)
    val result = intArrayOf(-1,0,1)
    val result2 = intArrayOf(-1,2,-1)
    fun threeSum(nums: IntArray): List<List<Int>> {
     val output = mutableListOf<MutableList<Int>>()
        var i = 0
        var j = 1
        var k = 2
        val size = nums.size
        while(i < size -2){
            var total = nums[i]+nums[j]+nums[k]
            if(total == 0)
                output.add(mutableListOf(nums[i],nums[j],nums[k]))
             
            i++
        }






     output.add(mutableListOf(1,2,3))
     return output
    }
}