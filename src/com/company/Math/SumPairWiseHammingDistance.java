package com.company.Math;

public class SumPairWiseHammingDistance {
//    Hamming distance between two non-negative integers is defined as the number of positions at which the corresponding bits are different.
//    Given an array A of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array. Return the answer modulo 1000000007.
    public static int hammingDistance(final int[] A) {
        int differentBits = 0;

        int n = A.length;
        for (int i = 0; i < 31; i++){
            int oneCount = 0;
            for (int j = 0; j < n; j++)
                oneCount += ((A[j] & (1 << i)) != 0) ? 1 : 0;
            int zeroCount = n - oneCount;
            differentBits += (2L * oneCount * zeroCount) % 1000000007;
            differentBits %= 1000000007;
        }

        return differentBits;

        // int differentBits = 0;
        // for (int i = 0; i < A.length - 1; i++){
        //     for (int j = i + 1; j < A.length; j++)
        //         if (i != j) differentBits += 2 * distance(A[i], A[j]);
        // }

        // return (int) (differentBits % 1000000007);
    }

    public static int distance (int a, int b){
        int differentBits = 0;
        while (a != 0 || b != 0){
            if ((a & 1) != (b & 1))
                differentBits++;
            a >>= 1;
            b >>= 1;
        }

        return differentBits;
    }
}
