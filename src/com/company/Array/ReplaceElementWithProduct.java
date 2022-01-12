package com.company.Array;

public class ReplaceElementWithProduct {
    /*

Given an integer array, replace each element with the product of every other element without using the division operator.

Input : [1, 2, 3, 4, 5]
Output: [120, 60, 40, 30, 24]

Input : [5, 3, 4, 2, 6, 8]
Output: [1152, 1920, 1440, 2880, 960, 720]

*/
    public static void replace(int[] nums)
    {
        if (nums.length < 1)
            return;

        int[] right = new int[nums.length];

        right[nums.length - 1] = 1;
        for (int j = nums.length - 2; j >= 0; j--)
            right[j] = right[j + 1] * nums[j + 1];

        int left = 1;
        for (int i = 0; i < nums.length; i++){
            int temp = nums[i];
            nums[i] = right[i] * left;
            left *= temp;
        }

        // if (nums.length < 1)
        // 	return;

        // int[] left = new int[nums.length];
        // int[] right = new int[nums.length];

        // left[0] = 1;
        // for (int i = 1; i < nums.length; i++)
        // 	left[i] = left[i - 1] * nums[i - 1];

        // right[nums.length - 1] = 1;
        // for (int j = nums.length - 2; j >= 0; j--)
        // 	right[j] = right[j + 1] * nums[j + 1];

        // for (int i = 0; i < nums.length; i++)
        // 	nums[i] = left[i] * right[i];
    }
}
