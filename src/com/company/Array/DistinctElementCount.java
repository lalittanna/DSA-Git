package com.company.Array;

import java.util.*;

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

        Map<Integer, Integer> map = new HashMap<>();

        int distinct = 0;

        for (int i = 0; i < nums.size(); i++){
            if (i >= k){
                map.put(nums.get(i - k), map.getOrDefault(nums.get(i - k), 0) - 1);

                if (map.get(nums.get(i - k)) == 0)
                    distinct--;
            }

            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);

            if (map.get(nums.get(i)) == 1)
                distinct++;

            if (i >= k - 1)
                list.add(distinct);
        }

        return list;

        // List<Integer> list = new ArrayList<>();

        // for (int i = 0; i < nums.size() - (k - 1); i++){
        // 	Set<Integer> set = new HashSet<>();

        // 	set.addAll(nums.subList(i, i + k));
        // 	list.add(set.size());
        // }

        // return list;
    }
}
