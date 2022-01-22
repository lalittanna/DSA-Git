package com.company.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumProductTriplet {
    /*

Given an integer array, find a triplet having the maximum product.

Input : [-4, 1, -8, 9, 6]
Output: [-4, -8, 9]

If the input contains several triplets with maximum product, the solution can return any one of them.

Input : [5, 2, -10, 4, 5, 1, -2]
Output: [5, 4, 5] or [5, -10, -2]

Note: The solution can return the triplet in any order, not necessarily as they appear in the array.

*/
    public static List<Integer> findTriplet(int[] nums)
    {
        List<Integer> triplet = new ArrayList<>();

        if (nums.length < 3)
            return triplet;

        int maxIndex1 = 0, maxIndex2 = -1, maxIndex3 = -1, minIndex1 = 0, minIndex2 = -1;
        for (int i = 1; i < nums.length; i++){
            if (nums[maxIndex1] < nums[i]){
                maxIndex3 = maxIndex2;
                maxIndex2 = maxIndex1;
                maxIndex1 = i;
            } else if (maxIndex2 == -1 || nums[maxIndex2] < nums[i]){
                maxIndex3 = maxIndex2;
                maxIndex2 = i;
            } else if (maxIndex3 == -1 || nums[maxIndex3] < nums[i])
                maxIndex3 = i;

            if (nums[i] < nums[minIndex1]){
                minIndex2 = minIndex1;
                minIndex1 = i;
            } else if (minIndex2 == -1 || nums[i] < nums[minIndex2])
                minIndex2 = i;
        }


        if (nums[maxIndex1] * nums[maxIndex2] * nums[maxIndex3] > nums[minIndex1] * nums[minIndex2] * nums[maxIndex1])
            Collections.addAll(triplet, nums[maxIndex1], nums[maxIndex2], nums[maxIndex3]);
        else
            Collections.addAll(triplet, nums[minIndex1], nums[minIndex2], nums[maxIndex1]);

        return triplet;
    }
}
