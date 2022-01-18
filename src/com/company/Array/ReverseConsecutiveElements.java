package com.company.Array;

public class ReverseConsecutiveElements {
    /*

    Given an integer array `nums` and non-negative integers i, j, and m, reverse every group of consecutive `m` elements in subarray `[i, j]`.

    Input : nums[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], m = 3, i = 1, j = 7
    Output: [1, 4, 3, 2, 7, 6, 5, 8, 9, 10]

    Input : nums[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], m = 3, i = 1, j = 9
    Output: [1, 4, 3, 2, 7, 6, 5, 10, 9, 8]

    Input : nums[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], m = 3, i = 3, j = 5
    Output: [1, 2, 3, 6, 5, 4, 7, 8, 9, 10]

    Input : nums[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], m = 3, i = 3, j = 4
    Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    */
    public static void reverseInGroup(int[] nums, int m, int i, int j)
    {
        if (nums.length < 2)
            return;

        if (m > j - i + 1)
            return;

        for (int start = i; start <= j; start += m){
            if (start + m - 1 <= j)
                reverse(nums, start, start + m - 1);
        }
    }

    public static void reverse(int[] nums, int i, int j){
        if (i >= j)
            return;

        swap(nums, i, j);

        reverse(nums, ++i, --j);
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
