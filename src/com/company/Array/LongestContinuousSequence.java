package com.company.Array;

import java.util.HashMap;
import java.util.Map;

public class LongestContinuousSequence {
    /*

    Given two binary arrays, `X` and `Y`, find the length of the longest continuous sequence that starts and ends at the same index in both arrays and have the same sum. In other words, find `max(j-i+1)` for every `j >= i`, where the sum of subarray `X[i, j]` is equal to the sum of subarray `Y[i, j]`.

    Input:

    X[]: [0, 0, 1, 1, 1, 1]
    Y[]: [0, 1, 1, 0, 1, 0]

    Output: 5
    Explanation: The length of the longest continuous sequence with the same sum is 5 as

    X[0, 4]: [0, 0, 1, 1, 1]	(sum = 3)
    Y[0, 4]: [0, 1, 1, 0, 1]	(sum = 3)

    */
    public static int findMaxSubarrayLength(int[] X, int[] Y){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int max = 0;

        int sumX = 0;
        int sumY = 0;

        for (int i = 0; i < X.length; i++){
            sumX += X[i];
            sumY += Y[i];

            int difference = sumX - sumY;

            if (!map.containsKey(difference))
                map.put(difference, i);
            else
                max = Integer.max(max, i - map.get(difference));
        }

        return max;
    }
}
