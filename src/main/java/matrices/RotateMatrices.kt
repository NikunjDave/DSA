package matrices

/**
 * Given a n*n matrices rotate the element by 90 degree clock wise
 * e.g [1,2,3]             [7,4,1]
 *     [4,5,6]    output   [8,5,2]
 *     [7,8,9]             [9,6,3]
 */
object RotateMatrices {


    fun rotateMatrices(matrix : Array<IntArray>) : Array<IntArray>{
        val n = matrix.size

        for (row in 0 until n / 2) {
            for (col in row until n - row - 1) {
                var temp = matrix[row][col]
                matrix[row][col] = matrix[col][n - 1 - row]
                matrix[col][n - 1 - row] = temp

                temp = matrix[row][col]
                matrix[row][col] = matrix[n - 1 - row][n - 1 - col]
                matrix[n - 1 - row][n - 1 - col] = temp

                temp = matrix[row][col]
                matrix[row][col] = matrix[n - 1 - col][row]
                matrix[n - 1 - col][row] = temp
            }
        }
        return matrix

    }


    fun getMatrices(size : Int): Array<IntArray>{
        var value = 0
        val inputArray = Array<IntArray>(size){ IntArray(size){0} }
        for (i in 0 until size){
            for (j in 0 until size){
                inputArray[i][j] = ++ value
            }
        }
        return inputArray
    }

    fun printMatrices(input: Array<IntArray>){
        val size  =  input.size
        for (i in 0 until size){
            for (j in 0 until size){
                print(" "+input[i][j])
            }
            println()
        }
    }
}