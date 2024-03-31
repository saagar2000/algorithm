package linkedlist;

public class LinkedList {
  public Node head;

  public void append(Node node) {
    if (head == null) {
      this.head = node;
      return;
    }
    Node current = head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = node;
  }

  public void prepend(Node node) {
    if (head == null) {
      this.head = node;
      return;
    }
    node.next = head;
    head = node;
  }

  public void delete(Node node) {
      if(head == null) {
          return;
      }
      if(head == node) {
          head = node.next;
          return;
      }
      Node current = head;
      while(current.next != null) {
          if(current.next == node) {
              current.next = node.next;
              return;
          }
          current = current.next;
      }
  }
}
