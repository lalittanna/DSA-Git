package com.company.Array;

public class MinimumAbsoluteDifference2 {
    /*

    Given an integer array, find the maximum absolute difference between the sum of elements of two non-overlapping contiguous subarrays in linear time.

    Input : [-3, -2, 6, -3, 5, -9, 3, 4, -1, -8, 2]
    Output: 19
    Explanation: The two subarrays are [6, -3, 5] and [-9, 3, 4, -1, -8] whose sum of elements are 8 and -11, respectively. So, abs(8-(-11)) or abs(-11-8) = 19.

    Input : [6, 1, 3, 7]
    Output: 9
    Explanation: The two subarrays are [1] and [3, 7] whose sum of elements are 1 and 10, respectively. The maximum absolute difference is abs(10-1) = 9.

    Input : [2]
    Output: 2

    Input : []
    Output: 0

    */
    public static int findMaxAbsDiff(int[] nums){
        int n = nums.length;

        if (n == 0)
            return 0;

        if (n == 1)
            return nums[0];

        int[] leftMax = new int[n];
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        int[] rightMin = new int[n];

        fillArrays(nums, leftMax, leftMin, rightMax, rightMin, n);

        int maxAbsDiff = 0;
        int maxAbDiffSoFar;

        for (int i = 0; i < n - 1; i++){
            maxAbDiffSoFar = Integer.max(Math.abs(leftMax[i] - rightMin[i + 1]), Math.abs(leftMin[i] - rightMax[i + 1]));
            maxAbsDiff = Integer.max(maxAbsDiff, maxAbDiffSoFar);
        }

        return maxAbsDiff;
    }

    public static void fillArrays(int[] nums, int[] leftMax, int[] leftMin, int[] rightMax, int[] rightMin, int n){
        maxSumSubArrays(nums, leftMax, 0, n, 1);
        maxSumSubArrays(nums, rightMax, n - 1, 0, -1);

        for (int i = 0; i < n; i++)
            nums[i] = -nums[i];

        maxSumSubArrays(nums, leftMin, 0, n, 1);
        maxSumSubArrays(nums, rightMin, n - 1, 0, -1);

        for (int i = 0; i < n; i++)
            nums[i] = -nums[i];

        for (int i = 0; i < n; i++)
            leftMin[i] = -leftMin[i];

        for (int i = 0; i < n; i++)
            rightMin[i] = -rightMin[i];
    }

    public static void maxSumSubArrays(int[] nums, int[] leftMax, int i, int j, int diff){
        int max = nums[i];
        int maxSoFar = nums[i];
        leftMax[i] = nums[i];

        for (int k = i + diff; k != j; k += diff){
            maxSoFar = Integer.max(nums[k], maxSoFar + nums[k]);
            max = Integer.max(max, maxSoFar);
            leftMax[k] = max;
        }
    }
}
