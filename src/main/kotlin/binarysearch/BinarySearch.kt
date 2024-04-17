package binarysearch

class BinarySearch {
    /**
     * Find the [target] in [numbers] array in return the index, if not return -1
     */
    private fun binarySearch(numbers : IntArray, target: Int) : Int{
        var start = 0
        var end =  numbers.size -1
        while(start <= end){
            val middle = (start + end)/2
            if(target == numbers[middle])
                return middle
            else if(target > numbers[middle]){
                start = middle +1 // right subtree
            } else {
                end = middle-1 //left subtree
            }
        }
        return  -1
    }
    fun binarySearchTest(){
        val input = intArrayOf(2,5,7,9,12)
        val number = 12
        val result = binarySearch(input,number)
        println("array is: "+input.joinToString(","))
        println("Index of $number is: $result")
    }

}