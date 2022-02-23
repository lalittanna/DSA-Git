package com.company.Array;

import java.util.Arrays;

public class LongestDecreasingSubsequence {
    /*

    Given a given sequence, find the length of the longest decreasing subsequence (LDS) in it.

    The longest decreasing subsequence is a subsequence of a given sequence in which the subsequence's elements are in sorted order, highest to lowest, and in which the subsequence is as long as possible.

    Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
    Output: 6
    Explanation: The longest decreasing subsequence is [12, 10, 9, 5, 3] having length 5; the input sequence has no 6–member decreasing subsequences.

    The longest decreasing subsequence is not necessarily unique. For instance, [12, 10, 6, 5, 3] is another decreasing subsequences of equal length in the same input sequence.

    */
    public static int findLDSLength(int[] nums){
        if (nums.length == 0)
            return 0;

        int[] L = new int[nums.length];

        L[0] = 1;

        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] > nums[i] && L[j] > L[i])
                    L[i] = L[j];
            }

            L[i]++;
        }

        return Arrays.stream(L).max().getAsInt();

        //return LDS(nums, 0, Integer.MAX_VALUE);
    }

    public static int LDS(int[] nums, int i, int prev){
        if (i == nums.length)
            return 0;

        int excl = LDS(nums, i + 1, prev);

        int incl = 0;
        if (nums[i] < prev)
            incl += 1 + LDS(nums, i + 1, nums[i]);

        return Math.max(incl, excl);
    }
}
