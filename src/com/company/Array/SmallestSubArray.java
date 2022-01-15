package com.company.Array;

public class SmallestSubArray {
    /*

Given an array of positive integers and a positive integer k, find the smallest contiguous subarray length whose sum of elements is greater than k.

Input : [1, 2, 3, 4, 5, 6, 7, 8], k = 7
Output: 1
Explanation: The smallest subarray with sum > 20 is [8]

Input : [1, 2, 3, 4, 5, 6, 7, 8], k = 20
Output: 3
Explanation: The smallest subarray with sum > 20 is [6, 7, 8]

Input : [1, 2, 3, 4, 5, 6, 7, 8], k = 21
Output: 4
Explanation: The smallest subarray with sum > 20 is [5, 6, 7, 8]

Input : [1, 2, 3, 4, 5, 6, 7, 8], k = 40
Output: 0
Explanation: No subarray exists

*/
    public static int findSmallestSubarray(int[] nums, int k)
    {
        int smallestLength = Integer.MAX_VALUE;

        int start = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++){
            sum += nums[i];

            while (sum > k) {
                smallestLength = Math.min(smallestLength, i - start + 1);
                sum -= nums[start++];
            }
        }

        if (smallestLength > nums.length)
            return 0;

        return smallestLength;
    }
}
