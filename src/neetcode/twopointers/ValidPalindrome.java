package neetcode.twopointers;

public class ValidPalindrome {

  public static void main(String[] args) {
    System.out.println(isPalindrome("B man, a plan, a canal: Panama"));
  }

  private static boolean isPalindrome(String word) {
    int i = 0;
    int j = word.length() - 1;
    while (i < word.length() && j >= 0) {
      char start = word.charAt(i);
      char end = word.charAt(j);
      if (!Character.isLetterOrDigit(start)) {
        i++;
      } else if (!Character.isLetterOrDigit(end)) {
        j--;
      } else {
        if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
          return false;
        } else {
          j--;
          i++;
        }
      }
    }
    return true;
  }
}
