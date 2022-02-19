package com.company.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreePartitionProblem2 {
/*

Given an array of positive integers, which can be partitioned into three disjoint subsets having the same sum, return the partitions.

Input: S = [7, 3, 2, 1, 5, 4, 8]
Output: [[7, 3], [5, 4, 1], [8, 2]]
Explanation: S can be partitioned into three partitions, each having a sum of 10.

Note that there can be multiple solutions to a single set, the procedure can return any one of them.

*/

    public static List<List<Integer>> partition(int[] S){
        List<List<Integer>> subsets = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        int sum = Arrays.stream(S).sum();
        int[] A = new int[S.length];

        boolean result = (S.length >= 3 && sum % 3 == 0 && isSubsetExist(S, S.length - 1, sum / 3, sum / 3, sum / 3, A));

        if (!result)
            return subsets;

        for (int i = 0; i < A.length; i++){
            if (A[i] == 1)
                list1.add(S[i]);
            else if (A[i] == 2)
                list2.add(S[i]);
            else
                list3.add(S[i]);
        }

        Collections.addAll(subsets, list1, list2, list3);

        return subsets;
    }

    public static boolean isSubsetExist(int[] S, int n, int a, int b, int c, int[] arr){
        if (a == 0 && b == 0 && c == 0)
            return true;

        if (n < 0)
            return false;

        boolean A = false;
        if (a - S[n] >= 0){
            arr[n] = 1;
            A = isSubsetExist(S, n - 1, a - S[n], b, c, arr);
        }

        boolean B = false;
        if (!A && b - S[n] >= 0){
            arr[n] = 2;
            B = isSubsetExist(S, n - 1, a, b - S[n], c, arr);
        }

        boolean C = false;
        if (!A && !B && c - S[n] >= 0){
            arr[n] = 3;
            C = isSubsetExist(S, n - 1, a, b, c - S[n], arr);
        }

        return A || B || C;
    }
}
