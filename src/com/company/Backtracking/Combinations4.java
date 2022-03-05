package com.company.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combinations4 {
    /*

    Given an integer array, find all distinct combinations of a given length `k`, where the repetition of elements is allowed.

    Input : [1, 2, 3], k = 2
    Output: {[1, 1], [1, 2], [1, 3], [2, 2], [2, 3], [3, 3]}

    Input : [1, 1, 1], k = 2
    Output: {[1, 1]}

    Input : [1, 2], k = 0
    Output: {[]}

    Input : [], k = 1
    Output: {}

    The solution should consider only distinct combinations. For example, either [1, 1, 2] or [1, 2, 1] or [2, 1, 1] should be considered for the below input. Same goes for [1, 2, 2] or [2, 1, 2] or [2, 2, 1].

    Input : [1, 2, 1], k = 3
    Output: {[1, 1, 1], [1, 1, 2], [1, 2, 2], [2, 2, 2]}

    */
    public static Set<List<Integer>> findCombinations(int[] nums, int k){
        Set<List<Integer>> combinations = new HashSet<>();

        combinations(combinations, new ArrayList<>(), nums, k);

        return combinations;
    }

    public static void combinations(Set<List<Integer>> combinations, List<Integer> list, int[] nums, int k){
        if (k == 0){
            List<Integer> path = new ArrayList<>(list);
            combinations.add(path);
            return;
        }

        for (int i = 0; i < nums.length; i++){
            list.add(nums[i]);

            combinations(combinations, list, nums, k - 1);

            list.remove(list.size() - 1);
        }
    }
}
