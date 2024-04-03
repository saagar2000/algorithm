package grind75;

import linkedlist.*;
import linkedlist.LinkedList;

import java.util.*;

public class LinkedListCycle {
  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    linkedList.append(new Node(3));
    Node node2 = new Node(2);
    linkedList.append(node2);
    linkedList.append(new Node(0));
    Node node4 = new Node(4);
    node4.next = node2;
    linkedList.append(node4);
    System.out.println(hasCycleFS(linkedList.head));
  }

  private static boolean hasCycle(Node head) {
    Set<Node> visited = new HashSet<>();
    Node current = head;
    while (current.next != null) {
      if (visited.contains(current.next)) return true;
      visited.add(current.next);
      current = current.next;
    }
    return false;
  }

  private static boolean hasCycleFS(Node head) {
    Node fast = head;
    Node slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if(fast == slow) return true;
    }
    return false;
  }
}
