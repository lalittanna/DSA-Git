package com.company.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxLengthSubArray {
    /*

Given an integer array, find the maximum length contiguous subarray having a given sum.

Input : nums[] = [5, 6, -5, 5, 3, 5, 3, -2, 0], target = 8
Output: [-5, 5, 3, 5]
Explanation: The subarrays with sum 8 are [[-5, 5, 3, 5], [3, 5], [5, 3]]. The longest subarray is [-5, 5, 3, 5] having length 4.

Note: Since an input can contain several maximum length subarrays with given sum, the solution should return any one of the maximum length subarray.

*/
    public static List<Integer> findMaxLenSubarray(List<Integer> nums, int target)
    {
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int maxLength = 0;
        int endingIndex = -1;

        int sum = 0;

        for(int i = 0; i < nums.size(); i++){
            sum += nums.get(i);

            if (map.containsKey(sum - target) && maxLength < i - map.get(sum - target)){
                maxLength = i - map.get(sum - target);
                endingIndex = i;
            }

            map.putIfAbsent(sum, i);
        }

        for (int i = endingIndex - maxLength + 1; i <= endingIndex; i++){
            list.add(nums.get(i));
        }

        return list;

//        List<Integer> max = new ArrayList<>();
//
//        int maxLength = 0;
//        int endingIndex = -1;
//
//        for (int i = 0; i < nums.size(); i++){
//            int sum = 0;
//
//            for (int j = i; j < nums.size(); j++){
//                sum += nums.get(j);
//
//                if (sum == target){
//                    if (maxLength < j - i + 1){
//                        maxLength = j - i + 1;
//                        endingIndex = j;
//                    }
//                }
//            }
//        }
//
//        for (int i = endingIndex - maxLength + 1; i <= endingIndex; i++){
//            max.add(nums.get(i));
//        }
//
//        return max;
    }
}
