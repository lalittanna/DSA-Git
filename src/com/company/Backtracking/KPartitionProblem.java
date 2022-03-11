package com.company.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KPartitionProblem {
    /*

    Given an array of positive integers, partition it into `k` disjoint subsets that all have an equal sum, and they completely cover the array.

    Input : S[] = [7, 3, 5, 12, 2, 1, 5, 3, 8, 4, 6, 4], k = 2
    Output: [[5, 3, 8, 4, 6, 4], [7, 3, 5, 12, 2, 1]] or [[4, 5, 6, 7, 8], [1, 2, 3, 3, 4, 5, 12]]
    Explanation: S can be partitioned into 2 partitions, each having a sum of 30.

    Input : S[] = [7, 3, 5, 12, 2, 1, 5, 3, 8, 4, 6, 4], k = 3
    Output: [[2, 1, 3, 4, 6, 4], [7, 5, 8], [3, 5, 12]]
    Explanation: S can be partitioned into 3 partitions, each having a sum of 20.

    Input : S[] = [7, 3, 5, 12, 2, 1, 5, 3, 8, 4, 6, 4], k = 4
    Output: [[1, 4, 6, 4], [2, 5, 8], [12, 3], [7, 3, 5]]
    Explanation: S can be partitioned into 4 partitions, each having a sum of 15.

    Input : S[] = [7, 3, 5, 12, 2, 1, 5, 3, 8, 4, 6, 4], k = 5
    Output: [[2, 6, 4], [8, 4], [3, 1, 5, 3], [12], [7, 5]]
    Explanation: S can be partitioned into 5 partitions, each having a sum of 12.

    Input : S[] = [3, 5, 7, 3, 2, 1], k = 2
    Output: []

    */
    public static List<List<Integer>> getSubsets(List<Integer> nums, int k){
        List<List<Integer>> subsets = new ArrayList<>();

        if (nums.size() < k) return subsets;

        int[] A = new int[nums.size()];

        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        int[] sums = new int[k];
        Arrays.fill(sums, sum / k);

        boolean result = (sum % k) == 0 && subsets(nums, A, sums, nums.size() - 1);

        if (result){
            for (int i = 0; i < k; i++){
                List<Integer> list = new ArrayList<>();

                for (int j = 0; j < A.length; j++)
                    if (A[j] == i + 1) list.add(nums.get(j));

                subsets.add(list);
            }
        }

        return subsets;
    }

    public static boolean subsets(List<Integer> nums, int[] A, int[] sums, int n){
        if (checkSum(sums)) return true;

        if (n < 0) return false;

        boolean result = false;

        for (int i = 0; i < sums.length; i++){
            if (!result && sums[i] - nums.get(n) >= 0){
                A[n] = i + 1;
                sums[i] -= nums.get(n);

                result = subsets(nums, A, sums, n - 1);

                sums[i] += nums.get(n);
            }
        }

        return result;
    }

    public static boolean checkSum(int[] sums){
        for (int sum : sums) if (sum != 0) return false;
        return true;
    }
}
