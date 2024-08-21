package tree.bfs

import java.util.LinkedList

/**
 * LC : 127
 */
object WordLadder {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val wordSet = wordList.toMutableSet()
        var counter = 0
        if (!wordSet.contains(endWord)) {
            return 0
        }
        val queue = LinkedList<String>()
        queue.add(beginWord)
        while (queue.isNotEmpty()) {
            counter++
            // pop word from queue
            val size = queue.size
            for (i in 0 until size) {
                val currWord = queue.pop()
                for (j in currWord.indices) {
                    val alpha = "abcdefghijklmnopqrstuvwxyz"
                    for (k in alpha.indices) {
                        val temp = currWord.toCharArray()
                        temp[j] = alpha[k]
                        val newWord = String(temp)
                        if (newWord == endWord) {
                            return counter + 1
                        }
                        if (wordSet.contains(newWord)) {
                            // add new word to queue
                            queue.add(newWord)
                            // remove it from set
                            wordSet.remove(newWord)
                        }
                    }
                }
            }
        }
        return 0
    }
}

fun main(){
    val count = WordLadder.ladderLength("hit", "cog", listOf("dot", "hot", "dog", "lot", "log"))
    println("count is $count")
}