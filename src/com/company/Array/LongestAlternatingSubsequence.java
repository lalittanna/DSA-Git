package com.company.Array;

public class LongestAlternatingSubsequence {
    /*

    The longest alternating subsequence is a problem of finding a subsequence of a given sequence in which the elements are in alternating order and in which the sequence is as long as possible. In order words, we need to find the length of the longest subsequence with alternate low and high elements.

    Input: [8, 9, 6, 4, 5, 7, 3, 2, 4]
    Output: 6
    Explanation: The longest alternating subsequence length is 6, and the subsequence is [8, 9, 6, 7, 3, 4] as (8 < 9 > 6 < 7 > 3 < 4).

    Note that the longest alternating subsequence is not unique. Following are a few more subsequences of length 6:

    (8, 9, 6, 7, 2, 4)
    (8, 9, 4, 7, 3, 4)
    (8, 9, 4, 7, 2, 4)

    */
    public static int findLongestAlternatingSequence(int[] nums){
        if (nums.length <= 1)
            return nums.length;

        int[][] T = new int[nums.length + 1][2];

        int result = 1;

        T[0][0] = T[0][1] = 1;

        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j])
                    T[i][0] = Integer.max(T[i][0], T[j][1] + 1);
                else if (nums[i] < nums[j])
                    T[i][1] = Integer.max(T[i][1], T[j][0] + 1);
            }

            result = Integer.max(result, Integer.max(T[i][0], T[i][1]));
        }

        return result;

        // if (nums.length == 0)
        // 	return 0;
        // return 1 + Integer.max(util(nums, 1, nums.length - 1, true), util(nums, 1, nums.length - 1, false));
    }

    public static int util(int[] nums, int start, int end, boolean flag){
        int result = 0;

        for (int i = start; i <= end; i++){
            if (flag && nums[i - 1] < nums[i])
                result = Integer.max(result, 1 + util(nums, i + 1, end, !flag));
            else if (!flag && nums[i - 1] > nums[i])
                result = Integer.max(result, 1 + util(nums, i + 1, end, !flag));
            else
                result = Integer.max(result, util(nums, i + 1, end, flag));
        }

        return result;
    }
}
