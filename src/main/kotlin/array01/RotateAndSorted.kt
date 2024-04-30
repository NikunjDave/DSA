package array01

/**
 * Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
 *
 * There may be duplicates in the original array.
 *
 * Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.
 *
 *  Example 1:
 *
 * Input: nums = [3,4,5,1,2]
 * Output: true
 * Explanation: [1,2,3,4,5] is the original sorted array.
 * You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
 * Example 2:
 *
 * Input: nums = [2,1,3,4]
 * Output: false
 * Explanation: There is no sorted array once rotated that can make nums.
 * Example 3:
 *
 * Input: nums = [1,2,3]
 * Output: true
 * Explanation: [1,2,3] is the original sorted array.
 * You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 */
object RotateAndSorted {
    fun isRotatedAndSorted(nums: IntArray) : Boolean{
        // find how many times rotated
        val size = nums.size
        var first = 0
        var second = size -1
        var count = 0
        while(second > 0){
            if(nums[first] >= nums[second]){
                count++
                first = second
                second--
            }
            else
                break
        }
        for(i in 1 until nums.size - count){
            if(nums[i-1] > nums[i])
                return false
        }
        return true
    }
}
fun main(){
    val element = RotateAndSorted.isRotatedAndSorted(intArrayOf(3,4,5,1,2))
    println("is rotated or sorted $element")
}