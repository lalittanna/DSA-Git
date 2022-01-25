package com.company.Array;

public class ShuffleArray {
    /*

Given an array of distinct integers `nums`, shuffle it according to order specified by another array `pos`. For every index `i` in `nums`, the solution should update `nums[pos[i]] = nums[i]`.

Input:

nums[] = [1, 2, 3, 4, 5]
 pos[] = [3, 2, 4, 1, 0]

Output: [5, 4, 2, 1, 3]

*/

    public static void shuffle(int[] nums, int[] pos)
    {
        for (int i = 0; i < nums.length; i++){
            while (pos[i] != i){
                swap(nums, pos[i], i);
                swap(pos, pos[i], i);
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
