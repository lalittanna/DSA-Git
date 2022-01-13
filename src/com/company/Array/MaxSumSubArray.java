package com.company.Array;

public class MaxSumSubArray {
    /*

    Given an integer array, find the maximum sum among all its subarrays.

    Input : [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    Output: 6
    Explanation: The maximum sum subarray is [4, -1, 2, 1]

    Input : [-7, -3, -2, -4]
    Output: -2
    Explanation: The maximum sum subarray is [-2]

    Input : [-2, 2, -1, 2, 1, 6, -10, 6, 4, -8]
    Output: 10
    Explanation: The maximum sum subarray is [2, -1, 2, 1, 6] or [6, 4] or [2, -1, 2, 1, 6, -10, 6, 4]

    */
    public static int findMaxSubarraySum(int[] nums)
    {
        int maxSoFar = 0;
        int max = Integer.MIN_VALUE;

        for (int value : nums){
            maxSoFar += value;

            maxSoFar = Math.max(maxSoFar, value);

            max = Math.max(max, maxSoFar);
        }

        return max;
    }
}
