package grind75;

import java.util.*;

public class SlidingWindowMedian {

  public static void main(String[] args) {
    int[] nums = {-2147483648, -2147483648, 2147483647};
    medianSlidingWindow(nums, 2);
  }

  public static double[] medianSlidingWindow(int[] nums, int k) {

    double[] medians = new double[nums.length - (k - 1)];
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    for (int i = 0; i < nums.length; i++) {
      add(nums[i], maxHeap, minHeap);
      if (i - (k - 1) >= 0) {
        medians[i - (k - 1)] = findMedian(maxHeap, minHeap);
        remove(nums[i - (k - 1)], maxHeap, minHeap);
      }
    }
    return medians;
  }

  private static void add(
      int ele, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
    if (maxHeap.isEmpty()) {
      maxHeap.offer(ele);
      return;
    }

    if (maxHeap.peek() >= ele) {
      maxHeap.offer(ele);
    } else {
      minHeap.offer(ele);
    }
    rebalance(maxHeap, minHeap);
  }

  private static void remove(
      int ele, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
    if (maxHeap.peek() >= ele) {
      maxHeap.remove(ele);
    } else {
      minHeap.remove(ele);
    }
    rebalance(maxHeap, minHeap);
  }

  private static void rebalance(
      PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
      if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.offer(maxHeap.poll());
      } else if (maxHeap.size() < minHeap.size()) {
        maxHeap.offer(minHeap.poll());
      }
  }

  private static double findMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
    if (maxHeap.size() == minHeap.size()) {
      return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
    } else {
      return maxHeap.peek();
    }
  }
}
