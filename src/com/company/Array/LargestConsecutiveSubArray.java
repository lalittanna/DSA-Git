package com.company.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LargestConsecutiveSubArray {
    /*

Given an integer array, find the largest contiguous subarray formed by consecutive integers. The subarray should contain all distinct values.

Input : [2, 0, 2, 1, 4, 3, 1, 0]
Output: [0, 2, 1, 4, 3]

In case the multiple consecutive subarrays of maximum length exists, the solution can return any one of them.

Input : [-5, -1, 0, 2, 1, 6, 5, 8, 7]
Output: [-1, 0, 2, 1] or [6, 5, 8, 7]

*/
    public static List<Integer> findLargestSubarray(List<Integer> nums)
    {
        if (nums.size() == 0)
            return nums;

        List<Integer> list = new ArrayList<>();

        int start = 0;
        int end = 0;
        int length = 1;

        for (int i = 0; i < nums.size() - 1; i++){
            Set<Integer> set = new HashSet<>();
            set.add(nums.get(i));

            int min = nums.get(i);
            int max = nums.get(i);

            for (int j = i + 1; j < nums.size(); j++){
                min = Integer.min(min, nums.get(j));
                max = Integer.max(max, nums.get(j));

                if (set.contains(nums.get(j)))
                    break;

                set.add(nums.get(j));

                if (max == min + j - i){
                    if (length < j - i + 1){
                        length = j - i + 1;
                        end = j;
                        start = i;
                    }
                }
            }
        }

        for (int i = start; i <= end; i++){
            list.add(nums.get(i));
        }

        return list;
    }
}
