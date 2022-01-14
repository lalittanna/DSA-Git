package com.company.Array;

import java.util.ArrayList;
import java.util.List;

public class MinimumSumSubArray {
    /*

Given an integer array and a positive integer `k`, find the minimum sum contiguous subarray of size `k`.

Input : nums[] = [10, 4, 2, 5, 6, 3, 8, 1], k = 3
Output: [4, 2, 5]

Input : nums[] = [1, 4, 5, 3, 8], k = 6
Output: [1, 4, 5, 3, 8]

Note: Since an input can contain several minimum sum subarrays of size `k`, the solution can return any one of them.

*/

    public static List<Integer> findMinSumSubarray(List<Integer> nums, int k)
    {
        List<Integer> list = new ArrayList<>();

        if (k >= nums.size())
            return nums;

        int minimumSum = Integer.MAX_VALUE;
        int sum = 0;

        int endingIndex = 0;

        for (int i = 0; i < nums.size(); i++){
            sum += nums.get(i);

            if (i + 1 >= k){
                if (sum < minimumSum){
                    minimumSum = sum;
                    endingIndex = i;
                }

                sum -= nums.get(i - k + 1);
            }
        }

        for (int i = endingIndex - k + 1; i <= endingIndex; i++)
            list.add(nums.get(i));

        return list;

        // List<Integer> list = new ArrayList<>();

        // if (k >= nums.size())
        // 	return nums;

        // int endingIndex = 0;

        // int sum = Integer.MAX_VALUE;

        // for (int i = 0; i <= nums.size() - k; i++){
        // 	int sumSoFar = 0;
        // 	int j;
        // 	for (j = i; j < i + k; j++){
        // 		sumSoFar += nums.get(j);
        // 	}

        // 	if (sumSoFar < sum && j - i == k){
        // 		sum = sumSoFar;
        // 		endingIndex = j;
        // 	}
        // }

        // for (int i = endingIndex - k; i < endingIndex; i++)
        // 	list.add(nums.get(i));

        // return list;
    }
}
