package matrices

/**
 * Given an input matrix like : [1,1,1],[1,0,1][1,1,1]
 * if any element contain a 0, then row and column should be zero
 * output : [1,0,1][0,0,0][1,0,1]
 */
class RowColZero {

    fun turnZeroIfAny(matrix: Array<IntArray>): Array<IntArray> {
        var input = matrix
        val rowLen = input.size - 1
        val columnLen = input[0].size - 1
        for (row in 0..rowLen) {
            for (column in 0..columnLen) {
                if (input[row][column] == 0) {
                    var rowPtr = 0
                    var colPtr = 0
                    // make entire row to 0
                    while (colPtr <= columnLen) {
                        input[row][colPtr] = 0
                        colPtr += 1
                    }
                    // make entire row to 0
                    while (rowPtr <= rowLen) {
                        input[rowPtr][column] = 0
                        rowPtr += 1
                    }
                    return input
                }
            }
        }
        return input
    }


    fun turnZeroIfAny2(matrix: Array<IntArray>): Array<IntArray> {
        var input = matrix

        val rowSize = input.size
        val colSize = input[0].size
        val rowArr = Array(rowSize) { 0 }
        val colArr = Array(colSize) { 0 }

        for (row in 0 until rowSize) {
            for (column in 0 until colSize) {
                if (input[row][column] == 0) {
                    rowArr[row] = 1
                    colArr[column] = 1
                }
            }
        }

        // marking 1 are turn to be 0
        for (row in 0 until rowSize) {
            for (column in 0 until colSize) {
                if (rowArr[row] == 1 || colArr[column] == 1) {
                    input[row][column] = 0
                }
            }
        }

        return input
    }
}