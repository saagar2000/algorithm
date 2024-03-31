package grind75;

import java.util.*;

public class ValidParentheses {

    public static void main(String[] args){
        isValid("()");
    }

    public static boolean isValid(String s) {
        Deque<Character> chars = new ArrayDeque<>();
        Set<Character> opens = Set.of('(', '{', '[');
        Set<Character> closes = Set.of(')', '}', ']');
        Map<Character, Character> pairs = Map.ofEntries(Map.entry(')', '('), Map.entry('}', '{'), Map.entry(']', '['));
        for(int i=0; i < s.length(); i++) {
            if(opens.contains(s.charAt(i))) {
                chars.push(s.charAt(i));
                continue;
            }
            if(closes.contains(s.charAt(i))) {
                if(chars.isEmpty()) {
                    return false;
                }
                char actual = chars.pop();
                char expected = pairs.get(s.charAt(i));
                if(actual != expected) {
                    return false;
                }
            }

        }
        return chars.isEmpty();
    }
}
