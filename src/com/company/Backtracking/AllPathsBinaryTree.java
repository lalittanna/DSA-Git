package com.company.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPathsBinaryTree {
    class Node {
        int data;
        Node left = null, right = null;

        Node(int data) {
            this.data = data;
        }
    }

    /*

Given the root of a binary tree, return all paths from the root node to every leaf node in the binary tree.

Input:

			 1
		   /   \
		 /		 \
		2		  3
	  /  \		 /  \
	 /	  \		/	 \
	4	   5   6	  7
			  /		   \
			 /			\
			8			 9

Output: {[1, 2, 4], [1, 2, 5], [1, 3, 6, 8], [1, 3, 7, 9]}

Explanation: The binary tree has four root-to-leaf paths:

1 —> 2 —> 4
1 —> 2 —> 5
1 —> 3 —> 6 —> 8
1 —> 3 —> 7 —> 9

*/
    public static Set<List<Integer>> findRootToLeafPaths(Node root){
        Set<List<Integer>> paths = new HashSet<>();

        allPaths(paths, new ArrayList<>(), root);

        return paths;
    }

    public static void allPaths(Set<List<Integer>> paths, List<Integer> path, Node node){
        if (node == null) return;

        path.add(node.data);

        if (node.left == null && node.right == null){
            List<Integer> list = new ArrayList<>(path);
            paths.add(list);
        }

        allPaths(paths, path, node.left);
        allPaths(paths, path, node.right);

        path.remove(path.size() - 1);
    }
}
