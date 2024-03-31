package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {
  public static void main(String[] args) {
    String value = "taaraa";
    Map<Character, Integer> charToFqy = new HashMap<>();
    int max = Integer.MIN_VALUE;
    int left = 0;
    int right = 0;
    int k = 2;
    while (right < value.length()) {
      charToFqy.merge(value.charAt(right), 1, Integer::sum);
      while (charToFqy.size() > k) {
        charToFqy.merge(value.charAt(left), -1, Integer::sum);
        if (charToFqy.get(value.charAt(left)) == 0) charToFqy.remove(value.charAt(left));
        left++;
      }
      max = Math.max(max, right - left + 1);
      right++;
    }
    System.out.println(max);
  }
}
