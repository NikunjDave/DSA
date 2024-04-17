package twopointer

// Given an input array like  = [1,2,3,2,4,2] remove the given element and return size
// in above it if value to be removed is 2 then output would be [1,3,4]
class RemoveElement {
    fun removeElement(nums: IntArray, remove: Int) : IntArray{
        /*var k = 0
        var l = nums.size -1
        for (x in nums) {
            if (x != remove) {
                nums[k++] = x
            }
        }*/

        var count = 0
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            if (nums[left] != remove) {
                left++
            } else {
                if (nums[right] == remove) {
                    right--
                } else {
                    val temp = nums[right]
                    nums[right] = nums[left]
                    nums[left] = temp
                    left++
                    right--
                }
                count++
            }
        }
        return nums
    }

}