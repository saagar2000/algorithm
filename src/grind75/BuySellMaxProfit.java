package grind75;

public class BuySellMaxProfit {
  public static void main(String[] args) {
    int[] prices = {7,2,1,3,0,6,10};
    int first = prices[0];
    int max = 0;
    for (int i = 1; i < prices.length; i++) {
      int second = prices[i];
      int profit = second - first;
      if(profit < 0) {
        first = second;
      }
      max = Math.max(max, profit);
    }
    System.out.println(max);
  }
}
