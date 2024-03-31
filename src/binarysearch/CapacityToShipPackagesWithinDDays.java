package binarysearch;

public class CapacityToShipPackagesWithinDDays {
  public static void main(String[] args) {
    int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int days = 5;
    int max = 0;
    int sum = 0;
    for (int weight : weights) {
      max = Math.max(weight, max);
      sum = sum + weight;
    }
    System.out.println(binarySearchRecursively(weights, days, max, sum));
  }

  private static int binarySearchRecursively(int[] weights, int days, int min, int max) {
    int mid = (min + max) / 2; // 10 + 54 = 32
    int noOfDaysWithGivenCapacity = calNoOfDaysWithGivenCapacity(weights, mid);
    if (noOfDaysWithGivenCapacity == days) {
      return mid;
    }
    if (noOfDaysWithGivenCapacity > days) {
        return binarySearchRecursively(weights, days, mid, max);
    } else {
      return binarySearchRecursively(weights, days, min, mid);
    }
  }

  private static int calNoOfDaysWithGivenCapacity(int[] weights, int mid) {
    int days = 0;
    int total = 0;
    for (int weight : weights) {
      if (weight < mid) {
        total += weight;
      }
      if (total > mid) {
        days++;
        total = weight;
      }
    }
    if (total != 0) {
      days++;
    }
    return days;
  }
}
