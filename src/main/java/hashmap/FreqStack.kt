package hashmap

import java.util.Stack

/**
 * LC : 805
 */
class FreqStack() {
    // store num and its frquency

    val frequency = hashMapOf<Int,Int>()
    val group = hashMapOf<Int,Stack<Int>>()
    var maxFreq = 0
    fun push(num: Int) {
        frequency[num] = frequency.getOrDefault(num,0) + 1
        val count = frequency[num]!!
        if(count > maxFreq)
            maxFreq = count
        group.getOrPut(count){Stack()}.push(num)
    }
    fun pop(): Int {
        if(maxFreq > 0) {
            val show = group[maxFreq]?.pop()!!
            // reduce frequency
            frequency[show] = frequency[show]!! - 1
            if (group[maxFreq]?.size == 0)
                maxFreq--
            return show
        }
        return -1
    }
}

fun main(){
    val freqStack = FreqStack()
    freqStack.push(5)
    freqStack.push(5)
    freqStack.push(4)
    freqStack.push(6)
    freqStack.push(1)
    repeat(5){
        val element = freqStack.pop()
        println(element)
    }
}