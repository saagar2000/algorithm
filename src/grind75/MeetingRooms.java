package grind75;

import java.util.*;

public class MeetingRooms {
  public static void main(String[] args) {
    int[][] data = {{4, 9}, {4, 17}, {9, 10}};
    System.out.println(minMeetingRooms(data));
  }

  private static int minMeetingRooms(int[][] data) {
    Arrays.sort(data, Comparator.comparingInt(val -> val[0]));

    PriorityQueue<int[]> inProgress = new PriorityQueue<>(Comparator.comparingInt(val -> val[1]));

      for (int[] datum : data) {
          if (!inProgress.isEmpty() && inProgress.peek()[1] <= datum[0]) {
              inProgress.remove();
          }
          inProgress.add(datum);
      }
    return inProgress.size();
  }
}
