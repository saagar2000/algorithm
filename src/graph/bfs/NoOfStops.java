package graph.bfs;

import java.util.*;

public class NoOfStops {
  static Map<String, List<String>> destinations =
      Map.ofEntries(
          Map.entry("Los Angeles", List.of("New Delhi", "Japan", "France", "Ireland")),
          Map.entry("France", List.of("Norway", "Chicago")),
          Map.entry("Chicago", List.of("Italy")),
          Map.entry("Germany", List.of("New Delhi")),
          Map.entry("Ireland", List.of("Chicago", "New Delhi")),
          Map.entry("New Delhi", List.of("France")),
          Map.entry("Italy", List.of("Los Angeles", "New Delhi")));
  static Map<String, List<Integer>> cost =
      Map.ofEntries(
          Map.entry("Los Angeles", List.of(200, 87, 200, 100)),
          Map.entry("France", List.of(175)),
          Map.entry("Chicago", List.of(135)),
          Map.entry("Germany", List.of(125)),
          Map.entry("Ireland", List.of(100, 200)),
          Map.entry("New Delhi", List.of(100)),
          Map.entry("Italy", List.of(150, 300)));

  public static void main(String[] args) {
    runBfs("Los Angeles", "Chicago", 1, 3);
  }

  private static void runBfs(String in, String out, int start, int end) {
    Queue<Map.Entry<String, List<String>>> queue = new ArrayDeque<>();
    queue.add(Map.entry(in, List.of(in)));
    while (!queue.isEmpty()) {
      Map.Entry<String, List<String>> dest = queue.poll();
      if (dest != null) {
        if (out.equals(dest.getKey())) {
          int stops = dest.getValue().size() - 2;
          if (stops >= start && stops <= end) {
            System.out.println(dest.getValue());
          }
        } else {
          List<String> reachable = destinations.get(dest.getKey());
          if (reachable != null) {
            for (String r : reachable) {
              List<String> paths = new ArrayList<>(dest.getValue());
              paths.add(r);
              queue.add(Map.entry(r, paths));
            }
          }
        }
      }
    }
  }
}
