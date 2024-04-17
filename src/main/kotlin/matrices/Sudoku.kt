package matrices

object Sudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rowMap = HashMap<Int, HashSet<Char>>()
        val colMap = HashMap<Int, HashSet<Char>>()
        val squares = HashMap<Pair<Int,Int>, HashSet<Char>>()

        for (row in 0..<9) {
            for (col  in 0..<9){
                val element = board[row][col]
                if (element == '.')
                    continue
                // Initialize sets if they don't exist
                rowMap.putIfAbsent(row, HashSet())
                colMap.putIfAbsent(col, HashSet())
                squares.putIfAbsent(Pair(row/3, col/3), HashSet())

                if(rowMap[row]?.contains(element) == true ||
                    colMap[col]?.contains(element) == true ||
                    squares[Pair(row/3,col/3)]?.contains(element) == true)
                    return false
                rowMap[row]?.add(element)
                colMap[col]?.add(element)
                squares[Pair(row/3,col/3)]?.add(element)
            }
        }
        // all column has unique element is satisfied

        return true
    }

    fun isValidSudoku2(board: Array<CharArray>): Boolean {
        val seen = HashSet<String>()

        for (i in 0..<9) {
            for (j in 0..<9) {
                val num = board[i][j]
                if (num != '.') {
                    if (!seen.add("$num in row $i") ||
                        !seen.add("$num in column $j") ||
                        !seen.add("$num in subgrid ${i / 3}-${j / 3}")
                    ) {
                        return false
                    }
                }
            }
        }

        return true
    }

    fun validSudoku2(){

    }

    fun buildSudoku(): Array<CharArray>{
        val sudokuInput = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )


        val sudokuArray: Array<CharArray> = arrayOf(
            charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
        return sudokuInput
    }
}