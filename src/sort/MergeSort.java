package sort;

import java.util.*;

/**
 * Top bottom recursive approach to first split the array into two halves and
 * recursively reducing it to single element array followed by comparison of two sorted
 * arrays and merge into one sorted array.
 */
public class MergeSort {
  public static void main(String[] args) {
    int[] nums = {2, 1, 1};
    System.out.println(Arrays.toString(mergeSort(0, nums.length - 1, nums)));
  }

  private static int[] mergeSort(int left, int right, int[] nums) {
    if (left >= right) return new int[] {nums[right]};
    int mid = left + (right - left) / 2;
    int[] leftArray = mergeSort(left, mid, nums);
    int[] rightArray = mergeSort(mid + 1, right, nums);
    return merge(leftArray, rightArray);
  }

  private static int[] merge(int[] leftArray, int[] rightArray) {
    int left = 0;
    int length = leftArray.length + rightArray.length;
    int[] nums = new int[length];
    int right = 0;
    int index = 0;
    while (left < leftArray.length || right < rightArray.length) {
      if (left == leftArray.length) {
        nums[index] = rightArray[right];
        right++;
      } else if (right == rightArray.length) {
        nums[index] = leftArray[left];
        left++;
      } else {
        int leftValue = leftArray[left];
        int rightValue = rightArray[right];
        if (leftValue <= rightValue) {
          nums[index] = leftValue;
          left++;
        } else {
          nums[index] = rightValue;
          right++;
        }
      }
      index++;
    }
    return nums;
  }
}
