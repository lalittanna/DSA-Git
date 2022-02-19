package com.company.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SurpasserCount {
    /*

    Given an integer array having distinct elements, find the surpasser count for each element in it. In other words, for each array element, find the total number of elements to its right, which are greater than it.

    Input : [4, 6, 3, 9, 7, 10]
    Output: [4, 3, 3, 1, 1, 0]

    */
    public static int[] findSurpasserCount(int[] nums){
        int[] result = new int[nums.length];

        Map<Integer, Integer> count = getSurpasserCount(nums);

        for (int i = 0; i < nums.length; i++)
            result[i] = count.getOrDefault(nums[i], 0);

        return result;
    }

    public static Map<Integer, Integer> getSurpasserCount(int[] nums){
        Map<Integer, Integer> count = new HashMap<>();

        int[] arr = Arrays.copyOf(nums, nums.length);
        int[] aux = Arrays.copyOf(nums, nums.length);

        mergeSort(arr, aux, 0, nums.length - 1, count);

        return count;
    }

    public static void mergeSort(int[] arr, int[] aux, int low, int high, Map<Integer, Integer> count){
        if (high <= low)
            return;

        int mid = low + ((high - low) >> 1);

        mergeSort(arr, aux, low, mid, count);
        mergeSort(arr, aux, mid + 1, high, count);

        merge(arr, aux, low, mid, high, count);
    }

    public static void merge(int[] arr, int[] aux, int low, int mid, int high, Map<Integer, Integer> count){
        int i = low, k = low, j = mid + 1;
        int c = 0;

        while (i <= mid && j <= high){
            if (arr[i] > arr[j]) {
                count.put(arr[i], count.getOrDefault(arr[i], 0) + c);
                aux[k++] = arr[i++];
            } else {
                aux[k++] = arr[j++];
                c++;
            }
        }

        while (i <= mid){
            count.put(arr[i], count.getOrDefault(arr[i], 0) + c);
            aux[k++] = arr[i++];
        }

        for (i = low; i <= high; i++)
            arr[i] = aux[i];
    }
}
