package neetcode.arrays;

import java.util.*;

public class ValidSudoku {
  public static void main(String[] args) {
    String[][] board = {
      {"5", "3", ".", ".", "7", ".", ".", ".", "."},
      {"6", ".", ".", "1", "9", "5", ".", ".", "."},
      {".", "9", "8", ".", ".", ".", ".", "6", "."},
      {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
      {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
      {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
      {".", "6", ".", ".", ".", ".", "2", "8", "."},
      {".", ".", ".", "4", "1", "9", ".", ".", "5"},
      {".", ".", ".", ".", "8", ".", ".", "7", "9"}
    };
    System.out.println(isValidSudoku(board));
  }

  private static boolean isValidSudoku(String[][] board) {
    Map<Map.Entry<Integer, Integer>, Map<String, Boolean>> gridCheck = new HashMap<>();
    Map<Integer, Map<String, Boolean>> columCheck = new HashMap<>();
    Map<Integer, Map<String, Boolean>> rowCheck = new HashMap<>();

    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        if (board[r][c].equals(".")) continue;
        Map.Entry<Integer, Integer> grid = Map.entry(r / 3, c / 3);
        if (gridCheck.containsKey(grid) && gridCheck.get(grid).containsKey(board[r][c])) {
          return false;
        } else {
          gridCheck.computeIfAbsent(grid, key -> new HashMap<>()).put(board[r][c], true);
        }
        if (columCheck.containsKey(c) && columCheck.get(c).containsKey(board[r][c])) {
          return false;
        } else {
          columCheck.computeIfAbsent(c, key -> new HashMap<>()).put(board[r][c], true);
        }
        if (rowCheck.containsKey(r) && rowCheck.get(r).containsKey(board[r][c])) {
          return false;
        } else {
          rowCheck.computeIfAbsent(r, key -> new HashMap<>()).put(board[r][c], true);
        }
      }
    }
    return true;
  }
}
