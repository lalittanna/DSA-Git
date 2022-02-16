package com.company.Array;

import java.util.Arrays;

public class MaxSumCircularSubArray {
    /*

Given a circular integer array, find a contiguous subarray with the largest sum in it.

Input : [2, 1, -5, 4, -3, 1, -3, 4, -1]
Output: 6
Explanation: Subarray with the largest sum is [4, -1, 2, 1] with sum 6.

Input : [8, -7, -3, 5, 6, -2, 3, -4, 2]
Output: 18
Explanation: Subarray with the largest sum is [5, 6, -2, 3, -4, 2, 8] with sum 18.

*/
    public static int findMaxSubarray(int[] nums){
        if (nums.length == 0)
            return 0;

        int max = Arrays.stream(nums).max().getAsInt();

        if (max < 0)
            return max;

        Arrays.setAll(nums, i -> -nums[i]);

        int negativeMaxSum = kadane(nums);

        Arrays.setAll(nums, i -> -nums[i]);

        return Integer.max(Arrays.stream(nums).sum() + negativeMaxSum, kadane(nums));
    }

    public static int kadane(int[] nums){
        int max = 0;
        int maxSoFar = 0;

        for (int num : nums){
            maxSoFar += num;

            maxSoFar = Integer.max(maxSoFar, 0);
            max = Integer.max(max, maxSoFar);
        }

        return max;
    }
}
