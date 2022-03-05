package com.company.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatrixPath4 {
    /*

    Given an `M × N` integer matrix, find all paths from the first cell to the last cell. You are only allowed to move down or to the right from the current cell.

    Input:

    [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]

    Output:

    {
        [1, 2, 3, 6, 9],
        [1, 2, 5, 6, 9],
        [1, 2, 5, 8, 9],
        [1, 4, 5, 6, 9],
        [1, 4, 5, 8, 9],
        [1, 4, 7, 8, 9]
    }

    */
    public static Set<List<Integer>> findAllPaths(int[][] mat){
        Set<List<Integer>> paths = new HashSet<>();

        if (mat == null || mat.length == 0 || mat[0].length == 0) return paths;

        allPaths(paths, mat, new ArrayList<>(), 0, 0);

        return paths;
    }

    public static void allPaths(Set<List<Integer>> paths, int[][] mat, List<Integer> list, int i, int j){
        list.add(mat[i][j]);

        if (i == mat.length - 1 && j == mat[i].length - 1){
            List<Integer> path = new ArrayList<>(list);
            paths.add(path);
            list.remove(list.size() - 1);
            return;
        }

        if (isSafe(mat, i + 1, j)) allPaths(paths, mat, list, i + 1, j);
        if (isSafe(mat, i, j + 1)) allPaths(paths, mat, list, i, j + 1);

        list.remove(list.size() - 1);
    }

    public static boolean isSafe(int[][] mat, int i, int j){
        return (i >= 0 && i < mat.length && j >= 0 && j < mat[i].length);
    }
}
