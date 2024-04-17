import binarysearch.BinarySearch
import binarysearch.BinarySearchRotated
import binarysearch.RandomPickWithWeight
import data.MyLinkedList
import fastsndslowpointer.*
import linkedlist.*
import twopointer.RemoveNthNode
import twopointer.SortColor

fun main(args: Array<String>) {
    // validate method here

    val head = ReverseNodeInKGroup().reverseInKGroup(Node.buildLinkedList(intArrayOf(1,2,3,4,5,6,7,8,9,10)),3)
    Node.printList(head)

    /*val myLinkedList = MyLinkedList<Int>()
    myLinkedList.createLinkedList(intArrayOf(1,3,4).toTypedArray())
    println("Linked list is")
    myLinkedList.printList(myLinkedList.head)
    println()
    val node = LinkedListReverse().reverseLinkedList(myLinkedList.head)
    println("after reverse")
    myLinkedList.printList(node)
    println()
    //println("is cycle exist "+LinkedListCycle().checkCycleInLinkedList())
    println("16 is happy number "+HappyNumber().isHappyNumber(16))
    val mLinkedList = twopointer.LinkedList()
    mLinkedList.appendData(69)
    mLinkedList.appendData(8)
    mLinkedList.appendData(49)
    mLinkedList.appendData(106)
    mLinkedList.appendData(116)
    mLinkedList.appendData(112)

    val sortColors = SortColor().sortColors(intArrayOf(2,1,1,0,0))
    println("sorted colors are : "+sortColors.joinToString(","))*/
}