package grind75;

public class TwoSumSortedArray {

    public static void main(String[] args){

    }
    public int[] twoSum(int[] nums, int target) {
       int i =0;
       int j = nums.length - 1;
       while(i < j) {
           int first = nums[i];
           int second = nums[j];
           int actual = first + second;
           if(actual > target) {
               j--;
           } else if(actual < target) {
               i++;
           } else {
               return new int[] {i, j};
           }
       }
       return null;
    }
}

