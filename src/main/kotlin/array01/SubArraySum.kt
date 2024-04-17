package array01

/**
 * Find sub-array from given array whose sum equals to given number
 * for e.g. : input :  [1,2,3,1,1,4] and target = 6
 *  output : [1,2,3], [1,1,4]
 *  [4,2,3,3] -> [4,2][3,3]
 */
object SubArraySum {

    fun findSubArrayOfGivenSum(numbers: IntArray,target: Int) : List<Pair<Int,Int>>{
       val result = mutableListOf<Pair<Int,Int>>()
       for (i in numbers.indices){
           var currentSum = 0
           for(j in i..<numbers.size){
               currentSum  += numbers[j]
               if(currentSum == target){
                   result.add(i to j)
                   break
               }
           }
       }
        return result
    }

    fun findSubArrayOfGivenSumEffective(numbers: IntArray,target: Int) : List<Pair<Int,Int>>{
        val result = mutableListOf<Pair<Int,Int>>()
        var start  = 0
        var end = 0
        var currentSum = 0
        while(end < numbers.size){
            currentSum += numbers[end]
            while(currentSum > target && start < end){
                currentSum -= numbers[start]
                start ++
            }
            if(currentSum == target){
                result.add(start to end)
            }
            end ++
        }

        return result
    }



}