package array01

import java.util.*

object RotateArray {

    fun rotateArray(originalArray: IntArray,rotateCount : Int): IntArray{
        var input = originalArray
        var position = 0
        val last = originalArray.size-1
        while (position < rotateCount){
            val array2 = IntArray(originalArray.size){0}
             array2[0] = input[last]
             System.arraycopy(input,0,array2,1,last) //
            // argument order :(sourceArray,startPosOfSource,destArray,startPosOfDest,numOfElementTobeCopied)
            input = array2
            position++
        }
        return input
    }

    fun rotate2(nums: IntArray, k: Int): IntArray {
        if (k % nums.size == 0) {
            return IntArray(0)
        }
        val kMod = k % nums.size
        var temp: Int = nums[0]
        var startIdx = 0
        var currentN = 0
        var totalSwaps = 0
        while (totalSwaps < nums.size) {
            val numberToSwap = temp
            val newIdx = (currentN + kMod) % nums.size
            temp = nums[newIdx]
            nums[newIdx] = numberToSwap
            totalSwaps++
            if (newIdx == startIdx) {
                startIdx++
                currentN = startIdx
                temp = nums[currentN]
            } else {
                currentN = newIdx
            }
        }
        return nums
    }

        fun rotate3(nums: IntArray, k: Int): Unit {
            for(i in 0 until k) {
                var last = nums[nums.size - 1]
                for(j in (nums.size - 1) downTo 1 step 1) {
                    nums[j] = nums[j - 1]
                }
                nums[0] = last
            }
        }
    fun rotate(nums: IntArray, k: Int): Unit {
        nums.reverse()
        nums.reverse(0, k%nums.size)
        nums.reverse(k%nums.size, nums.size)
    }


    fun rotateArray(source: IntArray) : IntArray{
        val size  =source.size
        val k = 2
        val tempArray = IntArray(source.size){0}
        println(source.joinToString ( ))

        // copy last 2 element
        System.arraycopy(source,size-2,tempArray,0,k)
        System.arraycopy(source,0,tempArray,k,size-k)
        //println(source.joinToString ( ))
        return tempArray
    }

}