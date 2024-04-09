package grind75;

import java.util.*;

public class InsertInterval {
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

    int newstart = newInterval[0];
    int newend = newInterval[1];

    List<int[]> result = new ArrayList<>();

    boolean insert = false;
    for (int[] current : intervals) {
      int start = current[0];
      int end = current[1];
      if (!insert) {
        if (newend < start) { // beginning
          result.add(new int[] {newstart, newend});
          insert = true;
        } else if (newstart <= end) { // overlapping
          newstart = Math.min(newstart, start);
          newend = Math.max(newend, end);
        } else { //
          result.add(new int[] {start, end});
        }
      }

      if (insert) {
        result.add(new int[] {start, end});
      }
    }
    if (!insert) result.add(new int[] {newstart, newend});
    return result.toArray(new int[result.size()][2]);
  }
}
