package binarysearch;

public class SqrtUsingBinarySearch {

  public static void main(String[] args) {
    int num = 25;
    int low = 1, high = num;
    System.out.println(SqrtUsingBinarySearchRecursive(num, low, high));
  }


  private static int SqrtUsingBinarySearchRecursive(int num, int low, int high) {
    int mid = (low + high) / 2;
    int sqrt = mid * mid;
    if (sqrt == num) {
      return mid;
    }
    if (num < sqrt) {
      return SqrtUsingBinarySearchRecursive(25, low, mid - 1);
    } else {
      return SqrtUsingBinarySearchRecursive(25, mid + 1, high);
    }
  }
}
