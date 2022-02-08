package com.company.Array;

public class SubsetSumProblem {
    /*

Given a set of positive integers and an integer `k`, check if there is any non-empty subset that sums to `k`.

Input: nums = [7, 3, 2, 5, 8], k = 14
Output: true
Explanation: Subset [7, 2, 5] sums to 14

*/
    public static boolean subsetSum(int[] nums, int k){
        boolean[][] T = new boolean[nums.length + 1][k + 1];

        for (int i = 0; i <= nums.length; i++)
            T[i][0] = true;

        for (int i = 1; i <= nums.length; i++){
            for (int j = 1; j <= k; j++){
                if (nums[i - 1] > j)
                    T[i][j] = T[i - 1][j];
                else
                    T[i][j] = T[i - 1][j] || T[i - 1][j - nums[i - 1]];
            }
        }

        return T[nums.length][k];
    }
}
