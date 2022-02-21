package com.company.Array;

public class SortWithYoungTableau {
    /*

    Given an integer array, inplace sort it using Young tableau. You are given a utility class YoungTableau with the following static public member functions:

    1. int[][] construct(int[] nums): Construct and return an `N × N` Young tableau from the list `nums`. Note that `N` is determined dynamically by taking ceil of the square root of `nums` length.

    2. int extractMin(int[][] tableau): Extract the next minimum element from the Young tableau `tableau`.

    */
    public static void sort(int[] nums){
        int[][] table = YoungTableau.construct(nums);

        for (int i = 0; i < nums.length; i++)
            nums[i] = YoungTableau.extractMin(table);
    }
}
