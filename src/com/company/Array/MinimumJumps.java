package com.company.Array;

import java.util.Arrays;

public class MinimumJumps {
    /*

    Given an array of non-negative integers, where each array element represents the maximum number of positions one can move forward from that element. Find the minimum number of jumps required to reach end of the array from start of the array.

    Input: [4, 2, 0, 3, 2, 0, 1, 8]
    Output: 3
    Explanation: The minimum jumps required to reach the destination are 3.

    3 jumps: (4 —> 3 —> 1 —> 8) or (4 —> 2 —> 1 —> 8)
    4 jumps: (4 —> 2 —> 3 —> 1 —> 8) or (4 —> 3 —> 2 —> 1 —> 8)
    5 jumps: (4 —> 2 —> 3 —> 2 —> 1 —> 8)

    Note that if any element has value 0 in the array, the destination cannot be reached through that element. The solution should return -1 as the destination cannot be reached.

    Input: [4, 2, 2, 1, 0, 8, 1]
    Output: -1
    Explanation: The minimum jumps required to reach the destination are infinity. This is because no matter what path we choose, it will always end up in a dead cell.

    4 —> 2 —> 2 —> 1 —> 0
    4 —> 2 —> 1 —> 0
    4 —> 1 —> 0
    4 —> 0

    Input: [0, 2, 2, 1, 8, 1]
    Output: -1
    Explanation: The destination cannot be reached at all since the source itself has value 0.

    */
    public static int findMinimumJumps(int[] nums){
        if (nums.length < 1)
            return 0;

        int n = nums.length;

        int[] lookUp = new int[n];
        Arrays.fill(lookUp, -1);

        lookUp[0] = 0;
        for (int i = 0; i < n; i++){
            for (int j = 1; j <= Math.min(n - 1, nums[i]) && i + j < n && lookUp[i] != -1; j++)
                lookUp[i + j] = (lookUp[i + j] != -1) ? Math.min(lookUp[i + j], lookUp[i] + 1) : lookUp[i] + 1;
        }

        return lookUp[n - 1];

        // if (nums.length < 1)
        // 	return 0;

        // int[] lookUp = new int[nums.length];
        // int min = minJumps(nums, 0, lookUp);
        // if (min == Integer.MAX_VALUE)
        // 	return -1;
        // return min;
    }

    public static int minJumps(int[] nums, int i, int[] lookUp){
        if (i >= nums.length - 1)
            return 0;

        if (nums[i] == 0)
            return Integer.MAX_VALUE;

        if (lookUp[i] != 0)
            return lookUp[i];

        int minJumps = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + nums[i]; j++){
            int cost = minJumps(nums, j, lookUp);
            if (cost != Integer.MAX_VALUE)
                minJumps = Integer.min(minJumps, cost + 1);
        }

        return (lookUp[i] = minJumps);
    }
}
