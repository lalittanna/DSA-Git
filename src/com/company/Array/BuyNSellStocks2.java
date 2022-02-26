package com.company.Array;

public class BuyNSellStocks2 {
    /*

    Given a list containing future predictions of share prices, find the maximum profit earned by buying and selling shares at most twice with a constraint that a new transaction can only start after the previous transaction complete, i.e., we can only hold at most one share at a time.

    Input: [2, 4, 7, 5, 4, 3, 5]
    Output: 7
    Explanation: The maximum profit is 7. You can buy at a price 2 and sell at a price 7. Then, buy at a price 3 and sell at a price 5.

    Input: [10, 6, 8, 4, 2]
    Output: 2
    Explanation: The maximum profit is 2. You can buy at a price 6 and sell at a price 8.

    Input: [8, 7, 6, 4]
    Output: 0
    Explanation: The maximum profit is 0 as buying and selling stock will result in loss.

    */
    public static int findMaximumProfit(int[] price){
        int n = price.length;

        if (n == 0) return 0;

        int[] profit = new int[n];

        int maxSoFar = price[n - 1];

        for (int i = n - 2; i >= 0; i--){
            profit[i] = Math.max(profit[i + 1], maxSoFar - price[i]);

            maxSoFar = Math.max(maxSoFar, price[i]);
        }

        int minSoFar = price[0];

        for (int i = 1; i < n; i++){
            profit[i] = Math.max(profit[i - 1], (price[i] - minSoFar) + profit[i]);

            minSoFar = Math.min(minSoFar, price[i]);
        }

        return profit[n - 1];
    }
}
