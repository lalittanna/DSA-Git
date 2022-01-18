package com.company.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeSum2 {
    /*

    Given an unsorted integer array, find a triplet with a given sum `k` in it.

    Input : [4, -1, 1, 2, -1], k = 0
    Output: [-1, 2, -1]

    Input : [4, 5, 4, -1, 3], k = 10
    Output: []
    Explanation: No triplet exists with sum 10.

    If the input contains several triplets with sum `k`, the solution can return any one of them.

    Input : nums[] = [2, 7, 4, 0, 9, 5, 1, 3], k = 6
    Output: [0, 1, 5] or [0, 2, 4] or [1, 2, 3]

    Note: The solution can return the triplet in any order, not necessarily as they appear in the array.

    */
    public static List<Integer> findTriplets(List<Integer> nums, int k){
        List<Integer> list = new ArrayList<>();

        Collections.sort(nums);

        for (int i = 0; i < nums.size() - 2; i++){
            int remainingSum = k - nums.get(i);

            int low = i + 1;
            int high = nums.size() - 1;

            while (low < high){
                if (nums.get(low) + nums.get(high) < remainingSum)
                    low++;
                else if (nums.get(low) + nums.get(high) > remainingSum)
                    high--;
                else{
                    Collections.addAll(list, nums.get(i), nums.get(low), nums.get(high));
                    return list;
                }
            }
        }

        return list;

        // List<Integer> list = new ArrayList<>();

        // Map<Integer, Integer> map = new HashMap<>();

        // for (int i = 0; i < nums.size(); i++)
        // 	map.put(nums.get(i), i);

        // for (int i = 0; i < nums.size() - 1; i++){
        // 	for (int j = i + 1; j < nums.size(); j++){
        // 		int sum = nums.get(i) + nums.get(j);

        // 		if (map.containsKey(k - sum) && map.get(k - sum) != i && map.get(k - sum) != j){
        // 			Collections.addAll(list, k - sum, nums.get(i), nums.get(j));
        // 			return list;
        // 		}
        // 	}
        // }

        // return list;
    }
}
