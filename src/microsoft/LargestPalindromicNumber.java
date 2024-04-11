package microsoft;

import java.util.*;
import java.util.stream.*;

public class LargestPalindromicNumber {

  public static void main(String[] args) {
    System.out.print(lpn("444947137"));
    // Algo steps
    // 1. Create counter with frequency of each digit.
    // 2. Iterate over the values in descending order (9->0)
    //    a) set the center digit with the largest value with digit with odd frequency.
    //    b) add the digit in pairs to create first half of palidrome.
    //    c) disregard any other center digit.
    // 3. Reverse the first half to create second half and add center digit to it based on even odd palindrome

    // Edge cases
    // 1. Check if the string contains only zeros
    // 2. Check if contains leading zeros and no other digits.
  }

  private static String lpn(String data) {

    // 1
    Map<Character, Integer> count = new HashMap<>();
    for (Character character : data.toCharArray()) {
      count.merge(character, 1, Integer::sum);
    }

    //E1
    if (count.get('0') != null && count.get('0') == data.length()) {
      return "0";
    }


    char middle = '\0';

    StringBuilder result = new StringBuilder();
    for (char i = '9'; i >= '0'; i--) {

      if (count.containsKey(i)) {
        Integer value = count.get(i);

        //E2
        if((result.isEmpty() && middle !=  '\0') && i == '0') {
          break;
        }

        // 2a
        if (value % 2 != 0 && middle == '\0') {
          middle = i;
        }

        // 2b
        int pairs = value / 2;
        while (pairs > 0) {
          result.append(i);
          pairs--;
        }

        // 2c - ignore
      }
    }

    //E2
    if(result.isEmpty() && middle ==  '\0') return "0";

    //3
    for (int k = result.length() - 1; k >= 0; k--) {
      result.append(result.charAt(k));
    }
    if (middle != '\0') {
      result.insert(result.length() / 2, middle);
    }

    return result.toString();
  }
}
