package com.company.Array;

import java.util.*;

public class KSumSubArray2 {
    /*

Given an integer array, find all contiguous subarrays with a given sum `k`.

Input : nums[] = [3, 4, -7, 1, 3, 3, 1, -4], k = 7
Output: {[3, 4], [3, 4, -7, 1, 3, 3], [1, 3, 3], [3, 3, 1]}

Since the input can have multiple subarrays with sum `k`, the solution should return a set containing all the distinct subarrays.

*/
    public static Set<List<Integer>> getAllSubarrays(List<Integer> nums, int k)
    {
        Set<List<Integer>> subarrays = new HashSet<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        insert(map, 0, -1);

        int sum = 0;

        for (int i = 0; i < nums.size(); i++){
            sum += nums.get(i);
            if (map.containsKey(sum - k)){
                List<Integer> list = map.get(sum - k);
                for (Integer value: list){
                    List<Integer> subArray = nums.subList(value + 1, i + 1);
                    subarrays.add(subArray);
                }
            }
            insert(map, sum, i);
        }

        return subarrays;

        // Set<List<Integer>> subarrays = new HashSet<>();

        // for (int i = 0; i < nums.size(); i++){
        // 	int sum = 0;
        // 	for (int j = i; j < nums.size(); j++){
        // 		sum += nums.get(j);
        // 		if (sum == k){
        // 			List<Integer> list = new ArrayList<>();
        // 			for (int m = i; m <= j; m++)
        // 				list.add(nums.get(m));
        // 			subarrays.add(list);
        // 		}
        // 	}
        // }

        // return subarrays;
    }

    public static void insert(Map<Integer, List<Integer>> map, Integer key, Integer value){
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(value);
    }
}
