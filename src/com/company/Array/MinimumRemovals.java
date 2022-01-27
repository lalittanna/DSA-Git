package com.company.Array;

public class MinimumRemovals {
    /*

Given an integer array, trim it such that its maximum element becomes less than twice the minimum, return the minimum number of removals required for the conversion.

Input : [4, 6, 1, 7, 5, 9, 2]
Output: 4
Explanation: The trimmed array is [7, 5, 9] where 9 < 2 × 5.

Input : [4, 2, 6, 4, 9]
Output: 3
Explanation: The trimmed array is [6, 4] where 6 < 2 × 4.

*/
    public static int findMin(int[] nums){
        int maxRange = 0;

        int min, max;

        for (int i = 0; i < nums.length && nums.length - i > maxRange; i++){
            min = max = nums[i];

            for (int j = i; j < nums.length; j++){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                if (2 * min <= max)
                    break;

                maxRange = Math.max(maxRange, j - i + 1);
            }
        }

        return nums.length - maxRange;
    }
}
