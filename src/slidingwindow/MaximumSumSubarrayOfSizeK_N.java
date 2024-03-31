package slidingwindow;

public class MaximumSumSubarrayOfSizeK_N {

  public static void main(String[] args) {
    int[] values = {2, 1, 5, 1, 3, 3};
    int k = 5;
    int max = 0;
    int sum = 0;
    int windowstart = 0;
    int windowend = 0;
    for (int value : values) {
      if (windowend < k) {
        sum = sum + value;
        windowend++;
      }
      if (windowend == k) {
        max = Math.max(max, sum);
        sum = sum - values[windowstart];
        windowstart++;
        windowend = k - 1;
      }
    }
    System.out.println(max);
  }
}
