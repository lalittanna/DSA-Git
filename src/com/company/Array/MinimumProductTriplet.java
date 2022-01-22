package com.company.Array;

public class MinimumProductTriplet {
    /*

Given an integer array, find the minimum product among all combinations of triplets in the array.

Input : [4, -1, 3, 5, 9]
Output: -45
Explanation: The minimum product triplet is (-1, 5, 9)

Input : [1, 4, 10, -2, 4]
Output: -80
Explanation: The minimum product triplet is (10, 4, -2)

Input : [3, 4, 1, 2, 5]
Output: 6
Explanation: The minimum product triplet is (3, 1, 2)

Input : [1, 2]
Output: 0
Explanation: Invalid input

*/
    public static int findMin(int[] nums)
    {
        if (nums.length < 3)
            return 0;

        int lowIndex1 = 0, lowIndex2 = -1, lowIndex3 = -1, MaxIndex1 = 0, MaxIndex2 = -1;

        for (int i = 1; i < nums.length; i++){
            if (nums[i] < nums[lowIndex1]){
                lowIndex3 = lowIndex2;
                lowIndex2 = lowIndex1;
                lowIndex1 = i;
            } else if (lowIndex2 == -1 || nums[i] < nums[lowIndex2]){
                lowIndex3 = lowIndex2;
                lowIndex2 = i;
            } else if (lowIndex3 == -1 || nums[i] < nums[lowIndex3])
                lowIndex3 = i;

            if (nums[i] > nums[MaxIndex1]){
                MaxIndex2 = MaxIndex1;
                MaxIndex1 = i;
            } else if (MaxIndex2 == -1 || nums[i] > nums[MaxIndex2])
                MaxIndex2 = i;
        }

        return Math.min(nums[lowIndex1] * nums[lowIndex2] * nums[lowIndex3], nums[lowIndex1] * nums[MaxIndex1] * nums[MaxIndex2]);
    }
}
