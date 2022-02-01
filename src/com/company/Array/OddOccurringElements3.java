package com.company.Array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OddOccurringElements3 {
    /*

    Given an array having elements between 0 and 31, find elements that occur an odd number of times without using the extra space.

    Input : [5, 8, 2, 5, 8, 2, 8, 5, 1, 8, 2]
    Output: {5, 2, 1}

    Explanation:

    1 occurs once.
    2 and 5 occurs thrice.
    8 occurs four times.

    Assume valid input.

    */
    public static Set<Integer> findOddOccurringElements(List<Integer> nums){
        Set<Integer> set = new HashSet<>();

        int xor = 0;

        for (int num : nums)
            xor ^= (1 << num);

        for (int num : nums){
            if ((xor & (1 << num)) != 0)
                set.add(num);
        }

        return set;
    }
}
