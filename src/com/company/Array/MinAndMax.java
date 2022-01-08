package com.company.Array;
/*

Given a non-empty integer array, find the minimum and maximum element in the array by making minimum comparisons, and return the (min, max) element pair.

Input: [5, 7, 2, 4, 9, 6]
Output: (2, 9)

Explanation:

The minimum array element is 2
The maximum array element is 9

*/

public class MinAndMax {
    	/* The Pair<U, V> class have
		1. Two member variables, first and second.
		2. Factory method `Pair.of(U, V)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/

    public class Pair<U, V>{
        public static String of(int min, int max){
            return min + "" + max;
        }
    }

    public static String findMinAndMax(int[] nums)
    {
        if (nums == null || nums.length < 1){
            return null;
        }

        int min = nums[0];
        int max = nums[0];

        int i = 1;

        // if size is divisible by 2
        if (nums.length % 2 == 0){
            min = Integer.min(nums[0], nums[1]);
            max = Integer.max(nums[0], nums[1]);
            i = 2;
        }

        while (i < nums.length - 1){
            if (nums[i] < nums[i + 1]){
                max = Integer.max(max, nums[i + 1]);
                min = Integer.min(min, nums[i]);
            }else {
                max = Integer.max(max, nums[i]);
                min = Integer.min(min, nums[i + 1]);
            }

            i += 2;
        }

        // 3(n - 1)/2 for odd and 3n/2 - 2 for even
        return Pair.of(min, max);
    }
}
