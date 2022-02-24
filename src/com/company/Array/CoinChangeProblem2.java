package com.company.Array;

import java.util.Map;

public class CoinChangeProblem2 {
    /*

    Given an unlimited supply of coins of given denominations, find the total number of distinct ways to get the desired change.

    Input: S = [1, 3, 5, 7], target = 8
    Output: 6
    Explanation: The total number of ways is 6

    [1, 7]
    [3, 5]
    [1, 1, 3, 3]
    [1, 1, 1, 5]
    [1, 1, 1, 1, 1, 3]
    [1, 1, 1, 1, 1, 1, 1, 1]


    Input: S = [1, 2, 3], target = 4
    Output: 4
    Explanation: The total number of ways is 4

    [1, 3]
    [2, 2]
    [1, 1, 2]
    [1, 1, 1, 1]

    */
    public static int findWays(int[] S, int target){
        int T[] = new int[target + 1];
        T[0] = 1;

        for (int i = 0; i < S.length; i++){
            for (int j = S[i]; j <= target; j++)
                T[j] += T[j - S[i]];
        }

        return T[target];

        //return ways(S, target, S.length - 1, new HashMap<>());
    }

    public static int ways(int[] S, int target, int n, Map<String, Integer> map){
        if (target == 0) return 1;

        if (target < 0 || n < 0) return 0;

        String key = n + "|" + target;

        if (!map.containsKey(key)){
            int incl = ways(S, target - S[n], n, map);
            int excl = ways(S, target, n - 1, map);

            map.put(key, incl + excl);
        }

        return map.get(key);
    }
}
