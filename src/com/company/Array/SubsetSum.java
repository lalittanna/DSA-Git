package com.company.Array;

public class SubsetSum {
    /*

    Given an integer array, return the total number of ways to calculate the specified target from array elements using only the addition and subtraction operator. The use of any other operator is forbidden.

    Input: nums = [5, 3, -6, 2], target = 6
    Output: 4
    Explanation: There are 4 ways to calculate the target of 6 using only + and - operators:

    (-)-6 = 6
    (+) 5 (+) 3 (-) 2 = 6
    (+) 5 (-) 3 (-) -6 (-) 2 = 6
    (-) 5 (+) 3 (-) -6 (+) 2 = 6

    Input: nums = [5, 3, -6, 2], target = 4
    Output: 4
    Explanation: There are 4 ways to calculate the target of 4 using only + and - operators:

    (-)-6 (-) 2 = 4
    (-) 5 (+) 3 (-)-6 = 4
    (+) 5 (-) 3 (+) 2 = 4
    (+) 5 (+) 3 (+)-6 (+) 2 = 4

    */
    public static int countWays(int[] nums, int target){
        return ways(nums, target, nums.length - 1);
    }

    public static int ways(int[] nums, int target, int n){
        if (target == 0)
            return 1;

        if (n < 0)
            return 0;

        return ways(nums, target, n - 1) + ways(nums, target + nums[n], n - 1) + ways(nums, target - nums[n], n - 1);
    }
}
