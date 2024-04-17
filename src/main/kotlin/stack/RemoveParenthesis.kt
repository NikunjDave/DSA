package stack

import java.lang.StringBuilder
import java.util.Stack

class RemoveParenthesis {

    fun minRemoveParenthesis(input: String?): String{
        if(input.isNullOrEmpty()) return ""
        val stack =Stack<Pair<Char,Int>>()
        val charArray = input.toCharArray()
        for (i in charArray.indices){
            val value = charArray[i]
            if(stack.isNotEmpty() && stack.peek().first == '(' && value == ')'){
                stack.pop()
            } else if(value == '(' || value == ')'){
                stack.push(Pair(value,i))
            }
        }

        while (stack.isNotEmpty()){
           charArray[stack.pop().second] = ' '
        }
        val result = StringBuilder()
        charArray.forEach {
            if(it != ' ')
                result.append(it)
        }
       return result.toString()
    }
}