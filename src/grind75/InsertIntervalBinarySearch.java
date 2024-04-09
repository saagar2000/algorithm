package grind75;

import java.util.*;
import java.util.stream.*;

public class InsertIntervalBinarySearch {

  public static void main(String[] args) {
      int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
      int[] interval = {4, 8};
      int[][] result = insert(intervals, interval);

      for (int[] ints : result) {
          System.out.print("[");
          System.out.print(STR."\{ints[0]},\{ints[1]}");
          System.out.print("]");
          System.out.println();
      }
  }

  private static int[][] insert(int[][] intervals, int[] newInterval) {

    int left = 0;
    int right = intervals.length - 1;
    int target = newInterval[0];

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (intervals[mid][0] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    List<int[]> result = new ArrayList<>();
    IntStream.range(0, left).forEach(index -> result.add(intervals[index]));
    result.add(newInterval);
    IntStream.range(left, intervals.length).forEach(index -> result.add(intervals[index]));

    List<int[]> merged = new ArrayList<>();
    merged.add(result.getFirst());

    for (int i = 1; i < result.size(); i++) {
      if (merged.getLast()[1] > result.get(i)[0]) {
        merged.getLast()[1] = Math.max(merged.getLast()[1], result.get(i)[1]);
      } else {
        merged.addLast(intervals[i]);
      }
    }
    return merged.toArray(new int[0][]);
  }
}
