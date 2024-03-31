package arrays;

public class BuySellMaxProfitIIUsingSimpleSum {
  public static void main(String[] args) {
    int[] prices = {7,1,6,3,7,4};
    int sum = 0;
    for (int i = 1; i < prices.length; i++) {
      int first = prices[i - 1];
      int second = prices[i];
      int profit = second - first;
      if(profit > 0) {
        sum = sum + profit;
      }
    }
    System.out.println(sum);
  }
}
