package twopointer

class TwoSum {

    // this works for sorted array
    fun twoSum(nums: IntArray, target: Int): IntArray? {
        if(nums.isEmpty())
            return null
        if(nums.size == 1)
            return nums

        var left = 0
        var right = nums.size -1

        while(left < right){
            var sum = nums[left] + nums[right]
            if(target == sum){
                break
            }else if(target > sum){
                left ++
            } else {
                right --
            }
        }

        return intArrayOf(left,right)
    }
    fun twoSumInUnsorted(nums: IntArray, target: Int): IntArray? {
        if(nums.isEmpty())
            return null
        if(nums.size == 1)
            return nums
        val output = intArrayOf(0,0)
        val numberMap = HashMap<Int,Int>()
        for (i in nums.indices){
            val result = target - nums[i]
            if(numberMap.containsKey(result)) {
                output[0] = numberMap.get(result)!!
                output[1] = i
            }else{
                numberMap[nums[i]] = i
            }
        }
        return output
    }




}