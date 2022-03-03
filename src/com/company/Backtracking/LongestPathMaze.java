package com.company.Backtracking;

public class LongestPathMaze {
    /*

    Given a rectangular path in the form of a binary matrix, find the length of the longest possible route from source to destination by moving to only non-zero adjacent positions, i.e., A route can be formed from positions having their value as 1. Note there should not be any cycles in the output path.

    Input:

    matrix = [
        [1, 0, 1, 1, 1, 1, 0, 1, 1, 1],
        [1, 0, 1, 0, 1, 1, 1, 0, 1, 1],
        [1, 1, 1, 0, 1, 1, 0, 1, 0, 1],
        [0, 0, 0, 0, 1, 0, 0, 1, 0, 0],
        [1, 0, 0, 0, 1, 1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1, 1, 1, 1, 1, 0],
        [1, 0, 0, 0, 1, 0, 0, 1, 0, 1],
        [1, 0, 1, 1, 1, 1, 0, 0, 1, 1],
        [1, 1, 0, 0, 1, 0, 0, 0, 0, 1],
        [1, 0, 1, 1, 1, 1, 0, 1, 0, 0]
    ]
    src  = (0, 0)
    dest = (5, 7)
    Output: 22

    Explanation: The longest path is:

    (0, 0) —> (1, 0) —> (2, 0) —> (2, 1) —> (2, 2) —> (1, 2) —> (0, 2) —> (0, 3) —> (0, 4) —> (1, 4) —> (1, 5) —> (2, 5) —> (2, 4) —> (3, 4) —> (4, 4) —> (5, 4) —> (5, 5) —> (5, 6) —> (4, 6) —> (4, 7) —> (4, 8) —> (5, 8) —> (5, 7)

    Note: The solution should return 0 if no path is possible.

    */

    private class Pair<U, V>{
        public Integer first;
        public Integer second;
        public Pair(Integer first, Integer second){
            this.first = first;
            this.second = second;
        }
        public static Pair of(int first, int second){
            //Pair<Integer, Integer> pair = new Pair<>(first, second);
            return null;
        }
    }
    /* The Pair<U, V> class have
		1. Two member variables, first and second.
		2. Factory method `Pair.of(U, V)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/

    public static int findLongestPath(int[][] mat, Pair<Integer, Integer> src, Pair<Integer, Integer> dest){
        if (mat == null || mat.length == 0 || mat[src.first][src.second] == 0 || mat[dest.first][dest.second] == 0)
            return 0;

        boolean[][] visited = new boolean[mat.length][mat[0].length];

        return recur(mat, visited, src.first, src.second, dest.first, dest.second, Integer.MIN_VALUE, 0);
    }

    public static int recur(int[][] mat, boolean[][] visited, int i, int j, int x, int y, int maxDist, int dist){
        if (i == x && j == y) return Integer.max(maxDist, dist);

        visited[i][j] = true;

        if (isSafe(mat, visited, i + 1, j)) maxDist = recur(mat, visited, i + 1, j, x, y, maxDist, dist + 1);
        if (isSafe(mat, visited, i - 1, j)) maxDist = recur(mat, visited, i - 1, j, x, y, maxDist, dist + 1);
        if (isSafe(mat, visited, i, j + 1)) maxDist = recur(mat, visited, i, j + 1, x, y, maxDist, dist + 1);
        if (isSafe(mat, visited, i, j - 1)) maxDist = recur(mat, visited, i, j - 1, x, y, maxDist, dist + 1);

        visited[i][j] = false;

        return maxDist;
    }

    public static boolean isSafe(int[][] mat, boolean[][] visited, int i, int j){
        return (i >= 0 && i < mat.length && j >= 0 && j < mat[i].length && mat[i][j] == 1 && !visited[i][j]);
    }
}
