package matrix;

public class SearchInA2DMatrixSortedRowWiseAndColumnWiseAndArrayNotSorted {

  public static void main(String[] args) {
    int[][] grid = {{1, 3, 5, 7}, {1, 3, 7, 9}, {3, 4, 9, 11}};
    int target = 4;
    System.out.println(linearSearchAtBottomLeft(grid, target));
  }

  private static boolean bruteForceOmn(int[][] grid, int target) {
    int row = grid.length;
    int column = grid[0].length;

    int r = 0;
    while (r < row) {
      for (int c = 0; c < column; c++) {
        if (grid[r][c] == target) {
          return true;
        }
      }
      r++;
    }
    return false;
  }

  private static boolean rowBasedBinarySearch(int[][] grid, int target) {
    int row = grid.length;
    int r = 0;
    while (r < row) { //mlogn
      int[] values = grid[r];
      int left = 0;
      int right = values.length - 1;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (target == values[mid]) return true;
        else if (target > values[mid]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      r++;
    }
    return false;
  }

  private static boolean columnBasedBinarySearch(int[][] grid, int target) {
    int row = grid.length;
    int col = grid[0].length;

    int c = 0;
    while (c < col) { //n * (m + logn)
      int[] values = new int[col];
      for (int r = 0; r < row; r++) {
        values[r] = grid[r][c];
      }
      int left = 0;
      int right = values.length - 1;

      while(left <= right) {
        int mid = left + (right - left)/2;
        if(target == values[mid]) {
          return true;
        } else if(target > values[mid]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      c++;
    }
    return false;
  }

  private static boolean linearSearchAtTopRight(int[][] grid, int target) {
    int row = grid.length;
    int c = grid[0].length - 1;
    int r = 0;
    while(r < row && c >=0) {
      int value = grid[r][c];
      if(target == value)
        return true;
      else if(target > value) {
        r++;
      } else {
        c--;
      }
    }
    return false;
  }

  private static boolean linearSearchAtBottomLeft(int[][] grid, int target) {
    int row = grid.length - 1;
    int col = grid[0].length;
    int c = 0;
    while(row >=0 && c < col) {
      int value = grid[row][c];
      if(target == value) {
        return true;
      } else if( target > value) {
        c++;
      } else {
        row--;
      }
    }
    return false;
  }

}
