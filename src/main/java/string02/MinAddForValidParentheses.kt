package string02

import java.util.*

/**
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 *
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "())"
 * Output: 1
 * Example 2:
 *
 * Input: s = "((("
 * Output: 3
 */
object MinAddForValidParentheses {
    fun minAddToMakeValid(s: String): Int {
        var numOpen = 0
        var numClosed = 0

        val OPEN = '('
        val CLOSED = ')'

        for (ch in s.toCharArray()) {
            when (ch) {
                OPEN -> numOpen++
                CLOSED -> if (numOpen > 0) numOpen-- else numClosed++
            }
        }

        return numOpen + numClosed
    }

    fun usingStack(s: String): Int {
        val stack = Stack<Char>()
        for (element in s) {
            // first look in stack
            if (stack.size > 0 && element == ')' && stack.peek() == '(')
                stack.pop()
            else
                stack.push(element)
        }
        return stack.size
    }
}

//()))((
//()()
fun main() {
    val minAdd = MinAddForValidParentheses.usingStack("(((")
    println("min add require is $minAdd")
}