package neetcode.arrays;

import java.util.*;

public class LongestConsecutiveSequence {

  public static void main(String[] args) {
    int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    // 0, 0, 1, 2, 3, 4, 5, 6, 7, 8
    System.out.println(longestConsecutive(nums));
  }

  private static int longestConsecutive(int[] nums) {
    Arrays.sort(nums);
    int sequence = 1;
    int maxSequence = 1;
    for (int i = 0; i < nums.length - 1; i++) { // 0 -> 9
      if (nums[i + 1] - nums[i] <= 1) {
        sequence++;
        maxSequence = Math.max(sequence, maxSequence);
      } else {
        sequence = 1;
      }
    }
    return maxSequence;
  }
}
