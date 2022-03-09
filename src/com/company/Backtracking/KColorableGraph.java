package com.company.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class KColorableGraph {
    /*

Given an undirected graph and a positive integer k, check if the graph is k–colorable or not.

The vertex coloring is a way of coloring the vertices of a graph such that no two adjacent vertices share the same color. A coloring using at most k colors is called a (proper) k–coloring, and a graph that can be assigned a (proper) k–coloring is k–colorable.

Input: Graph [edges = [(0, 1), (0, 4), (0, 5), (4, 5), (1, 4), (1, 3), (2, 3), (2, 4)], n = 6], k = 3

 0 ───── 1 ────── 2
 │ \	 │  \   / │
 │   \   │	  X   │
 │	   \ │  /   \ │
 5 ───── 4 ────── 3

Output: true

Explanation: The graph can be colored using 3 colors in several ways as shown below. However, the graph is not 2–colorable.

 ┌─────────────────────────────────────────┐
 │  #0  │  #1  │  #2  │  #3  │  #4  │  #5  │
 │──────│──────│──────│──────│──────│──────│
 │  C1  │  C2  │  C1  │  C3  │  C3  │  C2  │
 │  C1  │  C2  │  C2  │  C1  │  C3  │  C2  │
 │  C1  │  C2  │  C2  │  C3  │  C3  │  C2  │
 │  C1  │  C3  │  C1  │  C2  │  C2  │  C3  │
 │  C1  │  C3  │  C3  │  C1  │  C2  │  C3  │
 │  C1  │  C3  │  C3  │  C2  │  C2  │  C3  │
 │  C2  │  C1  │  C1  │  C2  │  C3  │  C1  │
 │  C2  │  C1  │  C1  │  C3  │  C3  │  C1  │
 │  C2  │  C1  │  C2  │  C3  │  C3  │  C1  │
 │  C2  │  C3  │  C2  │  C1  │  C1  │  C3  │
 │  C2  │  C3  │  C3  │  C1  │  C1  │  C3  │
 │  C2  │  C3  │  C3  │  C2  │  C1  │  C3  │
 │  C3  │  C1  │  C1  │  C2  │  C2  │  C1  │
 │  C3  │  C1  │  C1  │  C3  │  C2  │  C1  │
 │  C3  │  C1  │  C3  │  C2  │  C2  │  C1  │
 │  C3  │  C2  │  C2  │  C1  │  C1  │  C2  │
 │  C3  │  C2  │  C2  │  C3  │  C1  │  C2  │
 │  C3  │  C2  │  C3  │  C1  │  C1  │  C2  │
 └─────────────────────────────────────────┘


Input: Graph [edges = [(0, 1), (0, 2), (0, 3), (1, 2), (1, 3), (2, 3)], n = 4], k = 3

 0 ───── 1
 │ \   / │
 │   X   │
 │ /   \ │
 2 ───── 3

Output: false
Explanation: The graph cannot be colored using 3 colors. The graph is 4–colorable.


Constraints:

• The graph is implemented using an adjacency list.
• The maximum number of nodes in the graph is 100, i.e., 0 <= n < 100, and each node is represented by its numeric value.
• The graph is connected, i.e., every node can be reached starting from all other nodes.

*/

    class Edge {
        int source, dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    // A class to represent a graph object
    class Graph {
        // A list of lists to represent an adjacency list
        List<List<Integer>> adjList = null;
        int n;

        // Constructor
        Graph(List<Edge> edges, int n) {
            adjList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }

            // add edges to the undirected graph
            for (Edge edge: edges) {
                int src = edge.source;
                int dest = edge.dest;

                adjList.get(src).add(dest);
                adjList.get(dest).add(src);
            }
        }
    }
    /*
		// Definition for a Graph
		class Graph
		{
			// List of lists to represent an adjacency list
			List<List<Integer>> adjList;

			// Total number of nodes in the graph
			int n;
		}
	*/

    public static boolean isKColorable(Graph graph, int k){
        return isKColorable(graph, new int[graph.n], k, 0, graph.n);
    }

    public static boolean isKColorable(Graph graph, int[] colors, int k, int v, int n){
        if (v == n){
            return true;
        }

        for (int c = 1; c <= k; c++){
            if (isSafe(graph, colors, v, c)){
                colors[v] = c;

                if (isKColorable(graph, colors, k, v + 1, n)) return true;

                colors[v] = 0;
            }
        }

        return false;
    }

    public static boolean isSafe(Graph graph, int[] colors, int v, int c){
        for (int u : graph.adjList.get(v))
            if (colors[u] == c) return false;

        return true;
    }
}
