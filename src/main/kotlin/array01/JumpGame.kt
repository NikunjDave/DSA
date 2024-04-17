package array01

/**
 * You are given an integer array nums.
 * You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 * Input: numbers = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 */
object JumpGame {

    fun canReachLast(nums: IntArray): Boolean{
        val n = nums.size

        if (n == 1) return true

        var max = 0

        for (index in 0..<n - 1) {
            if (max < index + nums[index]) {
                max = index + nums[index]
            }

            if (max >= n - 1) {
                return true
            }
        }

        return false

    }
    fun canReachLast2(numbers: IntArray): Boolean{
        var finish = numbers.size -1
        for (i in finish -2 downTo 0 ){
            if((numbers[i] + i) >= finish)
                finish = i
        }
        return finish == 0
    }


}