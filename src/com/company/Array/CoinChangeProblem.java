package com.company.Array;

public class CoinChangeProblem {
    /*

    Given an unlimited supply of coins of given denominations, find the minimum number of coins required to get the desired change.

    Input: S = [1, 3, 5, 7], target = 15
    Output: 3
    Explanation: The minimum number of coins required is 3 (7 + 7 + 1) or (5 + 5 + 5) or (3 + 5 + 7)

    Input: S = [1, 3, 5, 7], target = 18
    Output: 4
    Explanation: The minimum number of coins required is 4 (7 + 7 + 3 + 1) or (5 + 5 + 5 + 3) or (7 + 5 + 5 + 1)

    If desired change is not possible, the solution should return -1.

    Input: S = [2, 4, 6, 8], target = 15
    Output: -1

    */
    public static int findMinCoins(int[] S, int target){
        int[] T = new int[target + 1];

        for (int i = 1; i <= target; i++){
            T[i] = Integer.MAX_VALUE;
            int result = Integer.MAX_VALUE;

            for (int c : S){
                if (i - c >= 0)
                    result = T[i - c];

                if (result != Integer.MAX_VALUE)
                    T[i] = Integer.min(T[i], result + 1);
            }
        }

        if (T[target] == Integer.MAX_VALUE)
            return -1;
        return T[target];

        // int min = minCoins(S, target);
        // if (min == Integer.MAX_VALUE)
        // 	return -1;
        // return min;
    }

    public static int minCoins(int[] S, int target){
        if (target == 0)
            return 0;
        if (target < 0)
            return Integer.MAX_VALUE;

        int coins = Integer.MAX_VALUE;

        for (int c: S){
            int result = findMinCoins(S, target - c);

            if (result != Integer.MAX_VALUE) {
                coins = Integer.min(coins, result + 1);
            }
        }

        return coins;
    }
}
