package binarysearch

/**
 * The latest version of a software product fails the quality check. Since each version is developed upon the previous one,
 * all the versions created after a bad version are also considered bad.
 */
class FirstBadVersion {
    fun firstBadVersion(n: Int) : Pair<Int,Int>{
        var numOfCalls = 0
        var first = 1
        var end = n
        while(first < end) {
            val middle = first + (end - first)/2
            if(isBadVersion(middle))
                end = middle
            else
                first = middle + 1
            numOfCalls ++
        }
        return Pair(first,numOfCalls)
    }

    private fun isBadVersion(version : Int) = version >= 4

    fun badVersionTest(){
        val result = firstBadVersion(7)
        println("first bad version is :"+result.toString())
    }
}