package com.company.Array;

import java.util.*;

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

        Arrays.sort(nums);
        Stack<Integer> output = new Stack<>();
        findAllCombinations(combinations, nums, 0, k, output);

        return combinations;
    }

    public static void findAllCombinations(Set<List<Integer>> set, int[] nums, int i, int k, Stack<Integer> output){
        if (output.size() == k){
            List<Integer> list = new ArrayList<>(output);
            Collections.reverse(list);
            set.add(list);
            return;
        }

        for (int j = i; j < nums.length; j++){
            output.add(nums[j]);
            findAllCombinations(set, nums, j, k, output);

            output.pop();

            while (j < nums.length - 1 && nums[j] == nums[j + 1])
                j++;
        }
    }
}
