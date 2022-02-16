package com.company.Array;

public class MaximumProductSubArray {
    /*

    Given an integer array, find the contiguous subarray that has the maximum product of its elements. The solution should return the maximum product of elements among all possible subarrays.

    Input : [-6, 4, -5, 8, -10, 0, 8]
    Output: 1600
    Explanation: The maximum product subarray is [4, -5, 8, -10] which has product 1600.

    Input : [40, 0, -20, -10]
    Output: 200
    Explanation: The maximum product subarray is [-20, -10] which has product 200.

    Input : [10]
    Output: 10

    Input : []
    Output: 0

    */
    public static int findMaxProduct(int[] nums){
        if (nums.length == 0)
            return 0;

        int maxEnding = nums[0], minEnding = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++){
            int temp = maxEnding;

            maxEnding = Integer.max(nums[i], Integer.max(nums[i] * maxEnding, nums[i] * minEnding));
            minEnding = Integer.min(nums[i], Integer.min(nums[i] * temp, nums[i] * minEnding));

            max = Integer.max(max, maxEnding);
        }

        return max;
    }
}
