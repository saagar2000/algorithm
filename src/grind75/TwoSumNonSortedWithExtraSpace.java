package grind75;

import java.util.*;

public class TwoSumNonSortedWithExtraSpace {

    public static void main(String[] args){

    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> values = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            int value = nums[i];
            int other = target - value;
            if(values.containsKey(other)) {
                return new int[]{i, values.get(other)};
            } else {
                values.put(value, i);
            }
        }
        return null;
    }
}

