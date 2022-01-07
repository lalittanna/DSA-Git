package com.company.Array;

import java.util.Map;
import java.util.TreeMap;

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
