package com.company.Array;

import java.util.*;

public class ArithemeticTriplets {
    /*

    Given a sorted array of distinct positive integers, return all triplets that forms an arithmetic progression with an integral common difference. An arithmetic progression is a sequence of numbers such that the difference between the consecutive terms is constant.

    Input : [5, 8, 9, 11, 12, 15]
    Output: {[5, 8, 11], [9, 12, 15]}

    Input : [1, 3, 5, 6, 8, 9, 15]
    Output: {[1, 3, 5], [1, 5, 9], [3, 6, 9], [1, 8, 15], [3, 9, 15]}

    */
    public static Set<List<Integer>> findTriplets(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();

        for (int j = 1; j < nums.length - 1; j++){
            int i = j - 1, k = j + 1;

            while (i >= 0 && k < nums.length){
                if (nums[i] + nums[k] == 2 * nums[j]){
                    List<Integer> list = new ArrayList<>();
                    Collections.addAll(list, nums[i], nums[j], nums[k]);
                    triplets.add(list);

                    i--; k++;
                } else if (nums[i] + nums[k] < 2 * nums[j])
                    k++;
                else
                    i--;
            }
        }


        // Set<Integer> set = new HashSet<>();

        // for (int num : nums)
        // 	set.add(num);

        // for (int i = 0; i < nums.length - 2; i++){
        // 	for (int j = i + 1; j < nums.length - 1; j++){
        // 		int sum = nums[i] + nums[j];

        // 		if (set.contains(nums[j] + nums[j] - nums[i])){
        // 			List<Integer> list = new ArrayList<>();
        // 			Collections.addAll(list, nums[i], nums[j], nums[j] + nums[j] - nums[i]);
        // 			triplets.add(list);
        // 		}
        // 	}
        // }

        // for (int i = 0; i < nums.length - 2; i++){
        // 	for (int j = i + 1; j < nums.length - 1; j++){
        // 		int sum = nums[i] + nums[j];
        // 		for (int k = j + 1; k < nums.length; k++){
        // 			sum += nums[k];

        // 			if (nums[k] - nums[j] == nums[j] - nums[i]){
        // 				List<Integer> list = new ArrayList<>();
        // 				Collections.addAll(list, nums[i], nums[j], nums[k]);
        // 				triplets.add(list);
        // 			}

        // 			sum -= nums[k];
        // 		}
        // 	}
        // }

        return triplets;
    }
}
