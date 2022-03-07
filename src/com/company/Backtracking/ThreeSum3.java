package com.company.Backtracking;

import java.util.*;

public class ThreeSum3 {
    /*

    Given an unsorted integer array, find all triplets in it with sum less than or equal to a given number.

    Input : nums[] = [2, 7, 4, 9, 5, 1, 3], target = 10
    Output: {[1, 2, 3], [1, 2, 4], [1, 2, 5], [1, 2, 7], [1, 3, 4], [1, 3, 5], [1, 4, 5], [2, 3, 4], [2, 3, 5]}

    Input : nums[] = [3, 5, 7, 3, 2, 1], target = 5
    Output: {}

    Since the input can have multiple triplets with sum less than or equal to the target, the solution should return a set containing all the distinct triplets in any order.

    */
    public static Set<List<Integer>> getTriplets(int[] nums, int target){
        Set<List<Integer>> subsets = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++){
            int low = i + 1, high = nums.length - 1;

            while (low < high){
                if (nums[i] + nums[low] + nums[high] > target) high--;
                else {
                    for (int j = low + 1; j <= high; j++){
                        List<Integer> list = new ArrayList<>();

                        Collections.addAll(list, nums[i], nums[low], nums[j]);

                        subsets.add(list);
                    }

                    low++;
                }
            }
        }

        //triplets(subsets, new ArrayList<>(), nums, 0, target);

        return subsets;
    }

    public static void triplets(Set<List<Integer>> subsets, List<Integer> list, int[] nums, int j, int target){
        if (list.size() == 3){
            subsets.add(new ArrayList<>(list));
            return;
        }

        for (int i = j; i < nums.length && nums[i] <= target; i++){
            list.add(nums[i]);

            triplets(subsets, list, nums, i + 1, target - nums[i]);

            list.remove(list.size() - 1);
        }
    }
}
