package slidingwindow;

public class MaximumSumSubarrayOfSizeK_NK {

  public static void main(String[] args) {
    int[] values = {2, 1, 5, 1, 3, 3};
    int k = 3;
    int max = 0;
    for (int i = 0; i < values.length - k; i++) {
      int sum = 0;
      for (int j = i; j < i + k; j++) {
        sum = sum + values[j];
      }
      max = Math.max(max, sum);
    }
    System.out.println(max);
  }
}
