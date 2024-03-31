package slidingwindow;

public class SmallestSubarrayWithAGivenSum_N {
  public static void main(String[] args) {
    int[] values = {2, 1, 0, 1, 3, 2};
    int s = 7;
    int windowstart = 0;
    int sum = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < values.length; i++) {
      var value = values[i];
      sum = sum + value;
      while (sum >= s) {
        min = Math.min(min, i - windowstart + 1);
        sum = sum - values[windowstart];
        windowstart++;
      }
    }
    System.out.println(min);
  }
}
