package amazon;

import java.util.*;

public class LengthOfTheLongestValidSubstring {
	public static void main(String[] args) {

		String word = "cbaaaabc";
		List<String> forbidden = List.of("aaa","cb");
		int left = 0;
		int right = 0;
		int max = Integer.MIN_VALUE;
		while (right < word.length()) {
            right++;
			String substring = word.substring(left, right);
			System.out.println(substring);
			while(forbidden.contains(substring)) {
                System.out.println(true + " -- " + substring);
                left = left + 1;
				substring = word.substring(left, right);
			}
          int count = right - left;
          System.out.println(count + "--" + left + "--" + right);
          max = Math.max(count, max);
		}
		System.out.println(max);
	}

}
