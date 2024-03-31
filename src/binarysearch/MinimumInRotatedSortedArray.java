package binarysearch;

public class MinimumInRotatedSortedArray {
  public static void main(String[] args) {
    int[] nums = {3, 1, 2};
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    System.out.println(nums[left]);
  }
}
