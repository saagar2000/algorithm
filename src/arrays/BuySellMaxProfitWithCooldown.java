package arrays;

public class BuySellMaxProfitWithCooldown {
  public static void main(String[] args) {
    int[] prices = {7,1,6,3,7,4};
    //Turns out to be dynamic problem - Thanks!
    //Find a cooldown day -
    // it can be either when previous day price is higher than current day price
    // or
    int sum = 0;
    int max = 0;
    int first = prices[0];
    boolean cooldown = false;
    for (int i = 1; i < prices.length; i++) {
      int second = prices[i];
      int profit = second - first;
      if(profit < 0) {
        first = second;
        cooldown = true;
        max = 0;
      } else {
        if(cooldown) {
          max = Math.max(max, profit);
        }
      }

    }
    System.out.println(sum);
  }
}
