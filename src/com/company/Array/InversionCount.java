package com.company.Array;

import java.util.Arrays;

public class InversionCount {
    /*

    Given an integer array, find the total number of inversions of it. If `(i < j)` and `(nums[i] > nums[j])`, then pair `(i, j)` is called an inversion of an array `nums`. The solution should provide count of all such pairs in the array.

    Input : [1, 9, 6, 4, 5]
    Output: 5
    Explanation: There are 5 inversions in the array: (9, 6), (9, 4), (9, 5), (6, 4), (6, 5)

    */
    public static int findInversionCount(int[] nums){
        int[] aux = Arrays.copyOf(nums, nums.length);
        return mergeSort(nums, aux, 0, nums.length - 1);
    }

    public static int mergeSort(int[] arr, int[] aux, int low, int high){
        if (high <= low)
            return 0;

        int mid = low + ((high - low) >> 1);
        int inversion = 0;

        inversion += mergeSort(arr, aux, low, mid);
        inversion += mergeSort(arr, aux, mid + 1, high);
        inversion += merge(arr, aux, low, mid, high);

        return inversion;
    }

    public static int merge(int[] arr, int[] aux, int low, int mid, int high){
        int i = low, j = mid + 1, k = low;

        int inversion = 0;

        while (i <= mid && j <= high){
            if (arr[i] <= arr[j])
                aux[k++] = arr[i++];
            else {
                aux[k++] = arr[j++];
                inversion += mid - i + 1;
            }
        }

        while (i <= mid)
            aux[k++] = arr[i++];

        for (i = low; i <= high; i++)
            arr[i] = aux[i];

        return inversion;
    }

}
