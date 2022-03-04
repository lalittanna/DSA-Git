package com.company.Backtracking;

public class MatrixPath3 {
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

    /*

Given a `N × N` binary matrix, find the total number of unique paths that a robot can take to reach a given destination from a given source.

Positions in the matrix will either be open or blocked with an obstacle. The value 0 represents a blocked cell and 1 represents an open cell. The robot can only move to positions without obstacles, i.e., the solution should find paths that contain only open cells. Retracing the one or more cells back and forth is not considered a new path. The set of all cells covered in a single path should be unique from other paths. At any given moment, the robot can only move one step in either of the four directions (Top, Down, Left, Right).

Input:

matrix = [
	[1, 1, 1, 1],
	[1, 1, 0, 1],
	[0, 1, 0, 1],
	[1, 1, 1, 1]
]

src  = (0, 0)
dest = (3, 3)

Output: 4

Explanation: The above matrix contains 4 unique paths from source to destination (Marked with x).

[x  x  x  x]	[x  x  1  1]	[x  1  1  1]	[x  x  x  x]
[1  1  0  x]	[1  x  0  1]	[x  x  0  1]	[x  x  0  x]
[0  1  0  x]	[0  x  0  1]	[0  x  0  1]	[0  1  0  x]
[1  1  1  x]	[1  x  x  x]	[1  x  x  x]	[1  1  1  x]

*/

    /* The Pair<U, V> class have
		1. Two member variables, first and second.
		2. Factory method `Pair.of(U, V)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/
    public static int countPaths(int[][] mat, Pair<Integer, Integer> src, Pair<Integer, Integer> dest){
        if (mat == null || mat.length == 0 || mat[src.first][src.second] == 0 || mat[dest.first][dest.second] == 0)
            return 0;

        boolean[][] visited = new boolean[mat.length][mat[0].length];

        return paths(mat, visited, src.first, src.second, dest.first, dest.second);
    }

    public static int paths(int[][] mat, boolean[][] visited, int i, int j, int x, int y){
        if (i == x && j == y) return 1;

        int countSoFar = 0;

        visited[i][j] = true;

        if (mat[i][j] == 1) {
            if (isSafe(mat, visited, i + mat[i][j], j))
                countSoFar += paths(mat, visited, i + mat[i][j], j, x, y);
            if (isSafe(mat, visited, i - mat[i][j], j))
                countSoFar += paths(mat, visited, i - mat[i][j], j, x, y);
            if (isSafe(mat, visited, i, j + mat[i][j]))
                countSoFar += paths(mat, visited, i, j + mat[i][j], x, y);
            if (isSafe(mat, visited, i, j - mat[i][j]))
                countSoFar += paths(mat, visited, i, j - mat[i][j], x, y);
        }

        visited[i][j] = false;

        return countSoFar;
    }

    public static boolean isSafe(int[][] mat, boolean[][] visited, int i, int j){
        return (i >= 0 && i < mat.length && j >= 0 && j < mat[i].length && !visited[i][j]);
    }
}
