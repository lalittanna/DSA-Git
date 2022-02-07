package com.company.Array;

public class MaxSumIncreasingSubsequence {
    /*

    Given a sequence, find a subsequence of it such that the subsequence sum is as high as possible and the subsequence's elements are sorted in ascending order.

    Input: [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11]
    Output: 34
    Explanation: The maximum sum increasing subsequence is [8, 12, 14] which has sum 34.

    Input: [-4, -3, -2, -1]
    Output: 0
    Explanation: The maximum sum increasing subsequence is [] which has sum 0.

    */
    public static int findMSISLength(int[] nums){
        int n = nums.length;
        int maxSum = 0;

        int[] I = new int[n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i] && I[i] < I[j])
                    I[i] = I[j];
            }
            I[i] += nums[i];
            maxSum = Math.max(maxSum, I[i]);
        }

        return maxSum;
    }
}
