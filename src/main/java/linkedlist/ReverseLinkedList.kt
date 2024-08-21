package linkedlist

import data.LinkedListNode
import java.util.Stack

class ReverseLinkedList {

    fun reverseUsingStack(head : Node?) : Node?{
        var temp  = head
        val stack = Stack<Node>()
        while(temp != null){
            stack.push(temp)
            temp = temp.next
        }
        // pop from the stack and update linked list
        val newHead = stack.pop()
        var reverseCurrent = newHead

        while(stack.isNotEmpty()){
            val nextNode = stack.pop()
            reverseCurrent.next = nextNode
            reverseCurrent = nextNode
        }
        //set last node is null
        reverseCurrent.next  = null
        return newHead
    }

    fun reverseUsingInPlaceMethod(head: Node?) : Node?{
        var current = head;
        var prev: Node? = null
        while(current != null){
            val next = current.next
            current.next = prev // current node will be using as inplace, initially it will null
            prev = current // preve will point to current
            current = next

        }
        return prev
    }



    companion object {
        fun buildLinkedList(): Node{
            // create a simple list with 1,3,4,5
            val head  = Node(1)
            head.next = Node(3)
            head.next?.next = Node(4)
            head.next?.next?.next = Node(5)
            return head
        }
        fun buildLinkedList(input : IntArray) : Node?{
            var head : Node? = null
            for (i in input.size-1 downTo 0){
                // create a node
                val node = Node(input[i])
                // insert node at head
                if(head == null){
                    head = node
                }else{
                    node.next = head
                    head = node
                }
            }
            return head;
        }

        fun printList(head : Node?){
            var current = head
            println("linked list is :")
            while (current != null){
                print(current.data)
                print(" ,")
                current  = current.next
            }
        }
    }
}

class LinkedListUtils{

    fun appendData(){

    }



}