package matrix;

public class SearchInA2DMatrixNLogM {
    public static void main(String[] args){
        int[][] grid = {{1, 2, 3}, {15, 16, 17}, {12, 14, 18}};
        int row = 3;
        int col = 3;
        int key = 16;
        for(int i=0; i< row; i++){
            int left = 0;
            int right = col - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(grid[i][mid] == key)
                    System.out.println(true);
                if(grid[0][mid] > key) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
    }
}
