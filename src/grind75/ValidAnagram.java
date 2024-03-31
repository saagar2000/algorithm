package grind75;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class ValidAnagram {
  public static void main(String[] args) {
    String str = "anagram";
    String tar = "nagar0m";
    System.out.println(isValidAnagram(str, tar));
  }

  private static boolean isValidAnagram(String str, String tar) {
    Map<Character, Integer> strFreMap =
        str.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));
    for (char c : tar.toCharArray()) {
      strFreMap.computeIfPresent(
          c,
          (key, value) -> {
            value--;
            if (value == 0) {
              return null;
            }
            return value;
          });
    }
    return strFreMap.isEmpty();
  }
}
