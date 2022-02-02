package com.company.Array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MissingAndDuplicate {
    /*

    Given an integer array of size `n`, with all its elements between 1 and `n` and one element occurring twice and one element missing. Find the missing number and the duplicate element in linear time and without using any extra memory.

    Input: [4, 3, 6, 5, 2, 4]
    Output: (4, 1)
    Explanation: The duplicate element is 4 and the missing element is 1.

    Input: [4, 2, 2, 1]
    Output: (2, 3)
    Explanation: The duplicate element is 2 and the missing element is 3.

    Note: The solution should return (duplicate element, missing element) pair. Assume valid input.

    */

    private class Pair<U, V>{
        public Integer first;
        public Integer second;
        public Pair(Integer first, Integer second){
            this.first = first;
            this.second = second;
        }
        public static Pair of(int first, int second){
            //Pair<Integer, Integer> pair = new Pair<>(first, second);
            return null;
        }
    }
    /* The Pair<U, V> class have
		1. Two member variables, first and second.
		2. Factory method `Pair.of(U, V)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/
    public static Pair<Integer, Integer> findMissingAndDuplicate(int[] nums){
        int xor = nums.length;

        for (int i = 0; i < nums.length; i++)
            xor ^= i ^ nums[i];

        int k = log(xor & -xor, 2);

        int x = 0, y = 0;

        for (int num : nums){
            if ((num & (1<<k)) != 0)
                x ^= num;
            else
                y ^= num;
        }

        for (int i = 1; i <= nums.length; i++){
            if ((i & (1<<k)) != 0)
                x ^= i;
            else
                y ^= i;
        }

        if (Arrays.stream(nums).boxed().collect(Collectors.toList()).contains(x))
            return Pair.of(x, y);
        else
            return Pair.of(y, x);
    }

    public static int log(int x, int base){
        return (int) (Math.log(x) / Math.log(2));
    }
}
