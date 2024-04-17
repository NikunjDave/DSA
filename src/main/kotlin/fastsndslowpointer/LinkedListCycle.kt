package fastsndslowpointer

import data.LinkedListNode
import data.MyLinkedList


/**
 * The cycle means that at least one node
 * can be reached again by traversing the next pointer.
 *
 */
class LinkedListCycle {
    private fun detectCycle(head : LinkedListNode?) : Boolean{
        var slowPointer = head
        var fastPointer = head
        while (fastPointer?.next != null){
           slowPointer = slowPointer?.next
           fastPointer = fastPointer.next?.next
           if(slowPointer?.data == fastPointer?.data)
               return true
        }
        return false
    }



    fun checkCycleInLinkedList(){
        val input = arrayOf(
            intArrayOf(2, 4, 6, 8, 10, 12),
            intArrayOf(1, 3, 5, 7, 9, 11),
            intArrayOf(0, 1, 2, 3, 4, 6),
            intArrayOf(3, 4, 7, 9, 11, 17),
            intArrayOf(5, 1, 4, 9, 2, 3)
        )
        val pos = intArrayOf(0, -1, 1, -1, 2)
        for (i in input.indices) {
            val list: MyLinkedList<Int> = MyLinkedList()
            list.createLinkedList(input[i].toTypedArray())
            print((i + 1).toString() + ".\tInput:")
            print("\t")
            if (pos[i] == -1) {
                printListWithForwardArrow(list.head)
            } else {
                printListWithForwardArrowLoop(list.head)
            }
            println("\n\tpos: " + pos[i])
            if (pos[i] != -1) {
                val length: Int = list.getLengthOfLinkedList(list.head)
                val lastNode: LinkedListNode? = list.getNodeAtPos(list.head, length - 1)
                lastNode?.next = list.getNodeAtPos(list.head, pos[i])
            }
            println("\n\tDetected Cycle =  " + detectCycle(list.head))
            repeat(100){print("-")}
            println()
        }
    }

    fun printListWithForwardArrow(head: LinkedListNode?) {
        var temp = head
        while (temp != null) {
            print(temp.data) // print node value
            temp = temp.next
            if (temp != null) {
                print(" → ")
            } else {
                // if this is the last node, print null at the end
                print(" → null \n ")
            }
        }
    }

    fun printListWithForwardArrowLoop(head: LinkedListNode?) {
        var temp = head
        while (temp != null) {
            print(temp.data) // print node value
            temp = temp.next
            if (temp != null) {
                print(" → ")
            }
        }
    }

}