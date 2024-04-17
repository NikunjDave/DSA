package twopointer

/**
 * Given an input sorted array like : [0,1,2,2,3,4,4]
 * output should be  : [0,1,3,4,2,4] , unique element should be first
 */
class RemoveDuplicateFromSortedArray {
    fun removeDuplicate(nums: IntArray) : IntArray{
        var i = 0
        var j = 0
        nums[j] = nums[i]
        while(i < nums.size){
            if(nums[j] != nums[i]){
                j += 1
                nums[j] = nums[i]
            }
            i++
        }
        return nums
    }


    /**
     * now the second problem of similar type is remove some duplicate element
     * but duplicate element can  appear at most twice
     * e.g. input == [1,2,2,3,3,3,4] -> [1,2,2,3,3,4,3]
     */
    fun removeDuplicateTwice(nums: IntArray) : IntArray{
        var next = 0
        for (i in nums.indices){
            if(i == 0 || i == 1)
                nums[next++] = nums[i]
            else if(nums[i] != nums[next -1] || nums[i] != nums[next -2]){
                nums[next++] = nums[i]
            }
        }
        return nums
    }

}