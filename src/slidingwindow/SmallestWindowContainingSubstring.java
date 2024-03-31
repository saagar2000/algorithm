package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingSubstring {
  public static void main(String[] args) {
    String input = "aabdec", pattern="abc";
    Map<Character, Integer> patternHashMap = new HashMap<>();
    int right = 0;
    int left = 0;
    while(right < input.length()) {
      if(patternHashMap.size() == pattern.length()) {

      }
      right++;
    }
  }
}
