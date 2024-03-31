package linkedlist;

public class ReverseLinkedList {
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
    }

    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while(current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
