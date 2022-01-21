package com.company.Array;

import java.util.*;

public class LargestDistinctSubArrays {
    /*

    Given an integer array, find all maximum size contiguous subarrays having all distinct elements in them.

    Input : [5, 2, 3, 5, 4, 3]
    Output: {[5, 2, 3], [2, 3, 5, 4], [5, 4, 3]}

    Input : [1, 2, 3, 3]
    Output: {[1, 2, 3], [3]}

    Input : [1, 2, 3, 4]
    Output: {[1, 2, 3, 4]}

    Note: Since an input can have multiple subarrays with all distinct elements, the solution should return a set containing all the distinct subarrays.

    */
    public static Set<List<Integer>> findDistinctSubarrays(List<Integer> nums){
        Set<List<Integer>> subarrays = new HashSet<>();

        Map<Integer, Boolean> map = new HashMap<>();

        for (Integer num : nums)
            map.put(num, false);

        int left = 0, right = 0;

        while (right < nums.size()) {
            while (right < nums.size() && !map.get(nums.get(right))) {
                map.put(nums.get(right), true);
                right++;
            }

            List<Integer> list = new ArrayList<>();
            for (int i = left; i < right; i++){
                list.add(nums.get(i));
            }
            subarrays.add(list);

            while (right < nums.size() && map.get(nums.get(right))) {
                map.put(nums.get(left), false);
                left++;
            }
        }

        return subarrays;
    }
}
