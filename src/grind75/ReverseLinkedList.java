package grind75;

import linkedlist.*;

public class ReverseLinkedList {
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.append(new Node(3));
        linkedList.append(new Node(2));
        linkedList.append(new Node(4));
        System.out.println(reverseLinkedList(linkedList.head));
    }

    private static Node reverseLinkedList(Node head) {
        Node current = head;
        Node dummy = new Node();
        while(current != null) {
            Node next = current.next;
            current.next = dummy.next;
            dummy.next = current;
            current = next;
        }
        return dummy.next;
    }
}
