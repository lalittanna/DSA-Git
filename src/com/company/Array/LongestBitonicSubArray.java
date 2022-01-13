package com.company.Array;

import java.util.ArrayList;
import java.util.List;

public class LongestBitonicSubArray {
    /*

    The Longest Bitonic Subarray (LBS) problem is to find a contiguous subarray of a given sequence in which the subarray’s elements are first sorted in increasing order, then in decreasing order, and the subarray is as long as possible.

    Input : [3, 5, 8, 4, 5, 9, 10, 8, 5, 3, 4]
    Output: [4, 5, 9, 10, 8, 5, 3]

    In case the multiple bitonic subarrays of maximum length exists, the solution can return any one of them.

    Input : [-5, -1, 0, 2, 1, 6, 5, 4, 2]
    Output: [-5, -1, 0, 2, 1] or [1, 6, 5, 4, 2]

    */
    public static List<Integer> findBitonicSubarray(List<Integer> nums) {
        if (nums.size() == 0)
            return nums;

        List<Integer> list = new ArrayList<>();

        int maxLength = 1;
        int endingIndex = 0;

        int i = 0;
        while (i < nums.size() - 1){
            int length = 1;

            while (i < nums.size() - 1 && nums.get(i) < nums.get(i + 1)){
                length++;
                i++;
            }

            while (i < nums.size() - 1 && nums.get(i) > nums.get(i + 1)){
                length++;
                i++;
            }

            while (i < nums.size() - 1 && nums.get(i) == nums.get(i + 1))
                i++;

            if (maxLength < length){
                maxLength = length;
                endingIndex = i;
            }
        }

        for (int j = endingIndex - maxLength + 1; j <= endingIndex; j++)
            list.add(nums.get(j));

        return list;

        // List<Integer> list = new ArrayList<>();

        //      int[] increasing = new int[nums.size()];
        //      int[] decreasing = new int[nums.size()];

        //      increasing[0] = 1;
        //      for (int i = 1; i < nums.size(); i++)
        //      	increasing[i] = (nums.get(i) > nums.get(i - 1)) ? increasing[i - 1] + 1 : 1;

        //      decreasing[nums.size() - 1] = 1;
        //  	for (int i = nums.size() - 2; i >= 0; i--)
        //  		decreasing[i] = (nums.get(i) > nums.get(i + 1)) ? decreasing[i + 1] + 1 : 1;

        //  	int start = 0;
        //  	int end = 0;

        //  	for (int i = 0; i < nums.size(); i++){
        //  		if (increasing[i] + decreasing[i] - 1 > start + end + 1){
        //  			maxLength = increasing[i] + decreasing[i] - 1;
        //  			start = i - increasing[i] + 1;
        //  			end = decreasing[i] + i - 1;
        //  		}
        //  	}

        //      for (int i = start; i <= end; i++)
        //          list.add(nums.get(i));

        //      return list;
    }
}
