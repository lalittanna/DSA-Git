package com.company.Array;

import java.util.ArrayList;
import java.util.List;

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
            int min = nums.get(i);
            int max = nums.get(i);

            for (int j = i + 1; j < nums.size(); j++){
                min = Integer.min(min, nums.get(j));
                max = Integer.max(max, nums.get(j));

                if (isConsecutive(nums, min, max, i, j)){
                    if (length < j - i + 1){
                        length = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        for (int i = start; i <= end; i++){
            list.add(nums.get(i));
        }

        return list;
    }

    public static boolean isConsecutive(List<Integer> nums, int min, int max, int i, int j){
        // for it to be consecutive, max would always be min + length of sub array - 1.
        if (max != min + j - i)
            return false;

        // to check if the element is seen before in the sub array.
        boolean[] visited = new boolean[j - i + 1];

        for (int k = i; k <= j; k++){
            // (nums.get(k) - min) -> this value would always be between 0 and length of sub array - 1.
            if (visited[nums.get(k) - min])
                return false;

            visited[nums.get(k) - min] = true;
        }

        return true;
    }
}
