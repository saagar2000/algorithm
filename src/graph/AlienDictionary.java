package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlienDictionary {

  public static void main(String[] args) {
    String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
    // 0, 1, 2, 3, 4
    Map<Character, List<Character>> graph = buildGraph(dict);
    System.out.println(graph);
  }

  private static Map<Character, List<Character>> buildGraph(String[] dict) {
    Map<Character, List<Character>> connections = new HashMap<>();
    for (int i = 0; i < dict.length - 1; i++) {
      String first = dict[i];
      String second = dict[i + 1];
      if (first.length() != second.length()) {
        List<Character> edges = new ArrayList<>();
        edges.add(second.charAt(0));
        connections.put(first.charAt(0), edges);
      } else {
        for (int j = 0; j < first.toCharArray().length; j++) {
          if (first.charAt(j) != second.charAt(j)) {
            connections
                .computeIfAbsent(first.charAt(j), key -> new ArrayList<>())
                .add(second.charAt(j));
            break;
          }
        }
      }
    }
    return connections;
  }
}
