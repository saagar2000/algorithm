package graph.dfs;

import java.util.*;

public class ShortestPath {
  public static void main(String[] args) {
    int[][] graph = {{2, 3}, {4, 5}, {5, 6}, {6, 7}, {6}, {7}, {}};
    int origin = 1;
    int destination = 7;
    runDfs(origin, destination, graph);
  }

  private static void runDfs(int origin, int destination, int[][] graph) {
    Deque<Map.Entry<Integer, List<String>>> stack = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();
    List<String> path = new ArrayList<>();
    path.add(String.valueOf(origin));
    stack.add(Map.entry(origin, path));
    visited.add(origin);
    while (!stack.isEmpty()) {
      Map.Entry<Integer, List<String>> dest = stack.pop(); // 1
      if (dest.getKey() == destination) {
        System.out.println(dest.getValue());
        return;
      }
      int[] childs = graph[dest.getKey() - 1]; // 2, 3
      for (int child : childs) {// 5, 6
        if (!visited.contains(child)) {
          visited.add(child);
          List<String> paths = new ArrayList<>(dest.getValue());
          paths.add(String.valueOf(child));
          stack.push(Map.entry(child, paths));
        }
      }
    }
  }
}
