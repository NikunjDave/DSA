package array02

/**
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 * input : 5
 * output :
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 *
 */
object PascalTriangle {
    fun generate(numRows: Int): List<List<Int>> {
        val pascalList = mutableListOf<List<Int>>()
        for (i in 0 until numRows){
            val row = mutableListOf<Int>()
            var col = 0
            while(col <= i){
                if(col == 0 || col == i)
                    row.add(1)
                else if(pascalList.size > 0){
                    val prevRow = pascalList[i-1]
                    val sumOfPrev = prevRow[col-1] + prevRow[col]
                    row.add(sumOfPrev)
                }else {
                    row.add(1)
                }
                col++
            }
            pascalList.add(row)
        }
        return pascalList
    }


    fun generateOptimal(numRows: Int): List<List<Int>> {
        val pascalTriangleList = mutableListOf<List<Int>>()

        for (j in 0 until numRows) {
            var ans = 1L
            val localList = mutableListOf<Int>()

            for (i in 0..j) {
                localList.add(ans.toInt())
                ans = ans * (j - i) / (i + 1)
            }

            pascalTriangleList.add(localList)
        }
        return pascalTriangleList
    }
}

fun main(){
    val pascalList = PascalTriangle.generateOptimal(5)
    pascalList.forEach {
        println(it.joinToString(" "))
    }
}