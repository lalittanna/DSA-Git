package com.company.Backtracking;

import com.company.Array.ClosestPair;

public class ShortestPathMaze {

    /* The Pair<U, V> class have
		1. Two member variables, first and second.
		2. Factory method `Pair.of(U, V)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/

    /*

Given a maze in the form of a binary rectangular matrix, find the length of the shortest path from a given source to a given destination. The path can only be constructed out of cells having value 1, and at any moment, you can only move one step in one of the four directions (Top, Left, Down, Right).

Input:

matrix = [
	[1, 1, 1, 1, 1, 0, 0, 1, 1, 1],
	[0, 0, 1, 0, 1, 1, 0, 1, 0, 1],
	[0, 0, 1, 0, 1, 1, 1, 0, 0, 1],
	[1, 0, 1, 1, 1, 0, 1, 1, 0, 1],
	[0, 0, 0, 1, 0, 0, 0, 1, 0, 1],
	[1, 0, 1, 1, 1, 0, 0, 1, 1, 0],
	[0, 0, 0, 0, 1, 0, 0, 1, 0, 1],
	[0, 1, 1, 1, 1, 1, 1, 1, 0, 0],
	[1, 1, 1, 1, 1, 0, 0, 1, 1, 1],
	[0, 0, 1, 0, 0, 1, 1, 0, 0, 1]
]
src  = (0, 0)
dest = (5, 7)

Output: 12

Explanation: The shortest path from (0, 0) to (5, 7) has length 12. The shortest path is marked below with x.

[
	[x, x, x, x, x, 0, 0, 1, 1, 1],
	[0, 0, 1, 0, x, 1, 0, 1, 0, 1],
	[0, 0, 1, 0, x, x, x, 0, 0, 1],
	[1, 0, 1, 1, 1, 0, x, x, 0, 1],
	[0, 0, 0, 1, 0, 0, 0, x, 0, 1],
	[1, 0, 1, 1, 1, 0, 0, x, 1, 0],
	[0, 0, 0, 0, 1, 0, 0, 1, 0, 1],
	[0, 1, 1, 1, 1, 1, 1, 1, 0, 0],
	[1, 1, 1, 1, 1, 0, 0, 1, 1, 1],
	[0, 0, 1, 0, 0, 1, 1, 0, 0, 1]
]

Note: The solution should return -1 if no path is possible.

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
    public static int findShortestPath(int[][] mat, Pair<Integer, Integer> src, Pair<Integer, Integer> dest){
        if (mat == null || mat.length == 0 || mat[src.first][src.second] == 0 || mat[dest.first][dest.second] == 0)
            return -1;

        boolean[][] visited = new boolean[mat.length][mat[0].length];

        int minDist = recur(mat, visited, src.first, src.second, dest.first, dest.second, Integer.MAX_VALUE, 0);

        return (minDist == Integer.MAX_VALUE) ? -1 : minDist;
    }

    public static int recur(int[][] mat, boolean[][] visited, int i, int j, int x, int y, int minDist, int dist){
        if (i == x && j == y) return Integer.min(minDist, dist);

        visited[i][j] = true;

        if(isSafe(mat, visited, i + 1, j))
            minDist = recur(mat, visited, i + 1, j, x, y, minDist, dist + 1);

        if(isSafe(mat, visited, i - 1, j))
            minDist = recur(mat, visited, i - 1, j, x, y, minDist, dist + 1);

        if(isSafe(mat, visited, i, j + 1))
            minDist = recur(mat, visited, i, j + 1, x, y, minDist, dist + 1);

        if(isSafe(mat, visited, i, j - 1))
            minDist = recur(mat, visited, i, j - 1, x, y, minDist, dist + 1);

        visited[i][j] = false;

        return minDist;
    }

    public static boolean isSafe(int[][] mat, boolean[][] visited, int i, int j){
        return (i >= 0 && i < mat.length && j >= 0 && j < mat[i].length && mat[i][j] == 1 && !visited[i][j]);
    }
}
