package twopointers;

public class MoveAllZerosToEndOfArray {
  public static void main(String[] args) {
    int[] input = {0, 1, 0, 0, 0, 2, 0, 1 ,1};
    int left = 0;
    int right = 0;

    while (right < input.length) {
      int value = input[right];
      if (value != 0) {
        input[left] = input[right];
        left++;
      }
      right++;
    }

    System.out.println(input);
  }
}
