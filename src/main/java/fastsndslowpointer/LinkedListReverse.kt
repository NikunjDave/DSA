package fastsndslowpointer

import data.LinkedListNode




class LinkedListReverse {
    fun reverseLinkedList(node: LinkedListNode?): LinkedListNode? {
        var head: LinkedListNode?
        var prev: LinkedListNode? = null
        var current = node
        var next: LinkedListNode? = null
        while (current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }
        head = prev
        return head
    }
}