package grind75;

import lombok.*;

public class MergeTwoSortedLinkedLists {
  public static void main(String[] args) {

      ListNode endNode = new ListNode(4, null);
      ListNode secondNode = new ListNode(2, endNode);
      ListNode startNode = new ListNode(1, secondNode);

      ListNode endNode2 = new ListNode(6, null);
      ListNode secondNode2 = new ListNode(5, endNode2);
      ListNode startNode2 = new ListNode(3, secondNode2);

      ListNode listNode = mergeTwoLists(startNode, startNode2);
      while(listNode.next != null) {
          System.out.println(listNode.val);
          listNode = listNode.next;
      }

  }

    private static ListNode mergeTwoLists(ListNode startNode, ListNode startNode2) {
        if(startNode == null) return startNode2;
        if(startNode2 == null) return startNode;
        ListNode listNode = new ListNode();
        ListNode mergedNode = listNode;
        ListNode first = startNode;
        ListNode second = startNode2;
        while(first != null && second != null) {
            int val1 = first.val;
            int val2 = second.val;
            if(val1 < val2) {
                mergedNode.next = first;
                first = first.next;
            } else {
                mergedNode.next = second;
                second = second.next;
            }
            mergedNode = mergedNode.next;
        }
        mergedNode.next = first == null ? second : first;
        return listNode.next;
    }

    private static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
