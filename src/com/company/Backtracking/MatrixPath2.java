package com.company.Backtracking;

import java.util.ArrayList;
import java.util.List;

class Node<I extends Number, I1 extends Number> {
    int first, second;

    public Node(int first, int second)
    {
        this.first = first;
        this.second = second;
    }

    public static Node<Integer, Integer> of(int i, int j) {
        return new Node<>(i, j);
    }

    @Override
    public boolean equals(Object ob)
    {
        Node<Number, Number> node = (Node<Number, Number>) ob;
        return (first == node.first && second == node.second);
    }

    @Override
    public int hashCode() {
        return 31 * first + second;
    }

    @Override
    public String toString() {
        return "(" + this.first + ", " + this.second + ")";
    }
}

public class MatrixPath2 {
    /*

Given an `N × N` matrix of positive integers, find a path from the first cell of the matrix to its last.

You are allowed to move exactly `k` steps from any cell in the matrix where `k` is the cell's value, i.e., from a cell (i, j) having value `k` in a matrix `M`, you can move to (i+k, j), (i-k, j), (i, j+k), or (i, j-k). The diagonal moves are not allowed.

In case multiple paths exists, the solution can return any one of them.

Input:

M = [
	[7, 1, 3, 5, 3, 6, 1, 1, 7, 5],
	[2, 3, 6, 1, 1, 6, 6, 6, 1, 2],
	[6, 1, 7, 2, 1, 4, 7, 6, 6, 2],
	[6, 6, 7, 1, 3, 3, 5, 1, 3, 4],
	[5, 5, 6, 1, 5, 4, 6, 1, 7, 4],
	[3, 5, 5, 2, 7, 5, 3, 4, 3, 6],
	[4, 1, 4, 3, 6, 4, 5, 3, 2, 6],
	[4, 4, 1, 7, 4, 3, 3, 1, 4, 2],
	[4, 4, 5, 1, 5, 2, 3, 5, 3, 5],
	[3, 6, 3, 5, 2, 2, 6, 4, 2, 1]
]

Output: [(0, 0) (7, 0) (3, 0) (9, 0) (6, 0) (2, 0) (8, 0) (4, 0) (4, 5) (0, 5) (6, 5) (2, 5) (2, 1) (1, 1) (4, 1) (9, 1) (3, 1) (3, 7) (2, 7) (8, 7) (8, 2) (3, 2) (3, 9) (7, 9) (9, 9)]

or

[(0, 0) (7, 0) (3, 0) (9, 0) (6, 0) (2, 0) (8, 0) (4, 0) (4, 5) (8, 5) (6, 5) (2, 5) (2, 9) (4, 9) (8, 9) (3, 9) (7, 9) (9, 9)]

or any other valid path from first cell to last cell.

*/

    /* The Node<U, V> class have
		1. Two member variables, first and second.
		2. Factory method `Node.of(U, V)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/
    public static List<Node<Integer, Integer>> findPath(int[][] mat){
        List<Node<Integer, Integer>> path = new ArrayList<>();

        if (mat == null || mat.length == 0 || mat[0][0] == 0) return path;

        boolean[][] visited = new boolean[mat.length][mat[0].length];

        recur(path, mat, visited, 0, 0);

        return path;
    }

    public static void recur(List<Node<Integer, Integer>> path, int[][] mat, boolean[][] visited, int i, int j){
        visited[i][j] = true;
        path.add(Node.of(i, j));

        if (i == mat.length - 1 && j == mat.length - 1) return;

        if (isSafe(mat, i + mat[i][j], j, visited))
            recur(path, mat, visited, i + mat[i][j], j);
        if (isSafe(mat, i - mat[i][j], j, visited) && !visited[mat.length - 1][mat[mat.length - 1].length - 1])
            recur(path, mat, visited, i - mat[i][j], j);
        if (isSafe(mat, i, j + mat[i][j], visited) && !visited[mat.length - 1][mat[mat.length - 1].length - 1])
            recur(path, mat, visited, i, j + mat[i][j]);
        if (isSafe(mat, i, j - mat[i][j], visited) && !visited[mat.length - 1][mat[mat.length - 1].length - 1])
            recur(path, mat, visited, i, j - mat[i][j]);

        if (!visited[mat.length - 1][mat[mat.length - 1].length - 1])
            path.remove(path.size() - 1);

        visited[i][j] = false;
    }

    public static boolean isSafe(int[][] mat, int i, int j, boolean[][] visited){
        return (i >= 0 && i < mat.length && j >= 0 && j < mat[i].length && !visited[i][j]);
    }
}
