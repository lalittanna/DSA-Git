package com.company.Array;

public class DuplicateElement2 {
    /*

Given an integer array of size `n+2` containing elements between 1 and `n` with two element repeating, find both duplicate elements without using any extra memory in linear time.

Input: [4, 3, 6, 5, 2, 4, 1, 1]
Output: (1, 4)

Input: [2, 1, 1, 2]
Output: (1, 2)

Note: The solution can return a pair of duplicate elements in any order. Assume valid input.

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
    public static Pair<Integer, Integer> findDuplicateElements(int[] nums){
        int result = nums[0] ^ nums[nums.length - 1];

        for (int i = 1; i < nums.length - 1; i++)
            result ^= nums[i] ^ i;

        int k = log(result & -result, 2);

        int x = 0, y = 0;

        for (int num : nums){
            if ((num & (1<<k)) != 0)
                x ^= num;
            else
                y ^= num;
        }

        for (int i = 1; i < nums.length - 1; i++){
            if ((i & (1<<k)) != 0)
                x ^= i;
            else
                y ^= i;
        }

        return Pair.of(x, y);
    }

    public static int log(int x, int base){
        return (int) (Math.log(x) / Math.log(base));
    }
}
