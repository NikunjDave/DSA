package hashmap

import java.lang.Math.abs

/**
 * LC : 1275
 * Find winner of tictactoe game
 *
 */
object TicTacToeWinner {
    fun tictactoe(moves: Array<IntArray>): String {
        val board = Array(3){(Array(3){'.'})}
        // in the input, it is said that a will make move first so based on the order
        // we will mark board, for A will mark 'x' and  for B mark '0'
        val n = moves.size
        for (i in 0 until n){
            if(i % 2 == 0)
                board[moves[i][0]][moves[i][1]] = 'x'
            else
                board[moves[i][0]][moves[i][1]] = '0'
        }
        return checkBoard(board)
    }

    private fun checkBoard(board : Array<Array<Char>>) : String{
        // check all columns
        for(j in 0 until 3) {
            var countA = 0
            var countB = 0
            for(i in 0 until 3){
                if(board[i][j] == 'x')
                    countA++
                else if(board[i][j] == '0')
                      countB++
            }
            if(countA == 3)
                return "A"
            if(countB == 3)
                return "B"
        }

        // check all rows
        for(j in 0 until 3) {
            var countA = 0
            var countB = 0
            for(i in 0 until 3){
                if(board[j][i] == 'x')
                    countA++
                else if(board[j][i] == '0')
                    countB++
            }
            if(countA == 3)
                return "A"
            if(countB == 3)
                return "B"
        }
        // check diagonal
        if(board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x')
            return "A"
        if(board[0][0] == '0' && board[1][1] == '0' && board[2][2] == '0')
            return "B"

        // check anti diagonal
        if(board[2][0] == 'x' && board[1][1] == 'x' && board[0][2] == 'x')
            return "A"
        if(board[2][0] == '0' && board[1][1] == '0' && board[0][2] == '0')
            return "B"

        var c = 0
        for (i in 0 until 3){
            for(j in 0 until 3) {
                if(board[i][j] == 'x' || board[i][j] == '0' )
                    c++
            }
        }
        if(c != 9)
            return "Pending"
        return "Draw"
    }

    // other approach
    fun tictactoe2(moves: Array<IntArray>): String {
        val n = 3

        val rows = IntArray(n)
        val cols = IntArray(n)
        var diagonal = 0
        var antidiagonal = 0
        var player = 1

        for(move in moves) {
            val row = move[0]
            val col = move[1]

            rows[row] += player
            cols[col] += player

            if(row == col) diagonal+= player

            if(row + col == n - 1) antidiagonal += player

            if(abs(rows[row]) == n || abs(cols[col]) == n || abs(diagonal) == n || abs(antidiagonal) == n) return if(player == 1) "A" else "B"

            player *= -1
        }

        return if(moves.size == n * n) "Draw" else "Pending"
    }

}

fun main(){
    val moveArray = arrayOf(intArrayOf(0, 0), intArrayOf(2, 0), intArrayOf(1, 1), intArrayOf(2, 1), intArrayOf(2, 2))
    val result = TicTacToeWinner.tictactoe(moveArray)
    println(result)
}