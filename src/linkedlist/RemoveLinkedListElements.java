package linkedlist;

public class RemoveLinkedListElements {
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(7);
        linkedList.append(node1);
        Node node2 = new Node(6);
        linkedList.append(node2);
        Node node3 = new Node(7);
        linkedList.append(node3);
        removeElements(linkedList.head, 6);
    }

    private static Node removeElements(Node head, int val) {
        Node dummy = new Node();
        dummy.next = head;
        Node previous = null;
        while (head != null) {
            Node next = head.next;
            int val1 = val;
            int val2 = (int) head.data;
            if (val1 == val2) {
                if (previous != null) {
                    previous.next = next;
                } else {
                    dummy.next = next;
                }
            } else {
                previous = head;
            }
            head = next;
        }
        return dummy.next;
    }
}
