package amazon;

import java.util.*;

public class CountTheNumberOfKBigIndices {
    public static void main(String[] args){

    }
}


/*package com.codility;

// you can also use imports, for example:
// import java.util.*;

public class Solution {

    public static void main(String [] args) {
        int[] array = {1,2,3,4,5};
        int k = 2;
        LinkedList<Integer> list = new LinkedList<>();
        for(int v: array) {
            list.add(v);
        }
        while(list.size() >= k) {
            LinkedList<Integer> start = list;
            LinkedList<Integer> end;
            int counter = 0;
            while(list.next != null) {
                counter++;
                if(counter == k) {
                    end = list.next;
                    counter = 0;
                    break;
                }
                list = list.next;
            }
            LinkedList<Integer> next = reverse(start, end);
            list = next;
        }
    }

    private static LinkedList<Integer> reverse(LinkedList<Integer> start, LinkedList<Integer> end) {
        LinkedList<Integer> current = start;
        while(current != end) {
            LinkedList<Integer> next = start.next;
            next = current;
            current = current.next;
        }
    }
}*/
