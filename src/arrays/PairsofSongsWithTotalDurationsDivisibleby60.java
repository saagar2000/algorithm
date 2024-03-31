package arrays;

public class PairsofSongsWithTotalDurationsDivisibleby60 {
  public static void main(String[] args) {
    int[] times = {60, 120, 20, 60, 120, 150, 100, 40};
    System.out.println(numPairsDivisibleBy60(times));
  }

  public static int numPairsDivisibleBy60(int[] times) {
    int remainders[] = new int[60];
    int count = 0;
    for (int t : times) {
       // check if a%60+b%60==60
      count += remainders[60 - t % 60];
      remainders[t % 60]++; // remember to update the remainders
    }
    return count;
  }
}
