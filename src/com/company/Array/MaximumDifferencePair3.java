package com.company.Array;

public class MaximumDifferencePair3 {
    /*

Given an integer array `nums`, find the maximum value of `j-i` such that `nums[j] > nums[i]`.

For example,

Input: nums = [9, 10, 2, 6, 7, 12, 8, 1]
Output: 5
Explanation: The maximum difference is 5 for i = 0, j = 5

Input: nums = [9, 2, 1, 6, 7, 3, 8]
Output: 5
Explanation: The maximum difference is 5 for i = 1, j = 6

Input: nums = [8, 7, 5, 4, 2, 1]
Output: -1 (or any other negative number)
Explanation: Array is sorted in decreasing order.

*/
    public static int findMaxDiff(int[] nums){
        int diff = -1;

        int n = nums.length;

        if (n < 1)
            return -1;

        int[] aux = new int[n];
        aux[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--)
            aux[i] = Integer.max(nums[i], aux[i + 1]);

        for (int i = 0, j = 0; i < n && j < n;){
            if (nums[i] < aux[j]){
                diff = Integer.max(diff, j - i);
                j++;
            } else
                i++;
        }

        return diff;
    }
}
