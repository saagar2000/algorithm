package neetcode.twopointers;

public class ContainerWithMostWater {

    public static void main(String[] args){
        int[] array = {1,8,6,2,5,4,8,3,7};
        int left = 0;
        int right = array.length - 1;
        int maxArea = 0;
        int value1 = 0;
        int value1Index = 0;
        int value2 = 0;
        int value2Index = 0;
        while(left < right) {
            if(array[left] > value1) {
                value1 = array[left];
                value1Index = left;
            }
            if(array[right] > value2) {
                value2 = array[right];
                value2Index = right;
            }
            int area = Math.min(value1, value2) * (value2Index - value1Index);
            maxArea = Math.max(maxArea, area);
            left++;
            right--;
        }
       System.out.println(maxArea);
    }
}
