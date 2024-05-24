package grind75;

public class ValidPalindrome {

  public static void main(String[] args) {
    String s = "lcupucul";
    System.out.println(isValidPalindrome(s));
  }

  private static boolean isValidPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      char leftChar = s.charAt(left);
      char rightChar = s.charAt(right);
      if (leftChar != rightChar) {
        return isPalindrome(s, ++left, right) || isPalindrome(s, left, --right);
      }
    }
    return true;
  }

  private static boolean isPalindrome(String s, int left, int right) {
    for (int i = left, j = right; i < j; i++, j--) {
      char leftChar = s.charAt(i);
      char rightChar = s.charAt(j);
      if (leftChar != rightChar) {
        return false;
      }
    }
    return true;
  }
}
