package arrays;

import static java.lang.Integer.max;

public class MaximumSubarraySumDivideAndConquer {

  public static int maxSubArrayDividConquer(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    return helper(nums, 0, nums.length - 1);
  }

  private static int helper(int[] nums, int l, int r) {
    if (l > r) return Integer.MIN_VALUE;
    int mid = (l + r) >>> 1;
    int left = helper(nums, l, mid - 1);
    int right = helper(nums, mid + 1, r);
    int leftMaxSum = 0;
    int sum = 0;
    // left surfix maxSum start from index mid - 1 to l
    for (int i = mid -1; i >= l; i--) {
      sum += nums[i];
      leftMaxSum = Math.max(leftMaxSum, sum);
    }
    int rightMaxSum = 0;
    sum = 0;
    // right prefix maxSum start from index mid + 1 to r
    for (int i = mid + 1; i <= r; i++) {
      sum += nums[i];
      rightMaxSum = Math.max(sum, rightMaxSum);
    }
    // max(left, right, crossSum)
    return Math.max(leftMaxSum + rightMaxSum + nums[mid], Math.max(left, right));
  }

  /* Driver program to test maxSubArraySum */
  // Function to find the maximum subarray sum using divide-and-conquer
  public static int findMaximumSum(int[] nums, int left, int right) {
    System.out.println("START");
    System.out.println("LEFT " + left + "," + "RIGHT " + right);
    // If the array contains 0 or 1 element
    if (right == left) {
      System.out.println("END");
      System.out.println("LEFT " + left + "," + "RIGHT " + right);
      return nums[left];
    }

    // Find the middle array element
    int mid = (left + right) >>> 1;

    // Find maximum subarray sum for the left subarray,
    // including the middle element
    int leftMax = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = mid; i >= left; i--) {
      sum += nums[i];
      leftMax = Math.max(sum, leftMax);
    }
    System.out.println(leftMax);

    // Find maximum subarray sum for the right subarray,
    // excluding the middle element
    int rightMax = Integer.MIN_VALUE;
    sum = 0; // reset sum to 0
    for (int i = mid + 1; i <= right; i++) {
      sum += nums[i];
      rightMax = Math.max(sum, rightMax);
    }

    System.out.println(rightMax);

    // Recursively find the maximum subarray sum for the left
    // and right subarray, and take maximum
    // return the maximum of the three
    return max(
        max(findMaximumSum(nums, left, mid), findMaximumSum(nums, mid + 1, right)),
        leftMax + rightMax);
  }

  // Wrapper over findMaximumSum() function
  public static int findMaximumSum(int[] nums) {
    // base case
    if (nums == null || nums.length == 0) {
      return 0;
    }

    return findMaximumSum(nums, 0, nums.length - 1);
  }

  public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    System.out.println("The maximum sum of the subarray is " + maxSubArrayDividConquer(nums));
  }
}
