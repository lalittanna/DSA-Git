package com.company.Backtracking;

import java.util.*;

class Edge {
    public final int source, dest;

    private Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }

    // Factory method for creating an immutable instance of `Edge`
    public static Edge of(int a, int b) {
        return new Edge(a, b);        // calls private constructor
    }
}

// A class to represent a graph object
class Graph {
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;

    // Constructor
    Graph(List<Edge> edges, int n)
    {
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // add edges to the directed graph
        for (Edge edge: edges) {
            adjList.get(edge.source).add(edge.dest);
        }
    }
}

public class isReachableVertex {
    /*

    Given a directed graph and two vertices - source and destination, determine if the destination vertex is reachable from the source vertex. The solution should return true if a path exists from the source vertex to the destination vertex, false otherwise.

    Input: Graph [edges = [(0, 1), (1, 2), (2, 3), (3, 5), (4, 1)], n = 6], src = 4, dest = 5
    Output: true
    Explanation: There exist a path [4 —> 1 —> 2 —> 3 —> 5] from vertex 4 to vertex 5.

    Input: Graph [edges = [(0, 1), (1, 2), (2, 3), (3, 5), (4, 1)], n = 6], src = 5, dest = 1
    Output: false
    Explanation: There is no path from vertex 5 to any other vertex.

    Constraints:

    • The graph is implemented using an adjacency list.
    • The maximum number of nodes in the graph is 100, i.e., 0 <= n < 100, and each node is represented by its numeric value.
    • The destination can be reached from the source.

    */
    public static boolean isReachable(Graph graph, int src, int dest, Set<Integer> set){
        int n = graph.adjList.size();

        boolean[] discovered = new boolean[n];

        Queue<Integer> queue = new ArrayDeque<>();

        discovered[src] = true;

        queue.add(src);

        while (!queue.isEmpty()){
            int v = queue.poll();

            if (v == dest) return true;

            for (int u : graph.adjList.get(v)){
                if (!discovered[u]){
                    discovered[u] = true;
                    queue.add(u);
                }
            }
        }

        return false;

//        if (src == dest) return true;
//
//        if (graph.adjList.size() <= src || graph.adjList.get(src).size() == 0) return false;
//
//        boolean seen = false;
//
//        set.add(src);
//
//        for (int i = 0; i < graph.adjList.get(src).size() && !seen; i++){
//            if (!set.contains(graph.adjList.get(src).get(i)))
//                seen = isReachable(graph, graph.adjList.get(src).get(i), dest, set);
//        }
//
//        return seen;
    }
}
