package com.company.Array;

import java.util.Arrays;
import java.util.Map;

public class MinimumSumPartitionProblem {
    /*

    Given a set of positive integers S, partition it into two subsets, S1 and S2, such that the difference between the sum of elements in S1 and S2 is mininum. The solution should return the minimum absolute difference between the sum of elements of two partitions.

    Input: S = [10, 20, 15, 5, 25]
    Output: 5
    Explanation: S can be partitioned into two partitions [[10, 20, 5], [15, 25]] where the minimum absolute difference between the sum of elements is 5. Note that this solution is not unique. Another solution is [[10, 25], [20, 15, 5]].

    Input: []
    Output: 0

    */
    public static int findMinAbsDiff(int[] S){
        int sum = Arrays.stream(S).sum();

        boolean[][] T = new boolean[S.length + 1][sum + 1];

        for (int i = 0; i <= S.length; i++){
            T[i][0] = true;

            for (int j = 1; i > 0 && j <= sum; j++){
                T[i][j] = T[i- 1][j];

                if (j >= S[i - 1])
                    T[i][j] |= T[i - 1][j - S[i - 1]];
            }
        }

        int j = sum / 2;
        while (j >= 0 && !T[S.length][j])
            j--;

        return sum - 2 * j;

        //return min(S, 0, 0, S.length - 1, new HashMap<>());
    }

    public static int min(int[] S, int leftSum, int rightSum, int n, Map<String, Integer> lookUp){
        if (n < 0) return Math.abs(rightSum - leftSum);

        String s = n + "|" + leftSum;

        if (!lookUp.containsKey(s)){
            int incl = min(S, leftSum + S[n], rightSum, n - 1, lookUp);
            int excl = min(S, leftSum, rightSum + S[n], n - 1, lookUp);

            lookUp.put(s, Math.min(incl, excl));
        }

        return lookUp.get(s);
    }
}
