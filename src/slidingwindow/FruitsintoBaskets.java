package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitsintoBaskets {
    public static void main(String[] args){
        char[] fruits = {'A', 'B', 'C', 'B', 'B', 'C'};
        Map<Character, Integer> fruitTypes = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int left = 0;

        for(int right = 0; right < fruits.length; right++) {
            fruitTypes.merge(fruits[right], 1, Integer::sum);
            while(fruitTypes.size() > 2) {
                fruitTypes.merge(fruits[left], -1, Integer::sum);
                if(fruitTypes.get(fruits[left]) == 0)
                    fruitTypes.remove(fruits[left]);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        System.out.println(max);
    }
}
