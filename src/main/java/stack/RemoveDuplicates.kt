package stack

import java.util.Stack

class RemoveDuplicates {
    /**
     * Remove duplicate adjacent char-array/String
     * for e.g. "abbccdd" -> a, abcde -> abcde
     */
    fun removeDuplicates(charArray : CharArray): String{
        val myStack = Stack<Char>()
        myStack.push(charArray[0])
        for (i in 1 until charArray.size){
            if(charArray[i] == myStack.peek()){
                // matching element to be removed
                myStack.pop()
            }else{
                myStack.push(charArray[i])
            }
        }
        return myStack.joinToString("")
    }
}