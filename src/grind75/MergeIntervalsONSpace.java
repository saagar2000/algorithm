package grind75;

import java.util.*;

public class MergeIntervalsONSpace {
  public static void main(String[] args) {
    int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
    int[][] result = mergeIntervals(intervals);
    for (int[] ints : result) {
      System.out.print("[");
      System.out.print(STR."\{ints[0]},\{ints[1]}");
      System.out.print("]");
      System.out.println();
    }
  }

  private static int[][] mergeIntervals(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
    List<int[]> mergeIntervals = new ArrayList<>();
    int[] prev = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
      int[] current = intervals[i];
      if (current[0] <= prev[1]) {
        prev = new int[] {prev[0], Math.max(prev[1], current[1])};
      } else {
        mergeIntervals.addLast(prev);
        prev = current;
      }
    }
    mergeIntervals.addLast(prev);
    return mergeIntervals.toArray(new int[mergeIntervals.size()][2]);
  }
}
