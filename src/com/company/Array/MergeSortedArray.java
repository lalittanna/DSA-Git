package com.company.Array;

/*

Given two integer arrays, each of which is sorted in increasing order, merge them into a single array in increasing order, and return it.

Input: X = [1, 3, 5, 7], Y = [2, 4, 6]
Output: [1, 2, 3, 4, 5, 6, 7]

*/
public class MergeSortedArray {
    public static int[] merge(int[] X, int[] Y)
    {
        int[] mergedArray = new int[X.length + Y.length];

        int i = 0, j = 0, k = 0;

        while (i < X.length && j < Y.length){
            if (X[i] < Y[j])
                mergedArray[k++] = X[i++];
            else
                mergedArray[k++] = Y[j++];
        }

        while (i < X.length)
            mergedArray[k++] = X[i++];
        while (j < Y.length)
            mergedArray[k++] = Y[j++];

        return mergedArray;
    }
}
