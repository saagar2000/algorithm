package neetcode.arrays;

import java.util.*;

public class ProductOfArrayExceptSelf {
  public static void main(String[] args) {
    int[] nums = new int[] {4, 3, 2, 1, 2};
    System.out.println(Arrays.toString(productExceptSelf2(nums)));
  }

  private static int[] productExceptSelf2(int[] nums) {
    int[] results = new int[nums.length];
    results[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      results[i] = results[i - 1] * nums[i - 1];
    }
    int runningPostfixProduct = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      results[i] = results[i] * runningPostfixProduct;
      runningPostfixProduct = runningPostfixProduct * nums[i];
    }
    return results;
  }

  private static int[] productExceptSelf(int[] nums) {
    int[] results = new int[nums.length];
    int product = 1;
    for (int i = 0; i < nums.length; i++) {
      product = product * nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
      results[i] = product / nums[i];
    }
    return results;
  }
}
