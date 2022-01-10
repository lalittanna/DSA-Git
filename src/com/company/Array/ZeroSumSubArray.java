package com.company.Array;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubArray {
    public static boolean hasZeroSumSubarray(int[] nums) {
		/* if the sum repeats at any point that means all elements after the initial occurrence (excluded) to second
		 occurrence (included) resulted in zero hence they nullified all the additions after the initial occurrence.
		*/

        Set<Integer> set = new HashSet<>();

        set.add(0);

        int sum = 0;

        for (int value : nums) {
            sum += value;

            if (set.contains(sum))
                return true;

            set.add(sum);
        }

        return false;
    }
}
