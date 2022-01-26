package com.company.Array;

public class KDivisiblePairs {
    /*

Given an integer array, determine whether it can be divided into pairs such that the sum of elements in each pair is divisible by a given positive integer `k`.

Input: nums[] = [3, 1, 2, 6, 9, 4], k = 5
Output: true
Explanation: Array can be divided into pairs {(3, 2), (1, 9), (4, 6)}, where the sum of elements in each pair is divisible by 5.

Input: nums[] = [2, 9, 4, 1, 3, 5], k = 6
Output: true
Explanation: Array can be divided into pairs {(2, 4), (9, 3), (1, 5)}, where the sum of elements in each pair is divisible by 6.

Input: nums[] = [3, 1, 2, 6, 9, 4], k = 6
Output: false
Explanation: Array cannot be divided into pairs where the sum of elements in each pair is divisible by 6.

*/
    public static boolean hasPairs(int[] nums, int k){
        if ((nums.length & 1) != 0)
            return false;

        int[] freq = new int[k];

        for (int num : nums){
            int r = num % k;
            if (r < 0)
                r += k;
            freq[r % k]++;
        }

        if ((freq[0] & 1) != 0)
            return false;

        for (int i = 1; i <= k / 2; i++){
            if (freq[i] != freq[k - i])
                return false;
        }

        return true;
    }
}
