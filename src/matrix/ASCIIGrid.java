package matrix;

public class ASCIIGrid {
  // Write a program, in any language, that will display an ASCII chart given the following data
  // data = {(1,2), (2, 3), (3, 1), (4, 6), (5, 8)}.
  // You should be able to print the surrounding components of the chart and then place an * where
  // each data point is specified in the data set. You do not need to print the X and Y legends but
  // that would be helpful. You are given the max x and max y but if you can calculate that it would
  // be helpful.

  //  Online auction graph display
  //  x axis is time
  //  y axis is price
  //  Title item
  //
  //  Given a two-dimension array graph the price over time
  //     0     1     2     3     4     5     6
  //   0 +-----+-----+-----+-----+-----+-----+ 9
  //   1 +                             *     + 8
  //   2 +                                   + 7
  //   3 +                       *           + 6
  // $ 4 +                                   + 5
  //   5 +                                   + 4
  //   6 +           *                       + 3
  //   7 +     *                             + 2
  //   8 +                 *                 + 1
  //   9 +-----+-----+-----+-----+-----+-----+ 0
  // .   0.    1.    2.    3.    4.    5.    6
  //                time
  //
  //   max x = 5
  //   max y = 8
  //   data = {(1,2), (2, 3), (3, 1), (4, 6), (5, 8)} //

  public static void main(String[] args) {
    int[][] data = {{1, 2}, {2, 3}, {3, 1}, {4, 6}, {5, 8}};
    int column = findMaxInColumn(0, data);
    int row = findMaxInColumn(1, data);
    // {{1, 7}, {2, 6}, {3, 8}, {4, 3}, {5, 1}};
    for (int i = 0; i <= row; i++) {
      System.out.print("+");
      for (int j = 0; j <= column; j++) {
        if (i == 0 || i == row) {
          if (j != 0 && j != column) {
            System.out.print("+");
          }
          if (j != column) {
            System.out.print("-----");
          }
        } else {
          if (existsValue(i, j, data, row)) {
            System.out.print('*');
          } else {
            if (j != 0 && j != column) {
              System.out.print(" ");
            }
          }
          if (j != column) {
            System.out.print("     ");
          }
        }
      }
      System.out.print("+");
      System.out.println();
    }
  }

  private static int findMaxInColumn(int colIndex, int[][] data) {
    int max = Integer.MIN_VALUE;
    for (int[] datum : data) {
      int value = datum[colIndex];
      max = Math.max(max, value);
    }
    return max + 1;
  }

  private static boolean existsValue(int row, int column, int[][] data, int length) {
    for (int[] datum : data) {
      int dcolumn = datum[0];
      int drow = datum[1];
      if (dcolumn == column && row == length - drow) {
        return true;
      }
    }
    return false;
  }
}
