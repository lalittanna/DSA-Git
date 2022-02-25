package com.company.Array;

import java.util.List;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MinimumWeightTriangulation {
    /*

    A triangulation of a convex polygon results in a set of non-intersecting diagonals between non-adjacent vertices, which completely partition the interior of the convex hull of the polygon into triangles. The minimum-weight triangulation (MWT) is the triangulation having the minimum total edge length among all possible triangulation.

    Input: [(0, 0), (2, 0), (2, 1), (1, 2), (0, 1)]
    Output: 15.30056307974577

    Explanation: The following are the two triangulations of the same convex pentagon. The triangulation on the left has a cost of 8 + 2√2 + 2√5 (approximately 15.30), the one on the right has a cost of 4 + 2√2 + 4√5 (approximately 15.77).

    https://techiedelight.com/practice/images/Minimum-Weight-Triangulation.png

    */
    /* The Point class have
		1. Two member variables, x and y.
		2. Factory method `Point.of(x, y)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/
    public static double findMWT(List<Point> vertices){
        int n = vertices.size();

        double[][] T = new double[n][n];

        for (int diagonal = 0; diagonal < n; diagonal++){
            for (int i = 0, j = diagonal; j < n; j++, i++){
                if (j < i + 2) continue;

                T[i][j] = Double.MAX_VALUE;

                for (int k = i + 1; k < j; k++){
                    double weight = dist(vertices.get(i), vertices.get(j)) + dist(vertices.get(j), vertices.get(k)) + dist(vertices.get(k), vertices.get(i));

                    T[i][j] = Double.min(T[i][j], weight + T[i][k] + T[k][j]);
                }
            }
        }

        return T[0][n - 1];

        //return MWT(vertices, 0, vertices.size() - 1);
    }

    public static double MWT(List<Point> vertices, int i, int j){
        if (j < i + 2) return 0;

        double cost = Double.MAX_VALUE;

        for (int k = i + 1; k <= j - 1; k++){
            double w = dist(vertices.get(i), vertices.get(j)) + dist(vertices.get(j), vertices.get(k)) + dist(vertices.get(k), vertices.get(i));

            cost = Double.min(cost, w + MWT(vertices, i, k) + MWT(vertices, k, j));
        }

        return cost;
    }

    public static double dist(Point p, Point q){
        return Math.sqrt(Math.pow(p.x - q.x, 2) + Math.pow(p.y - q.y, 2));
    }
}
