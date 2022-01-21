package com.company.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistinctElementCount {
    /*

    Given an integer array and a positive integer `k`, find the count of distinct elements in every contiguous subarray of size `k`.

    Input : nums[] = [2, 1, 2, 3, 2, 1, 4, 5], k = 5
    Output: [3, 3, 4, 5]
    Explanation:

    The count of distinct elements in subarray [2, 1, 2, 3, 2] is 3
    The count of distinct elements in subarray [1, 2, 3, 2, 1] is 3
    The count of distinct elements in subarray [2, 3, 2, 1, 4] is 4
    The count of distinct elements in subarray [3, 2, 1, 4, 5] is 5


    Input : nums[] = [1, 1, 2, 1, 3], k = 3
    Output: [2, 2, 3]
    Explanation:

    The count of distinct elements in subarray [1, 1, 2] is 2
    The count of distinct elements in subarray [1, 2, 1] is 2
    The count of distinct elements in subarray [2, 1, 3] is 3

    */
    public static List<Integer> findDistinctCount(List<Integer> nums, int k)
    {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.size() - (k - 1); i++){
            Set<Integer> set = new HashSet<>();

            set.addAll(nums.subList(i, i + k));
            list.add(set.size());
        }

        return list;
    }
}
