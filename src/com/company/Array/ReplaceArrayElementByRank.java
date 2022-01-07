package com.company.Array;

import java.util.Map;
import java.util.TreeMap;

/*

Given an array of distinct integers, replace each array element by its corresponding rank in the array. The minimum array element has the rank 1; the second minimum element has a rank of 2, and so on.

Input : [10, 8, 15, 12, 6, 20, 1]
Output: [4, 3, 6, 5, 2, 7, 1]

Input : [0, 1, -1]
Output: [2, 3, 1]

*/
public class ReplaceArrayElementByRank {
    public static void transform(int[] nums)
    {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        int rank = 1;
        for (int values : map.values()){
            nums[values] = rank++;
        }
    }
}
