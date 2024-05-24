package dp;

import java.util.*;

public class LongestIncreasingSubsequence {

  public static void main(String[] args) {

    // Reoccurrence relation

    int[] nums = {3, 4, 5, 7, 8};
    System.out.println(lis(nums, 0, Integer.MIN_VALUE, HashMap.newHashMap(nums.length)));
  }

  private static int lis(int[] nums, int index, int last, Map<Integer, Integer> memo) {

    if (memo.containsKey(index)) {
      return memo.get(index);
    }
    int longest = 0;
    for (int i = index; i < nums.length; i++) {

      if (last < nums[i]) {
        int length = 1 + lis(nums, i + 1, nums[i], memo);
        if (length > longest) {
          longest = length;
          memo.put(index, longest);
        }
      }
    }
    return longest;
  }
}
