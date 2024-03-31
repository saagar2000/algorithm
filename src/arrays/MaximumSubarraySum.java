package arrays;

public class MaximumSubarraySum {
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4};
    System.out.println(maxSubArray(array));
  }

  public static int maxSubArray(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    int sum = nums[0]; // -2
    int maxSum = nums[0]; // -2
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] + sum > nums[i]) { // 1 > -2
        sum = sum + nums[i];
      } else {
        sum = nums[i];
      }
      maxSum = Math.max(sum, maxSum); // -2
    }
    return maxSum;
  }
}
