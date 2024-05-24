package grind75;

public class BinarySearchIterative {
  public static void main(String[] args) {
    //int[] arr = {};
    //int target = 1;
    int[] arr = {1, 2, 4, 6, 7, 9};
    int target = 8;
    System.out.println(binarySearch(arr, target));
  }
  private static int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    // Empty array check
    // Last element is when mid, left and right converge to same value
    // When target is not found and less than mid the left goes over the right otherwise right goes under the left
    // When target is out of bound at left end the right goes under right and index is less than 0 ( out of bound )
    // otherwise the left go over right and index greater than the length of the array  ( out of bound )
    while(left <= right) {
        int mid = left + (right - left)/2;
        if(target == arr[mid]) {
            return mid;
        } else if (target < arr[mid]) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return -1;
  }
}
