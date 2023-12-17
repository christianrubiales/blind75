package _01arraysAndHashing;

/**
 * Determine if a 9 x 9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * board[i][j] is a digit 1-9 or '.'.
 */
public class ValidSudoku {

    /**
     * Just be careful (ex: indexes)
     */
    public static boolean isValidSudoku(char[][] board) {
        // check rows
        for (int i = 0; i < 9; i++) {
            char[] row = board[i];
            boolean[] bitset = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (row[j] != '.') {
                    if (!bitset[row[j] - '0']) {
                        bitset[row[j] - '0'] = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        // check columns
        for (int i = 0; i < 9; i++) {
            boolean[] bitset = new boolean[10];
            for (int j = 0; j < 9; j++) {
                char cell = board[j][i];
                if (cell != '.') {
                    if (!bitset[cell - '0']) {
                        bitset[cell - '0'] = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        // check sub-boxes
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

            }
        }

        return true;
    }
    
    public static void main(String[] args) {
    }
}
