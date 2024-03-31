package graph.bfs;

import java.util.*;
import java.util.Map.Entry;

public class NoOfIslands {
  public static void main(String[] args) {
    char[][] grid = {
      {'1', '1', '0', '0', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '1', '0', '0'},
      {'0', '0', '0', '1', '1'}
    };
    Set<Entry<Integer, Integer>> visited = new HashSet<>();
    int count = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<>(r, c);
        if (!visited.contains(new AbstractMap.SimpleEntry<>(r, c)) && grid[r][c] == '1') {
          bfs(entry, visited, grid);
          count++;
        }
      }
    }
    System.out.println(count);
  }

  private static void bfs(
    Entry<Integer, Integer> entry, Set<Entry<Integer, Integer>> visited, char[][] grid) {
    Queue<Entry<Integer, Integer>> queue = new ArrayDeque<>();
    queue.add(entry);
    visited.add(entry);
    while (!queue.isEmpty()) {
      Entry<Integer, Integer> current = queue.poll();
      int left = current.getValue() - 1;
      int right = current.getValue() + 1;
      int up = current.getKey() - 1;
      int down = current.getKey() + 1;
      if (left >= 0) {
        Entry<Integer, Integer> leftEntry = Map.entry(current.getKey(), left);
        if (!visited.contains(leftEntry) && grid[leftEntry.getKey()][leftEntry.getValue()] != '0') {
          queue.add(leftEntry);
          visited.add(leftEntry);
        }
      }
      if (right < grid[0].length) {
        Entry<Integer, Integer> rightEntry = Map.entry(current.getKey(), right);
        if (!visited.contains(rightEntry)
            && grid[rightEntry.getKey()][rightEntry.getValue()] != '0') {
          queue.add(rightEntry);
          visited.add(rightEntry);
        }
      }
      if (up >= 0) {
        Entry<Integer, Integer> upEntry = Map.entry(up, current.getValue());
        if (!visited.contains(upEntry) && grid[upEntry.getKey()][upEntry.getValue()] != '0') {
          queue.add(upEntry);
          visited.add(upEntry);
        }
      }
      if (down < grid.length) {
        Entry<Integer, Integer> downEntry = Map.entry(down, current.getValue());
        if (!visited.contains(downEntry) && grid[downEntry.getKey()][downEntry.getValue()] != '0') {
          queue.add(downEntry);
          visited.add(downEntry);
        }
      }
    }
  }
}
