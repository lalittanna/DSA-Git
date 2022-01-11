package com.company.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestEqualBinarySubArray {
    /*

Given a binary array containing 0’s and 1’s, find the largest contiguous subarray with equal numbers of 0’s and 1’s.

Input : [0, 0, 1, 0, 1, 0, 0]
Output: [0, 1, 0, 1] or [1, 0, 1, 0]

Input : [0, 0, 0, 0]
Output: []

Note: Since an input can contain several largest subarrays with equal numbers of 0’s and 1’s, the code should return any one of them.

*/
    public static List<Integer> findLargestSubarray(List<Integer> nums)
    {
        List<Integer> largestSubarray = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int maxLength = 0;
        int endingIndex = -1;

        int sum = 0;

        for (int i = 0; i < nums.size(); i++){
            sum += (nums.get(i) == 0) ? -1 : 1;

            if (map.containsKey(sum)){
                if (maxLength < i - map.get(sum)){
                    maxLength = i - map.get(sum);
                    endingIndex = i;
                }
            } else {
                map.put(sum, i);
            }
        }

        for (int i = endingIndex - maxLength + 1; i <= endingIndex; i++)
            largestSubarray.add(nums.get(i));

        return largestSubarray;

        // List<Integer> largestSubarray = new ArrayList<>();

        // int maxLength = 0;
        // int endingIndex = -1;

        // for (int i = 0; i < nums.size(); i++){
        // 	int noOfZeros = 0;
        // 	int noOfOnes = 0;

        // 	for (int j = i; j < nums.size(); j++){
        // 		if (nums.get(j) == 0)
        // 			noOfZeros++;
        // 		else
        // 			noOfOnes++;

        // 		if (noOfZeros == noOfOnes && maxLength < j - i + 1){
        // 			maxLength = j - i + 1;
        // 			endingIndex = j;
        // 		}
        // 	}

        // for (int i = endingIndex - maxLength + 1; i <= endingIndex; i++)
        // 	largestSubarray.add(nums.get(i));

        // return largestSubarray;
    }
}
