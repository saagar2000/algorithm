package grind75;

public class ValidPalindrome {

    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isValidPalindrome(s));
    }

    private static boolean isValidPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            char leftChar = s.charAt(left);
            boolean isLeftCharLetterOrDigit = Character.isLetterOrDigit(leftChar);
            if(!isLeftCharLetterOrDigit) left++;
            char rightChar = s.charAt(right);
            boolean isRightCharLetterOrDigit = Character.isLetterOrDigit(rightChar);
            if(!isRightCharLetterOrDigit) right--;
            if(isLeftCharLetterOrDigit && isRightCharLetterOrDigit) {
                if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
