package graph.bfs;

import java.util.*;

public class MinMovesToSpreadStonesOverGrid {

  public static void main(String[] args) {
    int grid[][] = {
      {1, 1, 0},
      {1, 1, 1},
      {1, 2, 1}
    };
    Deque<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
    Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        queue.clear();
        if (!visited.contains(Map.entry(i, j)) && grid[i][j] > 1) {
          queue.add(Map.entry(i, j));
          while (!queue.isEmpty()) {
            int left = j - 1;
            int right = j + 1;
            int top = i + 1;
            int bottom = i - 1;

            Map.Entry<Integer, Integer> entry = queue.poll();
            int value = grid[entry.getKey()][entry.getValue()];
            if (left >= 0) {
                queue.add(Map.entry(i, left));
                visited.add(Map.entry(i, left));
            }

           /* if (right < grid.length) {}

            if (top >= 0) {}

            if (bottom < grid[0].length) {}*/
          }
        }
      }
    }
  }
}
