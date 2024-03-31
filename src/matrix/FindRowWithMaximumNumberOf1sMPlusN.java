package matrix;

public class FindRowWithMaximumNumberOf1sMPlusN {
    public static void main(String[] args){
        int[][] grid = {{0, 0, 1}, {0, 1, 1}, {0, 0, 1}};
        int row = 3;
        int col = 2;
        int maxRowIndex = -1;
        for(int i=0; i < row; i++) {

            while(col >= 0 && grid[i][col] == 1) {
                col = col - 1;
                maxRowIndex = i;
            }
        }
        System.out.println(maxRowIndex);
    }
}
