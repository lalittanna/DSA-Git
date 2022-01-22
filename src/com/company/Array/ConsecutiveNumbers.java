package com.company.Array;

import java.util.HashSet;
import java.util.Set;

public class ConsecutiveNumbers {
    /*

Given an integer array, check if only consecutive integers form the array.

Input : [-1, 5, 4, 2, 0, 3, 1]
Output: true
Explanation: The array contains consecutive integers from -1 to 5.

Input : [4, 2, 4, 3, 1]
Output: false
Explanation: The array does not contain consecutive integers as element 4 is repeated.

Input : [2, 5, 3, 1]
Output: false
Explanation: The array does not contain consecutive integers as element 4 is missing.

*/
    public static boolean isConsecutive(int[] nums){
        if (nums.length < 1)
            return true;

        Set<Integer> set = new HashSet<>();

        int low = nums[0];
        int high = nums[0];

        for (int num : nums){
            low = Math.min(low, num);
            high = Math.max(high, num);
            if (set.contains(num))
                return false;
            set.add(num);
        }

        if (high - low + 1 == nums.length)
            return true;

        return false;

        // if (nums.length < 1)
        // 	return true;

        // int x = 0;
        // int low = nums[0];
        // int high = nums[0];

        // for (int num : nums){
        // 	low = Math.min(low, num);
        // 	high = Math.max(high, num);
        // 	x = x ^ num;
        // }

        // for (int i = low; i <= high; i++)
        // 	x = x ^ i;

        // if (x == 0)
        // 	return true;
        // return false;
    }
}
