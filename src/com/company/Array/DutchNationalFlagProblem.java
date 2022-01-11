package com.company.Array;

public class DutchNationalFlagProblem {
    /*

Given an array containing only 0’s, 1’s, and 2’s, sort it in linear time and using constant space.

Input : [0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2]

*/
    public static void sortArray(int[] nums)
    {
        // Quicksort using dutch national flag
        int pivot = 1, start = 0, mid = 0, end = nums.length - 1;

        while (mid <= end){
            if (nums[mid] > pivot)
                swap(nums, mid, end--);
            else if (nums[mid] < pivot)
                swap(nums, mid++, start++);
            else
                mid++;
        }


        // int zeroIndex = 0;

        // for (int i = 0; i < nums.length; i++)
        // 	if (nums[i] == 0) swap(nums, i, zeroIndex++);


        // for (int j = zeroIndex; j < nums.length; j++)
        // 	if (nums[j] == 1) swap(nums, j, zeroIndex++);
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
