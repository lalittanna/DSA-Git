package com.company.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KSumSubArray {
/*

Given an integer array, find a contiguous subarray having sum `k` in it where `k` is an integer.

Input : nums[] = [2, 6, 0, 9, 7, 3, 1, 4, 1, 10], k = 15
Output: [6, 0, 9]

Input : nums[] = [0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10], k = -3
Output: [1, -4]

Note: Since an input can contain several subarrays having sum `k`, the solution can return any one of them.

Input : nums[] = [0, 5, -7, 1, -4, 7, 6, 1, 4, 1, 10], k = 15
Output: [1, -4, 7, 6, 1, 4] or [4, 1, 10]

*/

    public static List<Integer> findSubarray(List<Integer> nums, int k)
    {
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sumSoFar = 0;

        for (int i = 0; i < nums.size(); i++){
            sumSoFar += nums.get(i);

            if (map.containsKey(sumSoFar - k)){
                for (int j = map.get(sumSoFar - k) + 1; j <= i; j++)
                    list.add(nums.get(j));
                return list;
            }

            map.put(sumSoFar, i);
        }

        return list;

        // Below solution will only work for positive numbers array.

        // int windowSum = 0;
        // int low;
        // int high = 0;

        // for (low = 0; low < nums.size(); low++){
        // 	while (windowSum < k && high < nums.size())
        // 		windowSum += nums.get(high++);

        // 	if (windowSum == k)
        // 		break;

        // 	windowSum -= nums.get(low);
        // }

        // for (int i = low; i < high; i++)
        // 	list.add(nums.get(i));

        // return list;
    }
}
