package matrix;

public class RotateMatrixBy90DegreesTranspose {
  public static void main(String[] args) {
    int[][] grid = {{1, 2, 3}, {15, 16, 17}, {12, 14, 18}};
    //{1, 2, 3}
    //{15, 16, 17}
    //{12, 14, 18}
    int row = 3;
    int col = 3;
    for (int i = 0; i < row; i++) {
      for (int j = i; j < col; j++) {
        int rowcol = grid[i][j];
        int colrow = grid[j][i];
        grid[j][i] = rowcol;
        grid[i][j] = colrow;
      }
    }
    for (int i = 0; i < row; i++) {
      for (int j = i; j < col; j++) {
        int rowcol = grid[i][j];
        int colrow = grid[j][i];
        grid[j][i] = rowcol;
        grid[i][j] = colrow;
      }
    }
    System.out.println(grid);
  }
}
