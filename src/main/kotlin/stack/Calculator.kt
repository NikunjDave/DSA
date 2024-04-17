package stack

import java.util.*

class Calculator {

    fun calculateExpression(input : String?) : Int{
        if(input.isNullOrEmpty()) return  -1
        val charArray = input.toCharArray()
        val stack = Stack<Int>()
        var result = 0
        var sign : Int = 1
        var number: Int = 0

        for (i in charArray.indices){
            if(charArray[i].isDigit()){
                number = number*10 + charArray[i].digitToInt() //
            } else if(charArray[i] == '+' || charArray[i] == '-'){
                result = result + (number * sign)
                sign = if(charArray[i] == '+') 1 else -1
                number = 0
            }else if(charArray[i] == '('){
                stack.push(result)
                stack.push(sign)
                result = 0
                number = 0
            }else if(charArray[i] == ')'){
                // step calculate () result
                result = result + (number * sign)
                // and also pop value from stack
                sign = stack.pop()
                result = result *sign
                val secondValue = stack.pop()
                result = result + secondValue
                number = 0
            }
        }
        result = number + result
        return  result
    }
}