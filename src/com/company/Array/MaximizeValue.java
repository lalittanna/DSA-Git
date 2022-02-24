package com.company.Array;

import java.util.Arrays;

public class MaximizeValue {
    /*

    Given an array `A`, maximize the value of expression `A[s] - A[r] + A[q] - A[p]`, where p, q, r, and s are indices of the array and s > r > q > p.

    Input: [3, 9, 10, 1, 30, 40]
    Output: 46
    Explanation: The expression (40 - 1 + 10 - 3) results in maximum value.

    */
    public static int maximizeValue(int[] nums){
        if (nums.length < 4) return Integer.MIN_VALUE;

        int[] first = new int[nums.length + 1];
        Arrays.fill(first, Integer.MIN_VALUE);

        int[] second = new int[nums.length];
        Arrays.fill(second, Integer.MIN_VALUE);

        int[] third = new int[nums.length - 1];
        Arrays.fill(third, Integer.MIN_VALUE);

        int[] fourth = new int[nums.length - 2];
        Arrays.fill(fourth, Integer.MIN_VALUE);

        for (int i = nums.length - 1; i >= 0; i--)
            first[i] = Math.max(first[i + 1], nums[i]);

        for (int i = nums.length - 2; i >= 0; i--)
            second[i] = Math.max(second[i + 1], first[i + 1] - nums[i]);

        for (int i = nums.length - 3; i >= 0; i--)
            third[i] = Math.max(third[i + 1], second[i + 1] + nums[i]);

        for (int i = nums.length - 4; i >= 0; i--)
            fourth[i] = Math.max(fourth[i + 1], third[i + 1] - nums[i]);

        return fourth[0];
    }
}
