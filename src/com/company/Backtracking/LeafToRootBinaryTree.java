package com.company.Backtracking;

import java.util.*;

public class LeafToRootBinaryTree {
    /*

Given the root of a binary tree, return all paths from every leaf node to the root node in the binary tree.

Input:

			 1
		   /   \
		 /		 \
		2		  3
	   / \		 / \
	  /	  \		/	\
	 4	   5   6	 7
			  / \
			 /	 \
			8	  9

Output: {[4, 2, 1], [5, 2, 1], [8, 6, 3, 1], [9, 6, 3, 1], [7, 3, 1]}

Explanation: The binary tree has five leaf-to-root paths:

4 —> 2 —> 1
5 —> 2 —> 1
8 —> 6 —> 3 —> 1
9 —> 6 —> 3 —> 1
7 —> 3 —> 1

*/

    class Node {
        int data;
        Node left = null, right = null;

        Node(int data) {
            this.data = data;
        }
    }
    /*
		A binary tree node is defined as:

		class Node
		{
			int data;			// data field
			Node left, right;	// pointer to the left and right child

			Node() {}
			Node(int data) { this.data = data; this.left = this.right = null; }
		}
	*/

    public static Set<List<Integer>> findLeafToRootPaths(Node root){
        Set<List<Integer>> paths = new HashSet<>();

        leafToRootPaths(paths, new ArrayList<>(), root);

        return paths;
    }

    public static void leafToRootPaths(Set<List<Integer>> paths, List<Integer> list, Node node){
        if (node == null) return;

        list.add(node.data);

        if (node.right == null && node.left == null){
            List<Integer> path = new ArrayList<>(list);
            Collections.reverse(path);
            paths.add(path);
        }

        leafToRootPaths(paths, list, node.left);
        leafToRootPaths(paths, list, node.right);

        list.remove(list.size() - 1);
    }
}
