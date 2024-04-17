package data

import java.util.LinkedList

class MyLinkedList<T> {
    var head: LinkedListNode? = null

    // Constructor will be used to make a LinkedList type object
    constructor() {
        this.head = null
    }

    // insertNodeAtHead method will insert a LinkedListNode at the head
// of a linked list.
    fun insertNodeAtHead(node: LinkedListNode) {
        if (this.head == null) {
            this.head = node
        } else {
            node.next = this.head
            this.head = node
        }
    }

    // createLinkedList method will create the linked list using the
// given array with the help of the insertNodeAtHead method.
    fun createLinkedList(lst: Array<Int>) {
        for (i in lst.indices.reversed()) {
            val newNode = LinkedListNode(lst[i])
            insertNodeAtHead(newNode)
        }
    }

    fun getNodeAtPos(head : LinkedListNode?, position : Int) : LinkedListNode?{
        if(head != null && position != -1) {
            var pointer = head
            var counter = 0
            while (counter < position) {
                pointer = pointer?.next
                counter++
            }
            return  pointer
        }
        return null
    }

    fun getLengthOfLinkedList(head: LinkedListNode?) : Int{
        if(head == null) return  -1
        var pointer = head
        var count = 0
        while(pointer?.next != null){
            pointer = pointer.next
            count++
        }
        return count
    }
    fun printList(_head : LinkedListNode?){
        var pointer = _head
        while(pointer!= null){
            print(pointer.data)
            pointer = pointer.next
        }
    }
}

class LinkedListNode(var data: Int) {
    var next: LinkedListNode?  = null

    // Constructor will be used to make a LinkedListNode type object
    constructor(data: Int, next: LinkedListNode? = null) : this(data) {
        this.next = next
    }
}