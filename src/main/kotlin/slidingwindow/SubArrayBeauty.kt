package slidingwindow

/**
 * Leetcode : 2653
 *Given an integer array nums containing n integers, find the beauty of each subarray of size k.
 * The beauty of a subarray is the xth smallest integer in the subarray if it is negative,
 * or 0 if there are fewer than x negative integers.
 *
 * Input: nums = [1,-1,-3,-2,3], k = 3, x = 2
 * Output: [-1,-2,-2]
 *
 */
object SubArrayBeauty {
    fun getSubarrayBeauty(nums: IntArray, k: Int, x: Int): IntArray {
        val n = nums.size
        // count array to store frequency
        val count = IntArray(101)
        // add first k element frequency to count
        for(i in 0 until k){
            count[nums[i]+50]++
        }
        val beauty = IntArray(n-k+1)
        beauty[0] = getBeautyNumber(count,x)
        var index = 1
        for(i in k until n){
            // include the next element in count
            count[nums[i]+50]++
            // exclude the last element
            count[nums[i-k]+50]--
            // calculate the beauty
            beauty[index++] = getBeautyNumber(count,x)
        }
        return beauty
    }
    fun getBeautyNumber(count : IntArray,x :Int) : Int{
        var sum = 0
        // we are only looking for negative number, hence run loop till 50
        for (i in 0 until 50) {
            sum += count[i]
            if (sum >= x)
                return i - 50
        }
         return 0
        }
    }
fun main(){
     val result = SubArrayBeauty.getSubarrayBeauty(intArrayOf(1,-1,-3,-2,3),3,2)
     println(result.joinToString(","))
}