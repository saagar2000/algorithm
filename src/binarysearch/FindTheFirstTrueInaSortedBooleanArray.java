package binarysearch;

public class FindTheFirstTrueInaSortedBooleanArray {
    public static void main(String[] args){

        boolean[] val = {false, false, true, true};

        int left = 0;
        int right = val.length - 1;

        while(left < right) {
            int mid = left + (right - left) /2;
            if(val[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}
