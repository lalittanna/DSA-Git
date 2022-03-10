package com.company.Backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NQueenProblem {
    /*

    The N–queens puzzle is the problem of placing `N` chess queens on an `N × N` chessboard so that no two queens threaten each other. Thus, the solution requires that no two queens share the same row, column, or diagonal.

    The solution should return a Set of the string representation of each possible solution to the N–Queens problem.

    Input: N = 4
    Output:
    {
        '[[0, 0, 1, 0], [1, 0, 0, 0], [0, 0, 0, 1], [0, 1, 0, 0]]',
        '[[0, 1, 0, 0], [0, 0, 0, 1], [1, 0, 0, 0], [0, 0, 1, 0]]'
    }

    Here 1 represents the position of a queen in chessboard. Note that the solution exists for all natural numbers, except for 2 and 3. The solution should return an empty set for N = 2 and N = 3.

    Input: N = 2
    Output: {}

    Note: To get the string representation of a N–Queen's problem solution stored in int[][] or List<List<Integer>>, you can call `Arrays.deepToString()` or `toString()` method, respectively.

    */
    public static Set<String> solveNQueen(int n){
        Set<String> result = new HashSet<>();

        if (n > 0 && n != 2 && n != 3) solveNQueen(result, new int[n][n], 0);

        return result;
    }

    public static void solveNQueen(Set<String> result, int[][] board, int n){
        if (n == board.length){
            result.add(Arrays.deepToString(board));
            return;
        }

        for (int i = 0; i < board.length; i++){
            if (isSafe(board, n, i)){
                board[n][i] = 1;

                solveNQueen(result, board, n + 1);

                board[n][i] = 0;
            }
        }
    }

    public static boolean isSafe(int[][] board, int r, int c){
        for (int i = 0; i < r; i++) if (board[i][c] == 1) return false;

        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;

        for (int i = r, j = c; i >= 0 && j < board[i].length; i--, j++)
            if (board[i][j] == 1) return false;

        return true;
    }
}
