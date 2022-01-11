package com.company.Array;

public class MergeSortedArray3 {
    /*

Given two sorted integer arrays `X[]` and `Y[]` of size `m` and `n` each where `m >= n` and `X[]` has exactly `n` vacant cells, merge elements of `Y[]` in their correct position in array `X[]`, i.e., merge `(X, Y)` by keeping the sorted order.

Input : Two arrays X[] and Y[] where vacant cells in X[] is represented by 0.

X[] = [0, 2, 0, 3, 0, 5, 6, 0, 0]
Y[] = [1, 8, 9, 10, 15]

Output: X[] = [1, 2, 3, 5, 6, 8, 9, 10, 15]

*/
    public static void merge(int[] X, int[] Y)
    {
        int k = 0;

        for (int value : X){
            if (value != 0)
                X[k++] = value;
        }

        k = k - 1;

        int i = X.length - 1;
        int j = Y.length - 1;

        while (k >= 0 && j >= 0){
            if (X[k] > Y[j])
                X[i--] = X[k--];
            else
                X[i--] = Y[j--];
        }

        while (j >= 0){
            X[i--] = Y[j--];
        }
    }
}
