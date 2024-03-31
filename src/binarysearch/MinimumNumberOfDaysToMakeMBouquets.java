package binarysearch;

public class MinimumNumberOfDaysToMakeMBouquets {

  public static void main(String[] args) {
    int bouquets = 2;
    int flowers = 3;
    int[] bloomDay = {7, 7, 7, 7, 12, 7, 7};
    int max = 0;
    for (int day : bloomDay) {
      max = Math.max(day, max);
    }
    System.out.println(bruteForce(bloomDay, bouquets, flowers, max));
/*
    System.out.println(binarySearchRecursive(bloomDay, bouquets, flowers, 0, max));
*/
  }

  /*private static int binarySearchRecursive(int[] bloomDay, int bouquets, int flowers, int left, int max) {
      int middle = (left + max)/2;
      int day = calBouquets(bloomDay, bouquets, flowers, middle);
  }*/

  private static int calBouquets(int[] bloomDay, int bouquets, int flowers, int day) {
      int bouq = 0;
      int flow = 0;
      for (int j : bloomDay) {
          if (day >= j) {
              flow++;
              if (flow == flowers) {
                  bouq++;
                  flow = 0;
              }
              if (bouq == bouquets) {
                  return day;
              }
          } else {
              flow = 0;
          }
      }
      return -1;
  }
  private static int bruteForce(int[] bloomDay, int bouquets, int flowers, int max) {
    for (int day = 1; day <= max; day++) {
      int bouq = 0;
      int flow = 0;
      for (int j : bloomDay) {
        if (day >= j) {
          flow++;
          if (flow == flowers) {
            bouq++;
            flow = 0;
          }
          if (bouq == bouquets) {
            return day;
          }
        } else {
            flow = 0;
        }
      }
    }
    return -1;
  }
}
