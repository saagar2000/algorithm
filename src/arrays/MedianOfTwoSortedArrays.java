package arrays;

public class MedianOfTwoSortedArrays {

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 7};
    int[] nums2 = {6, 9, 8};
    System.out.println(findMedianSortedArrays(nums1, nums2));
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int length = nums1.length + nums2.length;
    int first = 0;
    int second = 0;
    int pointer1 = 0;
    int pointer2 = 0;
    if (length % 2 != 0) {
      for (int i = 0; i <= length / 2; i++) {
        if (pointer1 > nums1.length) {
          first = nums1[pointer1++];
        }
        if (pointer2 > nums2.length) {
          first = nums2[pointer2++];
        }
        if (nums1[pointer1] < nums2[pointer2]) {
          first = nums1[pointer1++];
        } else if (nums1[pointer1] > nums2[pointer2]) {
          first = nums2[pointer2++];
        }
      }
      return first;
    } else {
      for (int i = 0; i <= length / 2; i++) {
        second = first;
        if (pointer1 > nums1.length) {
          first = nums1[pointer1++];
        }
        if (pointer2 > nums2.length) {
          first = nums2[pointer2++];
        }
        if (nums1[pointer1] < nums2[pointer2]) {
          first = nums1[pointer1++];
        } else if (nums1[pointer1] > nums2[pointer2]) {
          first = nums2[pointer2++];
        }
      }
    }
    return (double) (first + second) / 2;
  }
}
