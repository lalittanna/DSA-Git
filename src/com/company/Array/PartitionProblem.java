package com.company.Array;

import java.util.Arrays;

public class PartitionProblem {
    /*

    Given a set of positive integers, check if it can be divided into two subsets with equal sum.

    Input: S = [3, 1, 1, 2, 2, 1]
    Output: true
    Explanation: S can be partitioned into two partitions, each having a sum of 5.

    S1 = [1, 1, 1, 2]
    S2 = [2, 3]

    Note that this solution is not unique. Here’s another solution.

    S1 = [3, 1, 1]
    S2 = [2, 2, 1]

    */
    public static boolean partition(int[] nums){
        int sum = Arrays.stream(nums).sum();
        return (sum & 1) == 0 && subsetSum(nums, sum / 2);

        // int totalSum = Arrays.stream(nums).sum();
        // return (totalSum & 1) == 0 && subsetSum(nums, nums.length - 1, totalSum / 2);
    }

    public static boolean subsetSum(int[] nums, int sum){
        boolean[][] T = new boolean[nums.length + 1][sum + 1];

        for (int i = 0; i <= nums.length; i++)
            T[i][0] = true;

        for (int i = 1; i <= nums.length; i++){
            for (int j = 1; j <= sum; j++){
                if (nums[i - 1] > j)
                    T[i][j] = T[i - 1][j];
                else
                    T[i][j] = T[i - 1][j] || T[i - 1][j - nums[i - 1]];
            }
        }

        return T[nums.length][sum];
    }

    public static boolean subsetSum(int[] nums, int n, int sum){
        if (sum == 0)
            return true;

        if (n < 0 || sum < 0)
            return false;

        return subsetSum(nums, n - 1, sum) || subsetSum(nums, n - 1, sum - nums[n]);
    }
}
