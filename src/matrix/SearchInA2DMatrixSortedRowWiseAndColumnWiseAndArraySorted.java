package matrix;

public class SearchInA2DMatrixSortedRowWiseAndColumnWiseAndArraySorted {

  public static void main(String[] args) {
    int[][] grid = {{1, 3, 5, 7}, {8, 9, 20, 30}, {35, 40, 41, 56}};
    int target = 40;
    System.out.println(binarySearchEntireArray(grid, target));
  }

  private static boolean binarySearchEntireArray(int[][] grid, int target) {
    int row = grid.length;
    int col = grid[0].length - 1;
    int l = 0;
    int r = row - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (target >= grid[r][0] && target < grid[r][col]) {
        return searchElement(grid[r], target);
      } else if (target < grid[r][0]) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return false;
  }

  private static boolean searchElement(int[] grid, int target) {
    int l = 0;
    int r = grid.length - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (target == grid[mid]) {
        return true;
      } else if (target > grid[mid]) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return false;
  }
}
