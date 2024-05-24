package linkedlist;

public class RemoveNodesFromLinkedList {
  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    Node node1 = new Node(5);
    linkedList.append(node1);
    Node node2 = new Node(2);
    linkedList.append(node2);
    Node node3 = new Node(13);
    linkedList.append(node3);
    Node node4 = new Node(3);
    linkedList.append(node4);
    Node node5 = new Node(8);
    linkedList.append(node5);
    removeNodes(linkedList.head);
  }

  private static Node removeNodes(Node head) {
    Node dummy = new Node();
    dummy.next = head;

    Node previous = null;
    while (head != null) {
      Node next = head.next;
      Node updated = removeNode(head, previous);
      previous = updated;
      if(updated == null) {
          dummy.next = next;
      }
      head = next;
    }
    return dummy.next;
  }

  private static Node removeNode(Node remove, Node previous) {
    Node head = remove;
    while (head.next != null) {
      Node next = head.next;
      int val1 = (int) remove.data;
      int val2 = (int) next.data;
      if (val1 < val2) {
        if (previous != null) {
          previous.next = next;
          remove = previous;
        } else {
          remove.next = null;
          remove = null;
        }
        break;
      } else {
        head = next;
      }
    }
    return remove;
  }
}
