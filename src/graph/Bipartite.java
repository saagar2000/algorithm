package graph;

import java.util.*;

public class Bipartite {
  public static void main(String[] args) {
    int[][] graph = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
    boolean isBipartite = true;
    for (int r = 0; r < graph.length; r++) {
      Integer[] sideMapping = new Integer[graph.length];
      Queue<Integer> queue = new ArrayDeque<>();
      queue.add(r);
      sideMapping[r] = 0;
      while (!queue.isEmpty()) {
        Integer current = queue.poll();
        for (int neighbour : graph[current]) {
          if (sideMapping[neighbour] == null) {
            queue.add(neighbour);
            sideMapping[neighbour] = sideMapping[current] ^ 1;
            ;
          } else {
            int visitedSide = sideMapping[neighbour];
            isBipartite = isBipartite & visitedSide != sideMapping[current];
          }
        }
      }
    }
    System.out.println(isBipartite);
  }
}
