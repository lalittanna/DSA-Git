package com.company.Array;

import java.util.Map;

public class O1KnapsackProblem {
    /*

    Given a set of items, each with a weight and a value, determine the number of each item to include in a collection so that the total weight is less than or equal to a given limit and the total value is as large as possible. Note that the items are indivisible; we can either take an item or not (0-1 property).

    Input:

    value = [20, 5, 10, 40, 15, 25]
    weight = [1, 2, 3, 8, 7, 4]
    int W = 10

    Output: 60

    Explanation: Knapsack value is 60

    value = 20 + 40 = 60
    weight = 1 + 8 = 9 <= W

    */
    public static int findKnapsackValue(int[] value, int[] weight, int W){
        //return knapSack(value, weight, W, value.length - 1, new HashMap<>());

        int[][] T = new int[value.length + 1][W + 1];

        for (int i = 1; i <= value.length; i++){
            for (int j = 0; j <= W; j++){
                if (weight[i - 1] > j)
                    T[i][j] = T[i - 1][j];
                else
                    T[i][j] = Math.max(T[i - 1][j], T[i - 1][j- weight[i - 1]] + value[i - 1]);
            }
        }

        return T[value.length][W];
    }

    //Dynamic Programming
    public static int knapSack(int[] v, int[] w, int W, int n, Map<String, Integer> lookUp){
        if (W < 0)
            return Integer.MIN_VALUE;

        if (n < 0 || W == 0)
            return 0;

        String key = n + "|" + W;

        if (!lookUp.containsKey(key)){
            int include = v[n] + knapSack(v, w, W - w[n], n - 1, lookUp);
            int exclude = knapSack(v, w, W, n - 1, lookUp);

            lookUp.put(key, Integer.max(include, exclude));
        }

        return lookUp.get(key);
    }
}
