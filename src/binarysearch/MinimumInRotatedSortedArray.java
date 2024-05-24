package binarysearch;

public class MinimumInRotatedSortedArray {
  public static void main(String[] args) {
    int[] nums = {3,1,3};
    int left = 0, right = nums.length - 1;
    while (left < right) { // (0,2), (0,1)
      int mid = left + (right - left) / 2; // floor, 1
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    System.out.println(nums[left]);
    // Critical ideas to think
    // why not left <= right ? At the end of l > r iteration for next iteration l = r, all 1, r and
    // mid will point to same index resulting in infinite loop.
    // why are we returning nums[left] ? We can either return nums[left] or nums[right] as it will
    // be l=r after loop is terminated.
    // does it work for dups ? No - consider case when there is dupe on both sides of pivot. Other case include multiple dups on either side.
    //
  }
}
