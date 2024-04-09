package grind75;

import java.util.*;

public class MergeIntervalsOptimal {
  public static void main(String[] args) {
    int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
    int index = mergeIntervals(intervals);
    intervals = Arrays.copyOf(intervals, index);
    for (int[] ints : intervals) {
      System.out.print("[");
      System.out.print(STR."\{ints[0]},\{ints[1]}");
      System.out.print("]");
      System.out.println();
    }
  }

  private static int mergeIntervals(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
    int index = 0;
    // {1,3} {2,6} {3,4}
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[index][1] >= intervals[i][0]) {
        intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
      } else {
        index = index + 1;
        intervals[index] = intervals[i];
      }
    }
    return index + 1;

  }
}
