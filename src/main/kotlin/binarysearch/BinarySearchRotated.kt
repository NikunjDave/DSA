package binarysearch

class BinarySearchRotated {
    private fun binarySearchRotated(numbers : IntArray, target :Int) : Int{
        var start = 0
        var end = numbers.size -1
        while(start <= end){
           val middle  = start + (end - start)/2
           if(target == numbers[middle])
               return middle
           else if(target <= numbers[middle]){
               if(numbers[start] <= target && target < numbers[middle])
                   end = middle -1
               else
                   start = middle + 1
           }else {
               if(numbers[middle] < target && target <= numbers[end])
                  start = middle + 1
               else
                   end = middle -1
           }
        }
        return -1
    }

    /**
     * Recursive approach
     */
    private fun binarySearchRotated(numbers: IntArray, start : Int, end : Int, target: Int) : Int{
        if(start > end) return  -1
        val mid = start + (end - start)/2
        if(numbers[mid] == target) return mid

        if(target < numbers[mid]){
            return if(numbers[start] <= target && numbers[start] < numbers[mid])
                 binarySearchRotated(numbers,start,mid-1,target) //search in 1st half
            else
                 binarySearchRotated(numbers,mid+1,end,target)
        }else {
           return if (numbers[end] >= target && numbers[end] > numbers[mid])
                binarySearchRotated(numbers,mid+1,end, target)
            else
                binarySearchRotated(numbers,start,mid-1, target)
        }
    }

    fun binarySearchRotatedTest(){
        val input = intArrayOf(176,188,199,200,1,2,3)
        val search = 200
        val result = binarySearchRotated(input,0,input.size-1,search)
        println("index of $search is $result")
    }
}