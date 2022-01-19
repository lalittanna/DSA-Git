package com.company.Array;

import java.util.*;

public class FourSum {
    /*

    Given an unsorted integer array, find all quadruplets (i.e., four elements tuple) having a given sum.

    Input : nums = [2, 7, 4, 0, 9, 5, 1, 3], target = 7
    Output: {[0, 1, 2, 4]}

    Since the input can contain multiple quadruplets that sum to a given target, the solution should return a set containing all the quadruplets.

    Input : nums = [2, 7, 4, 0, 9, 5, 1, 3], target = 20
    Output: {[0, 4, 7, 9], [1, 3, 7, 9], [2, 4, 5, 9]}

    Note: The order of elements doesn't matter in a quadruplet, and any permutation is allowed in the output. For example, the output set can contain quadruplets [9, 1, 7, 3] and [9, 3, 7, 1], but system treats them the same.

    */
    public static Set<List<Integer>> findQuadruplets(List<Integer> nums, int target) {
        Set<List<Integer>> quadruplets = new HashSet<>();

        Collections.sort(nums);

        for (int i = 0; i < nums.size() - 3; i++){
            int l = target - nums.get(i);

            for (int j = i + 1; j < nums.size() - 2; j++){
                int m = l - nums.get(j);

                int low = j + 1;
                int high = nums.size() - 1;

                while (low < high){
                    if (nums.get(low) + nums.get(high) < m)
                        low++;
                    else if (nums.get(low) + nums.get(high) > m)
                        high--;
                    else {
                        List<Integer> list = new ArrayList<>();
                        Collections.addAll(list, nums.get(i), nums.get(j), nums.get(low), nums.get(high));
                        quadruplets.add(list);
                        low++;
                        high--;
                    }
                }
            }
        }

        return quadruplets;
    }
}
