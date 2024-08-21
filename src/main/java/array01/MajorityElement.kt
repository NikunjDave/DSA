package array01

/**
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * Input: nums = [3,2,3]
 * Output: 3
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
object MajorityElement {

    fun findMajorityElement(nums : IntArray) : Int{
        var element = 0
        var count = 0
        for(i in nums.indices){
            if(count == 0){
                count = 1
                element = nums[i]
            }else if(element == nums[i]) count ++
            else count --
        }

        var count2 = 0
        for(i in nums.indices){
            if(nums[i] == element)
                count2++
        }
        if(count2 > nums.size/2)
            return element
        else
            return -1
    }
}