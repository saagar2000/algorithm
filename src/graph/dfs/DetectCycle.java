package graph.dfs;

import java.util.*;

public class DetectCycle {

  public static void main(String[] args) {
    int[][] graph = {{4}, {10}, {1}, {2}, {5, 6}, {6, 4}, {5, 8}, {0}, {9}, {3}, {}};
    boolean cycle = runDfs(11, graph);
    System.out.println("Contains Cycle " + cycle);
  }

  private static boolean runDfs(int V, int[][] graph) {
    for (int r = 0; r < V; r++) {
      Deque<Integer> paths = new ArrayDeque<>();
      Set<Integer> visited = new HashSet<>();
      Set<Integer> beingVisited = new HashSet<>();
      paths.push(r);
      beingVisited.add(r);
      while (!paths.isEmpty()) {
        int children = paths.peek();
        if (graph[children].length == 0) {
          Integer node = paths.pop();
          visited.add(node);
          beingVisited.remove(node);
          continue;
        }
        boolean childVisited = false;
        for (int child : graph[children]) {
          if (beingVisited.contains(child)) return true;
          if (!visited.contains(child)) {
            paths.push(child);
            beingVisited.add(child);
            childVisited = false;
          } else {
            childVisited = true;
          }
        }
        if (childVisited) {
          Integer node = paths.pop();
          beingVisited.remove(node);
          visited.add(node);
        }
      }
    }
    return false;
  }
}
