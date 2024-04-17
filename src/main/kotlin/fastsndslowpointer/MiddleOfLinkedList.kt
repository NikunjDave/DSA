package fastsndslowpointer

import data.LinkedListNode
import data.MyLinkedList

/**
 * Using slow and fast pointer, middle of linked-list can be easily found,
 * just traverse until fast reach to end and return slow pointer head
 * Note : for even number of node -> it will return center +1 i .e 4/2 = 3
 *
 */
class MiddleOfLinkedList {
    fun middleOfNode(head : LinkedListNode?) : LinkedListNode?{
        var slow = head
        var fast = head
        while(fast?.next != null){
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }
}