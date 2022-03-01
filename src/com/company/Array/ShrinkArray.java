package com.company.Array;

import java.util.HashMap;
import java.util.Map;

public class ShrinkArray {
    /*

    Given an integer array and an integer k, shrink it by removing adjacent triplets that satisfy the given constraints and return the total number of elements in the resultant array.

    A triplet (x, y, z) can only be removed if, for the number k, the second element y of the triplet is precise k more than the first element x. The third element, z, is precise k more than the second element y. The total number of elements in the final array should be as few as possible.

    Input: nums = [1, 2, 3, 5, 7, 8], k = 2
    Output: 3
    Explanation: The adjacent triplet (3, 5, 7) can be removed from the array. The resultant array is [1, 7, 8] cannot be reduced further.

    Input: nums = [-1, 0, 1, 2, 3, 4], k = 1
    Output: 0
    Explanation: The result is 0 since all elements can be removed from the array. First, the adjacent triplet (2, 3, 4) is removed. The array is now reduced to [-1, 0, 1], which forms another valid triplet and can be removed from the array.

    Note that if the adjacent triplet (1, 2, 3) is removed from the array first, the resultant array [-1, 0, 4] cannot be reduced further.

    */
    public static int shrink(int[] nums, int k){
        return recur(nums, 0, nums.length - 1, k, new HashMap<>());
    }

    public static int recur(int[] nums, int start, int end, int k, Map<String, Integer> lookUp){
        if (end < start) return 0;

        String key = start + 1 + "|" + end;

        if (!lookUp.containsKey(key)) lookUp.put(key, 1 + recur(nums, start + 1, end, k, lookUp));
        int result = lookUp.get(key);

        for (int i = start + 1; i < end; i++){
            for (int j = i + 1; j <= end; j++){
                if (nums[i] == nums[start] + k && nums[j] == nums[i] + k)
                    if (recur(nums, start + 1, i - 1, k, lookUp) == 0 && recur(nums, i + 1, j - 1, k, lookUp) == 0)
                        result = Math.min(result, recur(nums, j + 1, end, k, lookUp));
            }
        }

        return result;
    }
}
