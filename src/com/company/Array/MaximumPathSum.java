package com.company.Array;

public class MaximumPathSum {
    /*

    Given two sorted arrays of integers, find a maximum sum path involving elements of both arrays whose sum is maximum. You can start from either array, but can switch between arrays only through its common elements.

    Input:

    X = [3, 6, 7, 8, 10, 12, 15, 18, 100]
    Y = [1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50]

    Output: The maximum sum is 199

    Explanation: The maximum sum path is 1 —> 2 —> 3 —> 6 —> 7 —> 9 —> 10 —> 12 —> 15 —> 16 —> 18 —> 100

    */
    public static int findMaxPathSum(int[] X, int[] Y) {
        int i = 0, j = 0;
        int sum = 0;
        int sum1 = 0, sum2 = 0;

        while (i < X.length && j < Y.length){
            if (X[i] < Y[j])
                sum1 += X[i++];
            else if (X[i] > Y[j])
                sum2 += Y[j++];
            else{
                sum += Math.max(sum1, sum2);
                sum1 = sum2 = 0;

                int temp = i;

                // adding duplicates
                while (i < X.length && X[i] == Y[j])
                    sum1 += X[i++];

                while (j < Y.length && Y[j] == X[temp])
                    sum2 += Y[j++];

                sum += Math.max(sum1, sum2);

                sum1 = sum2 = 0;
            }
        }

        // adding rest of the left elements
        while (i < X.length)
            sum1 += X[i++];

        while (j < Y.length)
            sum2 += Y[j++];

        sum += Math.max(sum1, sum2);

        return sum;
    }
}
