package graph.bfs;

import java.util.*;

public class ShortestPath {
  public static void main(String[] args) {
    int[][] graph = {{2, 3}, {4, 5}, {5, 6}, {6, 7}, {6}, {7} , {}};
    int origin = 1;
    int destination = 7;
    runBfs(origin, destination, graph);
  }

  private static void runBfs(int origin, int destination, int[][] graph) {
    Queue<Map.Entry<Integer, List<String>>> queue = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();
    List<String> path = new ArrayList<>();
    path.add(String.valueOf(origin));
    queue.add(Map.entry(origin, path));
    visited.add(origin);
    while (!queue.isEmpty()) {
      Map.Entry<Integer, List<String>> dest = queue.poll(); // 1
      if (dest.getKey() == destination) {
        System.out.println(dest.getValue());
        return;
      }
      int[] childs = graph[dest.getKey() - 1]; // 2, 3
      for (int child : childs) {
        if (!visited.contains(child)) {
          visited.add(child);
          List<String> paths = new ArrayList<>(dest.getValue());
          paths.add(String.valueOf(child));
          queue.add(Map.entry(child, paths));
        }
      }
    }
  }
}
