package com.company.Backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KnightTourProblem {
    /*

    Given a chessboard, return all sequences of moves of a knight on a chessboard such that the knight visits every square only once.

    • The solution should start the tour from the top-leftmost of the board, mark it as 1, and use the next numbers to represent the knight's consecutive moves.
    • The solution should return a Set of the string representation of each possible solution.

    Input: N = 5

    Output:

    {
        '[[1, 18, 7, 12, 25], [8, 13, 2, 19, 6], [3, 20, 17, 24, 11], [14, 9, 22, 5, 16], [21, 4, 15, 10, 23]]',
        '[[1, 10, 21, 16, 7], [20, 15, 8, 11, 22], [9, 2, 23, 6, 17], [14, 19, 4, 25, 12], [3, 24, 13, 18, 5]]',
        '[[1, 18, 13, 8, 3], [12, 7, 2, 21, 14], [17, 22, 19, 4, 9], [6, 11, 24, 15, 20], [23, 16, 5, 10, 25]]',
        '[[1, 18, 13, 8, 21], [12, 7, 20, 3, 14], [19, 2, 17, 22, 9], [6, 11, 24, 15, 4], [25, 16, 5, 10, 23]]'

        ...and 300 more tours.
    }

    Note: To get the string representation of a knight tour stored in int[][] or List<List<Integer>>, you can call `Arrays.deepToString()` or `toString()` method, respectively.

    */
    public static final int[] row = { 2, 1, -1, -2, -2, -1, 1, 2, 2 };
    public static final int[] col = { 1, 2, 2, 1, -1, -2, -2, -1, 1 };

    public static Set<String> knightTours(int n){
        Set<String> result = new HashSet<>();

        tours(result, new int[n][n], 0, 0, 1);

        return result;
    }

    public static void tours(Set<String> result, int[][] board, int i, int j, int r){
        board[i][j] = r;

        if (r >= board.length * board.length){
            result.add(Arrays.deepToString(board));
            board[i][j] = 0;
            return;
        }

        for (int k = 0; k < 8; k++)
            if (isSafe(board, i + row[k], j + col[k]))
                tours(result, board, i + row[k], j + col[k], r + 1);


        // if (isSafe(board, i - 2, j - 1)) tours(result, board, i - 2, j - 1, r + 1);

        // if (isSafe(board, i - 2, j + 1)) tours(result, board, i - 2, j + 1, r + 1);

        // if (isSafe(board, i + 2, j - 1)) tours(result, board, i + 2, j - 1, r + 1);

        // if (isSafe(board, i + 2, j + 1)) tours(result, board, i + 2, j + 1, r + 1);

        // if (isSafe(board, i - 1, j - 2)) tours(result, board, i - 1, j - 2, r + 1);

        // if (isSafe(board, i + 1, j - 2)) tours(result, board, i + 1, j - 2, r + 1);

        // if (isSafe(board, i - 1, j + 2)) tours(result, board, i - 1, j + 2, r + 1);

        // if (isSafe(board, i + 1, j + 2)) tours(result, board, i + 1, j + 2, r + 1);

        board[i][j] = 0;
    }

    public static boolean isSafe(int[][] board, int i, int j){
        if (i >= 0 && j >= 0 && i < board.length && j < board[i].length && board[i][j] == 0) return true;
        return false;
    }
}
