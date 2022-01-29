package com.company.Array;

public class RearrangeArray5 {
    /*

Given an array of positive and negative integers, segregate them without changing the relative order of elements. The output should contain all positive numbers follow negative numbers while maintaining the same relative ordering.

Input : [9, -3, 5, -2, -8, -6, 1, 3]
Output: [-3, -2, -8, -6, 9, 5, 1, 3]

*/
    public static void rearrange(int[] nums)
    {
        int positiveNumbers = 0;
        for (int num : nums)
            if (num >= 0) positiveNumbers++;

        int[] positiveArray = new int[positiveNumbers];

        int j = 0;
        for (int num : nums)
            if (num >= 0) positiveArray[j++] = num;

        int positiveIndex = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] < 0) swap(nums, i, positiveIndex++);

        j = 0;
        for (int i = positiveIndex; i < nums.length; i++)
            nums[i] = positiveArray[j++];
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
