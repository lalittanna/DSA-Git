package com.company.Array;

public class HeapSort {
/*

Given an integer array, inplace sort it without using any inbuilt functions.

Input : [6, 3, 4, 8, 2, 9]
Output: [2, 3, 4, 6, 8, 9]

Input : [9, -3, 5, -2, -8, -6]
Output: [-8, -6, -3, -2, 5, 9]

*/
    public static void sort(int[] nums){
        int n = nums.length;

        int i = (n - 2) / 2;
        while (i >= 0)
            heapify(nums, i--, n);

        while (n > 0)
            nums[n - 1] = pop(nums, n--);
    }

    public static void heapify(int[] nums, int i, int size){
        int left = left(i);
        int right = right(i);

        int largest = i;

        if (left < size && nums[largest] < nums[left])
            largest = left;

        if (right < size && nums[largest] < nums[right])
            largest = right;

        if (largest != i){
            swap (nums, largest, i);
            heapify(nums, largest, size);
        }
    }

    public static int pop(int[] nums, int size){
        int top = nums[0];

        nums[0] = nums[size - 1];

        heapify(nums, 0, size - 1);

        return top;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int left(int i){
        return (i * 2 + 1);
    }

    public static int right(int i){
        return (i * 2 + 2);
    }
}
