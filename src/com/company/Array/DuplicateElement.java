package com.company.Array;

public class DuplicateElement {
    /*

Given an integer array of size `n` containing elements between 1 and `n-1` with one element repeating, find the duplicate number in it without using any extra space.

Input: [1, 2, 3, 4, 4]
Output: 4

Input: [1, 2, 3, 4, 2]
Output: 2

Input: [1, 1]
Output: 1

Assume valid input.

*/
    public static int findDuplicateElement(int[] nums){
        int xor = 0;

        for (int num : nums)
            xor ^= num;

        for (int i = 1; i < nums.length; i++)
            xor ^= i;

        return xor;

        // int sum1 = Arrays.stream(nums).sum();
        // int sum2 = ((nums.length - 1) * (nums.length)) / 2;

        // return sum1 - sum2;
    }
}
