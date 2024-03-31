package binarysearch;

public class BinarySearchInArray {
  public static void main(String[] args) {
    int[] input = {1, 2, 3, 4, 5, 6};
    int target = 7;
    System.out.println(searchRecursive(0, input.length - 1, input, target));// 0, 5
  }

  private static int runBinarySearchRecursively(
          int[] sortedArray, int key, int low, int high) {
    int middle = low  + ((high - low) / 2);

    if (high < low) {
      return -1;
    }

    if (key == sortedArray[middle]) {
      return middle;
    } else if (key < sortedArray[middle]) {
      return runBinarySearchRecursively(
              sortedArray, key, low, middle - 1);
    } else {
      return runBinarySearchRecursively(
              sortedArray, key, middle + 1, high);
    }
  }
  private static int searchRecursive(int start, int end, int[] nums, int target) {
    int mid = (start + end) / 2; // 2
    if (target == nums[mid]) {
      return mid;
    }
    if(start == end) {
      return -1;
    }
    if (target < nums[mid]) {
      return searchRecursive(start, mid - 1, nums, target);
    } else {
      return searchRecursive(mid + 1, end, nums, target);
    }
  }

  // -1, 0, [3], 5, 9, 12
  // 5, 9, 12
  // 5, [9], 12
}
