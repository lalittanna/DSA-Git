package com.company.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllCombinations {
    /*

Given an integer array, find all distinct combinations of a given length `k`. The solution should return a set containing all the distinct combinations, while preserving the relative order of elements as they appear in the array.

Input : [2, 3, 4], k = 2
Output: {[2, 3], [2, 4], [3, 4]}

Input : [1, 2, 1], k = 2
Output: {[1, 2], [1, 1], [2, 1]}

Input : [1, 1, 1], k = 2
Output: {[1, 1]}

Input : [1, 2, 3], k = 4
Output: {}

Input : [1, 2], k = 0
Output: {[]}

*/
    public static Set<List<Integer>> findCombinations(List<Integer> nums, int k)
    {
        Set<List<Integer>> subarrays = new HashSet<>();

        findCombinations(nums, 0, k, subarrays, new ArrayList<>());

        return subarrays;
    }

    public static void findCombinations(List<Integer> nums,
    int i, int k, Set<List<Integer>> subarrays, List<Integer> list){

        // Invalid input
        if (nums.size() == 0 || k > nums.size())
            return;

        // base case
        if (k == 0){
            subarrays.add(new ArrayList<>(list));
            return;
        }

        //
        for (int j = i; j < nums.size(); j++){
            list.add(nums.get(j));
            findCombinations(nums, j + 1, k - 1, subarrays, list);
            list.remove(list.size() - 1);  // backtrack
        }
    }
}
