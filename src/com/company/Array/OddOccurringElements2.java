package com.company.Array;


public class OddOccurringElements2 {
    /*

Given an integer array, duplicates appear in it an even number of times except for two elements, which appear an odd number of times. Find both odd appearing elements without using any extra memory.

Input: [4, 3, 6, 2, 4, 2, 3, 4, 3, 3]
Output: (4, 6)
Explanation: The odd occurring elements are 4 and 6 as

6 appears once.
2 appears twice.
4 appears thrice.
3 appears 4 times.

Note: The solution can return a pair of odd appearing elements in any order. Assume valid input.

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
    public static Pair<Integer, Integer> findOddOccuringElements(int[] nums){
        int result = 0;

        for (int num : nums)
            result ^= num;

        int k = log(result & -result, 2);

        int x = 0, y = 0;

        for (int num : nums){
            if ((num & (1<<k)) != 0)
                x ^= num;
            else
                y ^= num;
        }

        return Pair.of(x, y);
    }

    public static int log(int x, int base){
        return (int)(Math.log(x) / Math.log(base));
    }
}
