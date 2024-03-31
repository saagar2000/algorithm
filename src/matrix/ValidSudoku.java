package matrix;

import java.util.HashSet;

public class ValidSudoku {

  public static void main(String[] args) {
    char[][] board = {
      {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
      {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    System.out.println(validSudoku(board));
  }

  private static boolean validSudoku(char[][] board) {
    int N = 9;

    HashSet<Character>[] rows = new HashSet[N];
    HashSet<Character>[] columns = new HashSet[N];
    HashSet<Character>[] boxes = new HashSet[N];

    for (int n = 0; n < N; n++) {
      rows[n] = new HashSet<>();
      columns[n] = new HashSet<>();
      boxes[n] = new HashSet<>();
    }
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        char val = board[r][c];

        if (val == '.') {
          continue;
        }
        if (rows[r].contains(val)) {
          return false;
        }
        rows[r].add(val);
        if (columns[c].contains(val)) {
          return false;
        }
        columns[c].add(val);
        int idx = (r/3) * 3 + c/3; // 0 * 3 + 0  = 3 // 1 * 3 + 1
      }
    }
    return false;
  }
}
