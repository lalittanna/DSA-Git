package com.company.Array;

import java.util.Random;

public class FisherYatesShuffle {
    /*

Given an array of distinct integer, in-place shuffle the array. The solution should produce an unbiased permutation, i.e., every permutation is equally likely.

Input: [1, 2, 3, 4, 5]
Output: [5, 4, 2, 1, 3] or [4, 1, 5, 3, 2] or any other unbiased permutation.

*/
    public static void shuffle(int[] nums)
    {
        for (int i = 0; i < nums.length - 1; i++){
            Random rand = new Random();

            // between i and nums.length - 1
            int j = i + rand.nextInt(nums.length - i);

            swap(nums, i, j);
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
