package com.company.Array;

import java.util.Arrays;

public class SortArray {
    /*

Given an integer array, inplace sort it without using any inbuilt functions.

Input : [6, 3, 4, 8, 2, 9]
Output: [2, 3, 4, 6, 8, 9]

Input : [9, -3, 5, -2, -8, -6]
Output: [-8, -6, -3, -2, 5, 9]

*/
    public static void sort(int[] nums){
        int[] temp = Arrays.copyOf(nums, nums.length);

        for (int width = 1; width < nums.length; width *= 2){
            for (int i = 0; i < nums.length; i += 2 * width){
                int left = i;
                int mid = i + width - 1;
                int right = Integer.min(i + 2 * width - 1, nums.length - 1);

                merge(nums, temp, left, mid, right);
            }
        }
    }

    public static void merge(int[] nums, int[] temp, int left, int mid, int right){
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right){
            if (nums[i] < nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }

        while (i < nums.length && i <= mid)
            temp[k++] = nums[i++];

        for (i = left; i <= right; i++)
            nums[i] = temp[i];
    }
}
