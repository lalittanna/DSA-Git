package com.company.Array;

public class FindMaxDifference {
    /*

    Given an integer array, find the maximum difference between two elements in it such that the smaller element appears before the larger element. If no such pair exists, return any negative number.

    Input : [2, 7, 9, 5, 1, 3, 5]
    Output: 7
    Explanation: The pair with the maximum difference is (2, 9).

    Input : [5, 4, 3, 2, 1]
    Output: -1 (or any other negative number)
    Explanation: No pair with the maximum difference exists.

    */
    public static int findMaxDiff(int[] nums)
    {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int value : nums){
            min = Math.min(min, value);
            max = Math.max(max, value - min);
        }

        return max == 0 ? -1 : max;
    }
}
