package neetcode.twopointers;

import java.util.*;

public class ThreeSum {
  public static void main(String[] args) {
    List<List<Integer>> results = new ArrayList<>();
    int[] nums = {-1, 0, 1, 2, -1, -4};
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        for (int k = j; k < nums.length; k++) {
          if (nums[i] + nums[j] + nums[k] == 0) {
            results.add(List.of(nums[i], nums[j], nums[k]));
          }
        }
      }
    }
  }
}
