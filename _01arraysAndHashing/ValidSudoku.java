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
 * https://leetcode.com/problems/valid-sudoku
 * https://algo.monster/liteproblems/36
 */
public class ValidSudoku {

    /**
     * Just be careful (ex: indexes)
     * The only special thing here is the use of boolean array as bitset instead of Set
     * Create the bitset once, initialize before use.
     * O(1) time, (from algomonster) does not scale with input size
     * O(1) space, (from algomonster) does not scale with input size
     */
    public static boolean isValidSudoku(char[][] board) {
        boolean[] bitset = new boolean[10];
        
        // check rows
        for (int i = 0; i < 9; i++) {
            char[] row = board[i];
            for (int x = 0; x < 10; x++) bitset[x] = false;
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
            for (int x = 0; x < 10; x++) bitset[x] = false;
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
                for (int x = 0; x < 10; x++) bitset[x] = false;
                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < 3; b++) {
                        char cell = board[i*3+a][j*3+b];
                        if (cell != '.') {
                            if (!bitset[cell - '0']) {
                                bitset[cell - '0'] = true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
    }
}
