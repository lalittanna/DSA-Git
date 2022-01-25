package com.company.Array;

public class ShuffleArray {
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
