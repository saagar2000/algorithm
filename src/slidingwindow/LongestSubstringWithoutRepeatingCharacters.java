package slidingwindow;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    String s = "pwwkew";
    // abba
    // i  0,0,2,1
    //   [a,b,b,a]
    // j  0,1,2,3
    // m  1,2,3,1
    // r  1,2,1,3
    System.out.println(lengthOfLongestSubstring(s));
  }

  private static int lengthOfLongestSubstring(String word) {
    Set<Character> duplicates = new HashSet<>();
    int l = 0, r = 0;
    int length = 0;
    while (r < word.length()) {
      char letter = word.charAt(r);
      if(duplicates.contains(letter)) {
        duplicates.remove(letter);
        l++;
      } else {
        duplicates.add(letter);
      }
      length = Math.max(length, r - l);
      r++;
    }
    return length;
  }
}
