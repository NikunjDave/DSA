import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class Temp {


    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        LinkedList<Integer> testList = new LinkedList<>();
        int[] array = new int[]{1,3,4,5};
        testList.createLinkedList(array);
        // first init both pointer
        LinkedListNode left = head;
        LinkedListNode right = head;
        //move right towrads n mode
        for (int i = 0; i< n; i++){
            right = right.next;
        }

        // now move both node forwards until right reach to end

        while(right.next != null){
            right = right.next;
            left = left.next;
        }
        // the left next is nth node from the end, which is to be removed
        //left.next = left.next.next;
        LinkedListNode nodeTobeRemoved = left.next;
        left.next = nodeTobeRemoved.next;


        // Replace this placeholder return statement with your code

        return nodeTobeRemoved;
    }
}
class LinkedList<T> {
    public LinkedListNode head;
    // constructor will be used to make a LinkedList type object
    public LinkedList() {
        this.head = null;
    }
    // insertNodeAtHead method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(int[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(lst[i]);
            insertNodeAtHead(newNode);
        }
    }


}

class LinkedListNode {
    public int data;
    public LinkedListNode next;
    // Constructor will be used to make a LinkedListNode type object
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
