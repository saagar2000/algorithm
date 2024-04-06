package grind75;

import linkedlist.*;
import linkedlist.LinkedList;

import java.util.*;

public class MiddleOfTheLinkedList {
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        Node node0 = new Node(0);
        linkedList.append(node0);
        Node node1 = new Node(1);
        linkedList.append(node1);
        Node node2 = new Node(2);
        linkedList.append(node2);
        Node node3 = new Node(3);
        linkedList.append(node3);
        Node head = linkedList.head;
        System.out.println(middle(head).data);
    }

    private static Node middle(Node head) {
        Node current = head;
        int count = 0;
        List<Node> nodes = new ArrayList<>();
        while(current != null) {
            nodes.add(current);
            count++;
            current = current.next;
        }
        int index = count / 2;
        return nodes.get(index);
    }

    private static Node middleFS(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
