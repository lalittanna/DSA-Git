package com.company.Array;

import java.util.Stack;

public class IterativeQuickSort {
    /*

    Given an integer array, inplace sort it without using any inbuilt functions.

    Input : [6, 3, 4, 8, 2, 9]
    Output: [2, 3, 4, 6, 8, 9]

    Input : [9, -3, 5, -2, -8, -6]
    Output: [-8, -6, -3, -2, 5, 9]

    */
    public static void sort(int[] nums){
        if (nums.length < 1)
            return;

        int start = 0;
        int end = nums.length - 1;

        Stack<Pair> stack = new Stack<>();

        stack.push(new Pair(start, end));

        while (!stack.empty()){
            start = stack.peek().getX();
            end = stack.peek().getY();
            stack.pop();

            int pivot = partition(nums, start, end);

            if (pivot - 1 > start)
                stack.push(new Pair(start, pivot - 1));

            if (pivot + 1 < end)
                stack.push(new Pair(pivot + 1, end));
        }
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

        swap(nums, high, pivotIndex);

        return pivotIndex;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
