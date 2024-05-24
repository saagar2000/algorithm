package linkedlist;

public class DoubleLinkedList {
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(7);
        linkedList.append(node1);
        Node node2 = new Node(6);
        linkedList.append(node2);
        Node node3 = new Node(7);
        linkedList.append(node3);
        doubleIt(linkedList.head);

    }


private static Node doubleIt(Node head) {
        Node current = head;
        StringBuilder number = new StringBuilder();
        while(current != null) {
            number.append(current.data);
            current = current.next;
        }
        int value = Integer.parseInt(number.toString()) * 2;
        Node previous = null;
        Node newHead = null;
        while(value % 10 > 0) {
            int val = value % 10;
            value = value / 10;
            Node next = new Node(val);
            if(previous != null) {
                next.next = previous;
            }
            previous = next;
            newHead = next;
        }

        return newHead;
}
}
