package com.company.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatrixPath {
    /*

    Given an `M × N` integer matrix, return all paths that start at the first cell (0, 0) and ends at the last cell (M-1, N-1). You are allowed to move down, right, or diagonally (down-right), but not up or left.

    Input:
    [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]

    Output:

    {
        [1, 4, 7, 8, 9],
        [1, 4, 5, 8, 9],
        [1, 4, 5, 6, 9],
        [1, 4, 5, 9],
        [1, 4, 8, 9],
        [1, 2, 5, 8, 9],
        [1, 2, 5, 6, 9],
        [1, 2, 5, 9],
        [1, 2, 3, 6, 9],
        [1, 2, 6, 9],
        [1, 5, 8, 9],
        [1, 5, 6, 9],
        [1, 5, 9]
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
        } else {
            if (i + 1 < mat.length) allPaths(paths, mat, list, i + 1, j);
            if (j + 1 < mat[i].length) allPaths(paths, mat, list, i, j + 1);
            if (i + 1 < mat.length && j + 1 < mat[i].length) allPaths(paths, mat, list, i + 1, j + 1);
        }

        list.remove(list.size() - 1);
    }
}
