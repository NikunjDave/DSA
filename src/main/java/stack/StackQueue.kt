package stack

import java.util.Stack

/**
 * Implement Queue using stack
 */
class StackQueue {
    private val primary =  Stack<Int>()
    // secondary stack will be used as popping element from stack primary
    private val secondary =  Stack<Int>()
    fun push(element : Int) {
        if(primary.isEmpty()){
            primary.push(element)
        }else {
            while(primary.isNotEmpty()) {
                secondary.push(primary.pop())
            }
            primary.push(element)
            while(secondary.isNotEmpty()) {
                primary.push(secondary.pop())
            }
        }
    }

    fun pop(): Int{
        return primary.pop()
    }

    fun peek():Int {
        return primary.peek()
    }

    fun isEmpty(): Boolean {
        return primary.isEmpty()
    }
}