package matrix;

public class FindRowWithMaximumNumberOf1sNM {
  public static void main(String[] args) {
    int[][] grid = {{1, 1, 1}, {0, 1, 1}, {1, 0, 1}};
      int row = 3;
      int col = 3;
      int maxOneCount = 0;
      int maxRowIndex = -1;
      for(int i = 0; i < row; i++) {
          int rowOneCount = 0;
          for(int j = 0; j < col; j++) {
            if(grid[i][j] == 1){
                rowOneCount++;
            }
          }
          if(rowOneCount > maxOneCount) {
              maxOneCount = rowOneCount;
              maxRowIndex = i;
          }
      }
      System.out.println(maxRowIndex);
  }
}
