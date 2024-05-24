package grind75;

import java.util.*;
import java.util.stream.*;

public class KthSmallestElement {
    public static void main(String[] args){


    }

    private static int kthSmallestElementBF(int[] array, int k) {
        Arrays.sort(array);
        return array[k-1];
    }

    private static int kthSmallestElementPQMinHeap(int[] array, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.stream(array).forEach(minHeap::add);
        while(minHeap.size() > k -1) {
            minHeap.remove();
        }
        return minHeap.peek();
    }

    private static int kthSmallestElementPQMaxHeap(int[] array, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.stream(array).forEach(maxHeap::add);
        while(maxHeap.size() < array.length - k) {
            maxHeap.remove();
        }
        return maxHeap.peek();
    }
}
