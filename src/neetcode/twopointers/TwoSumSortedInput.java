package neetcode.twopointers;

public class TwoSumSortedInput {
  public static void main(String[] args) {}

  private int[] iTwoSum(int[] numbers, int target) {
    int i = 0;
    int j = numbers.length - 1;
    while (i < numbers.length && j >= 0) {
      int sum = numbers[i] + numbers[j];
      if (sum == target) {
        return new int[] {i + 1, j + 1};
      } else if (sum > target) {
        j--;
      } else {
        i++;
      }
    }
    return new int[] {};
  }
}
