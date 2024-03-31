package stack;

import java.util.*;

public class AsteridCollision {

  public static void main(String[] args) {
    int[] arr = new int[] {1, -1, -2, -2};
    List<Integer> results = new ArrayList<>();
    for (int ast : arr) {
      boolean add = true;
      while (!results.isEmpty() && results.getLast() > 0 && ast < 0) {
        if (results.getLast() < -ast) {
          results.removeLast();
          continue;
        } else if (results.getLast() == -ast) {
          results.removeLast();
        }
        add = false;
        break;
      }
      if (add) results.addLast(ast);
    }
    results.stream().mapToInt(Integer::intValue).forEach(System.out::println);
  }
}
