package com.company.Array;

import java.util.concurrent.atomic.AtomicInteger;

class Node {
    int key;
    Node left = null, right = null;

    Node(int key){
        this.key = key;
    }
}

public class ReplaceArrayElements2 {
    /*

    Given an array of distinct integers, replace every element with the least greater element on its right or with -1 if there are no greater elements.

    Input : [10, 100, 93, 32, 35, 65, 80, 90, 94, 6]
    Output: [32, -1, 94, 35, 65, 80, 90, 94, -1, -1]

    */
    public static void replace(int[] nums){
        Node root = null;

        for (int i = nums.length - 1; i >= 0; i--){
            AtomicInteger successor = new AtomicInteger(-1);
            root = insert(root, nums[i], successor);
            nums[i] = successor.get();
        }
    }

    public static Node insert(Node root, int key, AtomicInteger successor){
        if (root == null)
            return new Node(key);

        if (key < root.key){
            successor.set(root.key);

            root.left = insert(root.left, key, successor);
        }

        if (key > root.key)
            root.right = insert(root.right, key, successor);

        return root;
    }
}
