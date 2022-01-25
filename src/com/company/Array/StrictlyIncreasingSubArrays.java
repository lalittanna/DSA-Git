package com.company.Array;

public class StrictlyIncreasingSubArrays {
    /*

Given an integer array, count the total number of strictly increasing contiguous subarrays in it.

Input: [1, 2, 4, 4, 5]
Output: 4
Explanation: The total number of strictly increasing subarrays are [1, 2], [1, 2, 4], [2, 4], [4, 5]

Input: [1, 3, 2]
Output: 1
Explanation: The total number of strictly increasing subarrays is [1, 3]

Input: [5, 4, 3, 2, 1]
Output: 0
Explanation: The total number of strictly increasing subarrays is 0

*/
    public static int getCount(int[] nums)
    {
        int subarrays = 0, start = 0;

        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i - 1])
                subarrays += i - start;
            else
                start = i;
        }

        return subarrays;
    }
}
