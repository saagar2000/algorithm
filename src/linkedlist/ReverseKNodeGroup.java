package linkedlist;

import java.util.*;

public class ReverseKNodeGroup {

  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    Node node1 = new Node(1);
    linkedList.append(node1);
    Node node2 = new Node(2);
    linkedList.append(node2);
    Node node3 = new Node(3);
    linkedList.append(node3);
    Node node4 = new Node(4);
    linkedList.append(node4);
    /*Node node5 = new Node(5);
    linkedList.append(node5);
    Node node6 = new Node(6);
    linkedList.append(node6);
    Node node7 = new Node(7);
    linkedList.append(node7);*/
    Node head = linkedList.head;
    reverseKNodeGroup(head, 2);
  }

  private static Node reverseKNodeGroup(Node head, int k) {
    Node result = new Node();
    result.next = head;

    Node current = head;// Running pointer
    Node newHead = null; // (head)1->2-2->1(tail)-->3->4-4->3
    Node curTail = head;
    Node prevTail = null;

    while (current != null) {

      Node start = current;

      int i = 0;
      while(i < k && current != null) {
        current = current.next;
        i++;
      }


      if(i != k) {
          prevTail.next = curTail;
        break;
      }

      while(start != null && current != start) {//start 1->2->3, 2->3, 3
        Node next = start.next;//2->3, 3, null
        start.next = newHead;//start 1->null, 2->1->null, 3->2->1->null
        newHead = start;//newHead 1->null, 2->1->null, 3->2->(curtail)1->null
        start = next;//start 2->3, 3, null
      }

      //3->2->(prevtail)1->null
      //6->5->4(curtail)
      if(prevTail == null) {
        prevTail = curTail;
        curTail = start;
        result.next = newHead;
        newHead = null;
        continue;
      }

      prevTail.next = newHead;
      prevTail = curTail;
      curTail = start;
      newHead = null;

    }

    return result.next;
  }

}
