package arrays;

public class BuySellMaxProfitIIUsingPeaksValley {
  public static void main(String[] args) {
    int[] prices = {7,1,5,3,6,4};
    int first = prices[0];//7, 1, 1
    int max = 0;
    int sum = 0;
    int previous = -1;
    for (int i = 1; i < prices.length; i++) {
      int current = prices[i]; //1//5//3
      int profit = current - first;//-6//4//2
      if(profit < 0 || current < first || previous > current) {
        first = current;//1//3
        sum = sum + max;//0//4
        max = 0;
        profit = 0;
      }
      max = Math.max(max, profit); // 0//4//
      previous = current;//1//5
    }
    System.out.println(sum + max);
  }
}
