package linkedlist;

public class DeleteNodeInLinkedList {

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(2);
        linkedList.append(node1);
        Node node2 = new Node(0);
        linkedList.append(node2);
        Node node3 = new Node(1);
        linkedList.append(node3);
        Node node4 = new Node(3);
        linkedList.append(node4);
        deleteNode(node1);
    }

    private static void deleteNode(Node node3) {
        Node current = node3;

        //1->2->3->4
        //2->3->4
            Node next = current.next;//2
            current.data = next.data;//2
            current.next = next.next;//2->3
    }
}
