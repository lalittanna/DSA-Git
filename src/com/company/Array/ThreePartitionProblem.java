package com.company.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreePartitionProblem {
/*

Given a set S of positive integers, determine if it can be partitioned into three disjoint subsets that all have the same sum, and they cover S.

Input: S = [7, 3, 2, 1, 5, 4, 8]
Output: true
Explanation: S can be partitioned into three partitions [[7, 3], [5, 4, 1], [8, 2]], each having a sum of 10.

Note that there can be multiple solutions to a single set.

*/
    public static boolean partition(int[] S){
        if (S.length < 3)
            return false;

        int sum = Arrays.stream(S).sum();
        return (sum % 3 == 0) && subsets(S, S.length - 1, sum / 3, sum / 3, sum / 3, new HashMap<>());
    }

    public static boolean subsets(int[] nums, int n, int a, int b, int c, Map<String, Boolean> lookup){
        if (a == 0 && b == 0 && c == 0)
            return true;

        if (n < 0)
            return false;

        String s = a + "|" + b + "|" + c + "|" + n;

        if (!lookup.containsKey(s)){
            boolean A = false;
            if (a - nums[n] >= 0)
                A = subsets(nums, n - 1, a - nums[n], b, c, lookup);

            boolean B = false;
            if (!A && b - nums[n] >= 0)
                B = subsets(nums, n - 1, a, b - nums[n], c, lookup);

            boolean C = false;
            if ((!A && !B) && c - nums[n] >= 0)
                C = subsets(nums, n - 1, a, b, c - nums[n], lookup);

            lookup.put(s, A || B || C);
        }

        return lookup.get(s);
    }
}
