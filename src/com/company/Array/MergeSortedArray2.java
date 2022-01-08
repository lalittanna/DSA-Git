package com.company.Array;

/*

Given two sorted integer arrays, merge them into a single array in decreasing order, and return it. In other words, merge two sorted arrays from their end.

Input : X = [1, 3, 5], Y = [2, 6, 7, 10]
Output: [10, 7, 6, 5, 3, 2, 1]

*/
public class MergeSortedArray2 {
    public static int[] merge(int[] X, int[] Y)
    {
        int[] mergedArray = new int[X.length + Y.length];

        int i = X.length - 1, j = Y.length - 1, k = 0;

        while (i >= 0 && j >= 0){
            if (X[i] > Y[j])
                mergedArray[k++] = X[i--];
            else
                mergedArray[k++] = Y[j--];
        }

        while (i >= 0)
            mergedArray[k++] = X[i--];
        while (j >= 0)
            mergedArray[k++] = Y[j--];

        return mergedArray;
    }
}
