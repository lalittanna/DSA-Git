package com.company.Array;

import java.util.HashMap;
import java.util.Map;

public class FrequencyMap {
    public static Map<Integer, Integer> findFrequency(int[] nums)
    {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums)
            nums[num % nums.length] += nums.length;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= nums.length)
                freq.put(i, nums[i] / nums.length);
        }

        return freq;
    }
}
