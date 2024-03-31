package matrix;

public class PrintAGivenMatrixInSpiralForm {

  public static void main(String[] args) {
    int[][] grid = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    iterativeVersion(grid);
  }

  private static void iterativeVersion(int[][] grid) {
    int rowEnd = grid.length;
    int colEnd = grid[0].length;

    int rowStart = 0;
    int colStart = 0;
    while (rowStart < rowEnd && colStart < colEnd) {
      for (int i = colStart; i < colEnd; i++) {
        System.out.println(grid[rowStart][i]);
      }
      for (int i = rowStart + 1; i < rowEnd - 1; i++) {
        System.out.println(grid[i][colEnd - 1]);
      }
      for (int i = colEnd - 1; i > colStart; i--) {
        System.out.println(grid[rowEnd - 1][i]);
      }
      for (int i = rowEnd - 1; i > rowStart; i--) {
        System.out.println(grid[i][colStart]);
      }
      rowStart = rowStart + 1;
      colStart = colStart + 1;
      colEnd = colEnd - 1;
      rowEnd = rowEnd - 1;
    }
  }
}
