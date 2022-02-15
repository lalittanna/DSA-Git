package com.company.Array;

public class HeightOfBinaryTree2 {
    /*

    Given an integer array representing the parent-child relationship in a binary tree, find the tree's height without building the tree. The parent-child relationship is defined by (A[i], i) for every index i in array A. The root node's value will be i if -1 is present at index i in the array.

    The height of a "node" is the total number of edges on the longest path from the node to a leaf. The height of a "tree" would be the height of its root node, or equivalently, the depth of its deepest node. A leaf node will have a height of 0 and an empty tree has height −1.

    Input: [-1, 0, 0, 1, 2, 2, 4, 4]
    Output: 3
    Explanation: The parent array represents the folllowing binary tree

               0
             /   \
            /	  \
           1	   2
          /		  / \
         /	  	 /	 \
        3		4	  5
               / \
              /   \
             6	   7

    • -1 is present at index 0, which implies that the binary tree root is node 0.
    • 0 is present at index 1 and 2, which implies that the left and right children of node 0 are 1 and 2.
    • 1 is present at index 3, which implies that the left or the right child of node 1 is 3.
    • 2 is present at index 4 and 5, which implies that the left and right children of node 2 are 4 and 5.
    • 4 is present at index 6 and 7, which implies that the left and right children of node 4 are 6 and 7.

    */
    public static int findHeight(int[] parent){
        if (parent.length == 0)
            return -1;

        int height = -1;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < parent.length; i++){
            if (parent[i] > max){
                max = parent[i];
                maxIndex = i;
            }
        }

        height = Integer.max(height, depth(parent, maxIndex));

        return height;

        // int height = -1;
        // int[] depth = new int[parent.length];

        // for (int i = 0; i < parent.length; i++){
        // 	int depth_i = 0;
        // 	for (int k = i; parent[k] != -1; k = parent[k]){
        // 		if (depth[k] != 0){
        // 			depth_i += depth[k];
        // 			break;
        // 		}
        // 		depth_i++;
        // 	}
        // 	depth[i] = depth_i;

        // 	height = Integer.max(height, depth[i]);
        // }

        // return height;

        // int height = -1;

        // for (int i = 0; i < parent.length; i++)
        // 	height = Integer.max(height, depth(parent, i));

        // return height;
    }

    public static int depth(int[] parent, int i){
        if (parent[i] == -1)
            return 0;

        return 1 + depth(parent, parent[i]);
    }
}
