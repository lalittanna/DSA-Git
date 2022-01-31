package com.company.Array;

import java.util.*;

public class Combinations3 {
    /*

Given a positive number `n`, find all combinations of `2×n` elements such that every element from 1 to `n` appears exactly twice and the distance between its two appearances is exactly equal to the value of the element.

Input : n = 3
Output: {[3, 1, 2, 1, 3, 2], [2, 3, 1, 2, 1, 3]}

Input : n = 4
Output: {[4, 1, 3, 1, 2, 4, 3, 2], [2, 3, 4, 2, 1, 3, 1, 4]}

Input : n = 5
Output: {}

*/
    public static Set<List<Integer>> findCombinations(int n){
        Set<List<Integer>> combinations = new HashSet<>();

        Integer[] nums = new Integer[2 * n];
        Arrays.fill(nums, 0);

        findAllCombinations(combinations, nums, 1, n);

        return combinations;
    }

    public static void findAllCombinations(Set<List<Integer>> set, Integer[] nums, int x, int n){
        if (x > n){
            List<Integer> list = new ArrayList<>();
            for (Integer num : nums)
                list.add(num);

            set.add(list);
        }

        for (int i = 0; i < 2 * n; i++){
            if (nums[i] == 0 && (i + x + 1) < 2 * n && nums[i + x + 1] == 0){
                nums[i] = x;
                nums[i + x + 1] = x;

                findAllCombinations(set, nums, x + 1, n);

                nums[i] = 0;
                nums[i + x + 1] = 0;
            }
        }
    }
}
