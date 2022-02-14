package com.company.Array;

import java.util.Random;

public class Probability6 {
    /*

    Given an integer array, return any one of its elements according to the given probabilities.

    Input:

    nums[] = [1, 2, 3, 4, 5]
    probability[] = [30, 10, 20, 15, 25]

    Output: The solution should return 1 with 30% probability, 2 with 10% probability, 3 with 20% probability, 4 with 15% probability, and 5 with 25% probability.

    Assume that the total probability sums to 100%.

    */
    public static int findRandom(int[] nums, int[] probability){
        Random rand = new Random();
        int r = rand.nextInt(100) + 1;

        int temp = 0;

        for (int i = 0; i < probability.length; i++){
            temp += probability[i];
            if (r <= temp)
                return nums[i];
        }

        return -1;
    }
}
