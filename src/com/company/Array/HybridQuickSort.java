package com.company.Array;

public class HybridQuickSort {
    public static void sort(int[] nums){
        hybridQuickSort(nums, 0, nums.length - 1);
    }

    public static void hybridQuickSort(int[] nums, int low, int high){
        while (low < high){
            if (high - low < 10){
                insertionSort(nums, low, high);
                break;
            }else {
                int pivotIndex = partition(nums, low, high);

                // tail call optimization - recur on smaller subarray
                if (pivotIndex - low < high - pivotIndex){
                    hybridQuickSort(nums, low, pivotIndex - 1);
                    low = pivotIndex + 1;
                } else {
                    hybridQuickSort(nums, pivotIndex + 1, high);
                    high = pivotIndex - 1;
                }
            }
        }
    }

    public static void quickSort(int[] nums, int low, int high){
        if (high <= low)
            return;

        int pivotIndex = partition(nums,low, high);

        quickSort(nums, low, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, high);
    }

    public static int partition(int[] nums, int low, int high){
        int pivot = nums[high];
        int pivotIndex = low;

        for (int i = low; i < high; i++){
            if (nums[i] <= pivot){
                swap(nums, i, pivotIndex);
                pivotIndex++;
            }
        }

        swap(nums, pivotIndex, high);

        return pivotIndex;
    }

    public static void insertionSort(int[] nums, int low, int high){
        for (int i = low + 1; i <= high; i++){
            int value = nums[i];
            int j = i;

            while (j > low && value < nums[j - 1]){
                nums[j] = nums[j - 1];
                j--;
            }

            nums[j] = value;
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
