package com.company.Array;

public class BuyNSellStock {
    /*

    Given a list containing future predictions of share prices and a positive integer `k`, find the maximum profit earned by buying and selling shares at most `k` times with a constraint that a new transaction can only start after the previous transaction is complete, i.e., you can only hold at most one share at a time.

    Input: price[]: [2, 4, 7, 5, 4, 3, 5], k = 2
    Output: 7
    Explanation: The maximum profit is 7 (sum of 5 and 2)

    • Buy at a price 2 and sell at a price 7
    • Buy at a price 3 and sell at a price 5


    Input: price[]: [1, 5, 2, 3, 7, 6, 4, 5], k = 3
    Output: 10
    Explanation: The maximum profit is 10 (sum of 4, 5, and 1).

    • Buy at a price 1 and sell at a price 5
    • Buy at a price 2 and sell at a price 7
    • Buy at a price 4 and sell at a price 5


    Input: price[]: [10, 6, 8, 4, 2], k = 2
    Output: 2
    Explanation: The maximum profit is 2. Buy at a price 6 and sell at a price 8.


    Input: price[]: [10, 8, 6, 5, 4, 2], k = 1
    Output: 0
    Explanation: Prices are given in descending order.

    */
    public static int findMaximumProfit(int[] price, int k){
        if (price.length == 0) return 0;

        int[][] maxProfit = new int[k + 1][price.length + 1];

        for (int i = 0;  i <= k; i++){
            int prevDiff= Integer.MIN_VALUE;

            for (int j = 0; j < price.length; j++){
                if (i == 0 || j == 0)
                    maxProfit[i][j] = 0;
                else {
                    prevDiff = Math.max(prevDiff, maxProfit[i - 1][j - 1] - price[j - 1]);

                    maxProfit[i][j] = Math.max(maxProfit[i][j - 1], price[j] + prevDiff);
                }
            }
        }

        return maxProfit[k][price.length - 1];
    }
}
