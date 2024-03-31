package grind75;

public class BinarySearch {

  public static void main(String[] args) {
    int[] array = new int[] {-1, 0, 3, 5, 9, 12};
    int low = 0;
    int high = array.length - 1;
    System.out.println(binarySearch(array, low, high, 3));
  }

  private static int binarySearch(int[] array, int low, int high, int target) {
    int mid = low + (high - low) / 2;
    if (array[mid] == target) {
      return mid;
    } else if(low == high) {
            return -1;
    } else if (array[mid] > target) {
      return binarySearch(array, low, mid - 1, target);
    } else {
      return binarySearch(array, mid + 1, high, target);
    }
  }
}
