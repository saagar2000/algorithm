package grind75;

import linkedlist.*;

import java.util.*;

public class MergeKSortedLists {

    public static void main(String[] args){

    }


    private static Node<Integer> mergeKSortedLists(Node<Integer>[] lists) {

        Node<Integer> mergedList = new Node<>();
        Node<Integer> current = mergedList;
        PriorityQueue<Node<Integer>> pqHeads = new PriorityQueue<>(Comparator.comparingInt(node -> node.data));
        pqHeads.addAll(Arrays.asList(lists));

        while(!pqHeads.isEmpty()) {
            Node<Integer> min = pqHeads.poll();
            current.next = min;
            Node<Integer> next = min.next;
            if(next != null) {
             pqHeads.add(next);
            }
            current = current.next;
        }

        return mergedList.next;

    }
}
