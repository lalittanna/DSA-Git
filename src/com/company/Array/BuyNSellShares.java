package com.company.Array;

public class BuyNSellShares {
    /*

    Given a list containing future prediction of share prices, find the maximum profit earned by buying and selling shares any number of times with the constraint, a new transaction can only start after the previous transaction is complete, i.e., you can only hold at most one share at a time.

    Input : [1, 5, 2, 3, 7, 6, 4, 5]
    Output: 10
    Explanation: Total profit earned is 10

    Buy on day 1 and sell on day 2
    Buy on day 3 and sell on day 5
    Buy on day 7 and sell on day 8


    Input : [10, 8, 6, 5, 4, 2]
    Output: 0

    */
    public static int findMaxProfit(int[] price) {
        if (price.length < 2)
            return 0;

        int profit = 0;

        int j = 0;

        for (int i = 1; i < price.length; i++){
            if (price[i - 1] > price[i])
                j = i;

            if (price[i - 1] <= price[i] && (i + 1 == price.length || price[i] > price[i + 1]))
                profit += price[i] - price[j];
        }

        return profit;

        // int Total = 0;

        // int i = 0;

        // while (i < price.length){
        // 	int initialBuy = price[i];
        // 	int initialSell = price[i];

        // 	while (i < price.length && price[i] >= initialSell)
        // 		initialSell = price[i++];

        // 	Total += initialSell - initialBuy;
        // }

        // return Total;
    }
}
