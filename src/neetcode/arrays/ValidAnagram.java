package neetcode.arrays;

import java.util.*;

public class ValidAnagram {

  public static void main(String[] args) {
    String s = "baa";
    String t = "aba";
    System.out.println(anagramCheck(s, t));
  }

  private static boolean anagramCheck(String s, String t) {
    if (s.length() != t.length()) return false;
    Map<Character, Integer> frequency = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      Character source = t.charAt(i);
      Character target = t.charAt(i);
      frequency.merge(
          source,
          1,
          (prev, curr) -> {
            if (prev - curr == 0) {
              return null;
            } else {
              return --prev;
            }
          });
      frequency.merge(
              target,
              1,
              (prev, curr) -> {
                if (prev - curr == 0) {
                  return null;
                } else {
                  return --prev;
                }
              });
    }
    return frequency.isEmpty();
  }
}
