package grind75;

import java.util.*;

public class MedianFromDataStream {

  public static void main(String[] args) {}

  private class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public void add(int ele) {
      if (maxHeap.isEmpty()) {
        maxHeap.offer(ele);
        return;
      }

      if (maxHeap.peek() >= ele) {
        maxHeap.offer(ele);
      } else {
        minHeap.offer(ele);
      }
      rebalance();
    }

    public void rebalance() {
      if (maxHeap.isEmpty() || minHeap.isEmpty()) return;

      if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.offer(maxHeap.poll());
      } else if (maxHeap.size() < minHeap.size()) {
        maxHeap.offer(minHeap.poll());
      }
    }

    public int medianFinder() {
      if (maxHeap.size() == minHeap.size()) {
        return (maxHeap.peek() + minHeap.peek()) / 2;
      } else {
        return maxHeap.peek();
      }
    }
  }
}
