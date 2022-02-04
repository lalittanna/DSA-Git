package com.company.Array;

public class SmallestMissingNumber {
    /*

    Given a sorted array of non-negative distinct integers, find the smallest missing non-negative element in it.

    Input: [0, 1, 2, 6, 9, 11, 15]
    Output: 3

    Input: [1, 2, 3, 4, 6, 9, 11, 15]
    Output: 0

    Input: [0, 1, 2, 3, 4, 5, 6]
    Output: 7

    */
    public static int findSmallestMissingNumber(int[] nums){
        int low = 0, high = nums.length - 1;

        while (low <= high){
            int mid = (low + high) >> 1;

            if (nums[mid] != mid)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }
}
