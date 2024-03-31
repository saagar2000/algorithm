package matrix;

public class RotateMatrixBy90DegreesN2 {
  public static void main(String[] args) {
    int[][] grid = {{1, 2, 3}, {15, 16, 17}, {12, 14, 18}, {2, 7, 9}};
    int row = 3;
    int col = 3;
    int[][] output = new int[3][3];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int in = grid[i][j];
        output[row - 1 - j][i] = in;
      }
    }
    System.out.println(output);
  }
}
