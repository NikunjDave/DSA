package matrices

/**
 * Given m*n matrices traverse the matrices in spiral form and provide single array
 *  * e.g [1,2,3]
 *  *     [4,5,6]    output  [1,2,3,6,9,8,7,4,5]
 *  *     [7,8,9]
 */
class SpiralMatrices {

    fun spiralElement(matrix : Array<IntArray>) : ArrayList<Int>{
        val output = ArrayList<Int>()
        var direction  = 1 // for left to right and top to bottom  == 1 and for right to bottom and bottom to top = -1

        var rows = matrix.size
        var columns = matrix[0].size
        var row = 0
        var col = -1

        while (rows  > 0 && columns > 0){
            for (i in 0..<columns){
                col += direction
                output.add(matrix[row][col])
            }
            rows --
            for (i in 0..<rows){
                row += direction
                output.add(matrix[row][col])
            }
            columns --
            direction *= -1

        }
        return output
    }



    private fun spiralPrint(arr: Array<IntArray>) : List<Int> {

        val list = mutableListOf<Int>()

        val row = arr.size
        val col = arr[0].size

        var count = 0
        val total = row * col

        // index
        var startingRow = 0
        var startingCol = 0
        var endingRow = row - 1
        var endingCol = col - 1

        var index = 0

        while (count < total) {

            // print starting row
            index = startingCol
            while (count < total && index <= endingCol) {
                list.add(arr[startingRow][index])
                count++
                index++
            }
            startingRow++

            // print ending column
            index = startingRow
            while (count < total && index <= endingRow) {
                list.add(arr[index][endingCol])
                count++
                index++
            }
            endingCol--

            // print ending row
            index = endingCol
            while (count < total && index >= startingCol) {
                list.add(arr[endingRow][index])
                count++
                index--
            }
            endingRow--

            // print starting column
            index = endingRow
            while (count < total && index >= startingRow) {
                list.add(arr[index][startingCol])
                count++
                index--
            }
            startingCol++

        }

        return list
    }


    fun spiralElement2(arr: Array<IntArray>) : List<Int> {
        val output = mutableListOf<Int>()
        var maxRow = arr.size
        var maxCol = arr[0].size
        var direction = 1
        var row = 0
        var col = -1

        while (maxRow > 0 || maxCol >0){
           for (i in 0 until maxCol){
                col += direction
                output.add(arr[row][col])
            }
            maxRow --

            for(i in 0 until maxRow){
                row += direction
                output.add(arr[row][col])
            }
            maxCol --
            direction *= -1
        }

        return output
    }

}

fun main(){

}