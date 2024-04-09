package grind75;

import java.util.*;

public class MergeIntervalsStack {
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
    Deque<int[]> stack = new ArrayDeque<>();
    stack.push(intervals[0]);
    for(int i=1; i < intervals.length; i++) {
      if(stack.peek()[1] < intervals[i][0]) {
        stack.push(intervals[i]);
      } else {
        stack.peek()[1] = Math.max(intervals[i][1], stack.peek()[1]);
      }
    }

    int[][] result = new int[stack.size()][2];
    int i = 0;
    while(!stack.isEmpty()) {
      result[i] = stack.pop();
      i++;
    }
    return result;
  }
}
