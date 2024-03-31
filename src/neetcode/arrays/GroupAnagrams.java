package neetcode.arrays;

import java.util.*;

public class GroupAnagrams {

  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> groups = iGroupAnagrams(strs);
  }

  private static List<List<String>> iGroupAnagrams(String[] strs) {
    Map<String, List<String>> strings = new HashMap<>();
    for (String s : strs) {
      String hash = hash(s);
      if (strings.containsKey(hash)) {
        strings.get(hash).add(s);
      } else {
        List<String> list = new ArrayList<>();
        list.add(s);
        strings.put(hash, list);
      }
    }
    return new ArrayList<>(strings.values());
  }

  private static String hash(String str) {
    char[] hashChar = new char[26];
    for (char c : str.toCharArray()) {
        hashChar[c - 'a']++;
    }
    return Arrays.toString(hashChar);
  }
}
