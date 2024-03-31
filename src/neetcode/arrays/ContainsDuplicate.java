package neetcode.arrays;

import java.util.*;

public class ContainsDuplicate {

  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
    System.out.println(containsDuplicate(nums));
  }

  private static boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    boolean dup = false;
    for (int i = 0; i < nums.length - 1; i++) {
      int curr = nums[i];
      int next = nums[i + 1];
      if (curr == next) {
        dup = true;
        break;
      }
    }
    return dup;
  }
}
