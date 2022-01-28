package com.company.Array;

public class HoarePartition {
    /*

Given an integer array, inplace sort it without using any inbuilt functions.

Input : [6, 3, 4, 8, 2, 9]
Output: [2, 3, 4, 6, 8, 9]

Input : [9, -3, 5, -2, -8, -6]
Output: [-8, -6, -3, -2, 5, 9]

*/

    public static void sort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int low, int high){
        if (high <= low)
            return;

        int pivotIndex = partition(nums,low, high);

        quickSort(nums, low, pivotIndex);
        quickSort(nums, pivotIndex + 1, high);
    }

    public static int partition(int[] nums, int low, int high){
        int pivot = nums[low];
        int i = low - 1;
        int j = high + 1;

        while (true){
            do{
                i++;
            } while (nums[i] < pivot);

            do {
                j--;
            } while (nums[j] > pivot);

            if (i >= j)
                return j;

            swap(nums, i, j);
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
