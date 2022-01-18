package com.company.Array;

import java.util.ArrayList;
import java.util.List;

public class DecodeArray {
    /*

    Given an integer array `X`, which is constructed by taking the sum of every distinct pair from another array `Y`, decode `X` to get the original array back. If the original array is `Y[0], Y[1], … , Y[n-1]`, then the input array `X` is:

    [
      (Y[0] + Y[1]), (Y[0] + Y[2]), … (Y[0] + Y[n-1]),
      (Y[1] + Y[2]), (Y[1] + Y[3]), … (Y[1] + Y[n-1]),
      …
      …
      (Y[i] + Y[i+1]), (Y[i] + Y[i+2]), … (Y[i] + Y[n-1]),
      …
      …
      (Y[n-2] + Y[n-1])
    ]

    Input : [3, 4, 5, 5, 6, 7]
    Output: [1, 2, 3, 4]
    Explanation: The input array [3, 4, 5, 5, 6, 7] is formed by the sum of every distinct pair of the output array [(1 + 2), (1 + 3), (1 + 4), (2 + 3), (2 + 4), (3 + 4)]

    Input : [3, 4, 5, 6, 5, 6, 7, 7, 8, 9]
    Output: [1, 2, 3, 4, 5]

    Input : [3, 4, 5]
    Output: [1, 2, 3]


    Note: Assume valid input and input size > 2

    */
    public static List<Integer> decode(List<Integer> nums)
    {
        int m = nums.size();

        if (m < 3)
            return nums;

        List<Integer> list = new ArrayList<>();

        // m = n (n - 1) / 2
        int n = (int)(Math.sqrt(8 * m + 1) + 1) / 2;

        // Added the first element -> A[0] = (inp[0] + inp[1] - inp[n-1]) / 2. inp[n - 1] == A[1] + A[2]
        list.add((nums.get(0) + nums.get(1) - nums.get(n - 1)) / 2);

        // from this (Y[0] + Y[1]), (Y[0] + Y[2]), … (Y[0] + Y[n-1])
        for (int i = 1; i < n; i++)
            list.add(nums.get(i - 1) - list.get(0));

        return list;
    }
}
