package grind75;

import java.util.*;

public class FloodFill {
  public static void main(String[] args) {
    int[][] arr = {
      {1, 1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 0, 0},
      {1, 0, 0, 1, 1, 0, 1, 1},
      {1, 2, 2, 2, 2, 0, 1, 0},
      {1, 1, 1, 2, 2, 0, 1, 0},
      {1, 1, 1, 2, 2, 2, 2, 0},
      {1, 1, 1, 1, 1, 2, 1, 1},
      {1, 1, 1, 1, 1, 2, 2, 1}
    };
    for (int row = 0; row < arr.length; row++) {
      System.out.print("  {");
      for (int col = 0; col < arr[0].length; col++) {
        System.out.print(STR."\{arr[row][col]},");
      }
      System.out.print("}");
      System.out.println();
    }
    System.out.println("}");

    floodFill(arr, 4, 4, 3);
    System.out.println("{");
    for (int row = 0; row < arr.length; row++) {
      System.out.print("  {");
      for (int col = 0; col < arr[0].length; col++) {
        System.out.print(STR."\{arr[row][col]},");
      }
      System.out.print("}");
      System.out.println();
    }
    System.out.println("}");
  }

  private static void floodFill(int[][] arr, int sr, int sc, int color) {
    Queue<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
    // check if out of bounds
    int rlen = arr.length;
    int clen = arr[0].length;
    int clr = arr[sr][sc];

    queue.add(Map.entry(sr, sc));

    while (!queue.isEmpty()) {
      Map.Entry<Integer, Integer> entry = queue.poll();
      Integer row = entry.getKey();
      Integer col = entry.getValue();

      arr[row][col] = color;

      int up = row - 1;
      int down = row + 1;
      int left = col - 1;
      int right = col + 1;

      if (up > -1 && arr[up][col] == clr) {
        queue.offer(Map.entry(up, col));
      }
      if (down < rlen && arr[down][col] == clr) {
        queue.offer(Map.entry(down, col));
      }
      if (left > -1 && arr[row][left] == clr) {
        queue.offer(Map.entry(row, left));
      }
      if (right < clen && arr[row][right] == clr) {
        queue.offer(Map.entry(row, right));
      }
    }
  }
}
