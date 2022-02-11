package com.company.Array;

public class MaximumSumSubsequence {
    /*

    Given an integer array, find the maximum sum of subsequence where the subsequence contains no element at adjacent positions.

    Input: [1, 2, 9, 4, 5, 0, 4, 11, 6]
    Output: 26
    Explanation: The maximum sum is 26 and formed by the subsequence [1, 9, 5, 11].

    */
    public static int findMaximumSumSubsequence(int[] nums){
        int n = nums.length;

        if (n == 0)
            return 0;

        if (n == 1)
            return nums[0];

        int prev_prev = nums[0];
        int prev = Integer.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++){
            int curr = Integer.max(nums[i], Math.max(prev_prev + nums[i], prev));
            prev_prev = prev;
            prev = curr;
        }

        return prev;

        //return maximumSumSubsequence(nums, 0, Integer.MIN_VALUE);
    }

    public static int maximumSumSubsequence(int[] nums, int i, int prev){
        if (i == nums.length)
            return 0;

        int excl = maximumSumSubsequence(nums, i + 1, prev);

        int incl = 0;
        if (prev + 1 != i)
            incl = maximumSumSubsequence(nums, i + 1, i) + nums[i];

        return Integer.max(incl, excl);
    }
}
