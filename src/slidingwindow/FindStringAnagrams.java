package slidingwindow;

public class FindStringAnagrams {
    public static void main(String[] args){
        String pattern = "abc";
        String input = "abbcabc";
        int right = 0;
        int left = 0;
        int[] pCount = new int[26];
        int i = 0;
        while(i < pattern.length()) {
            char c = pattern.charAt(i);
            pCount[c - 'a']++;
        }
        while(right < input.length())  {

            right++;
        }
    }
}
