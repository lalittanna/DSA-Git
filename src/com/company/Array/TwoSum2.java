package com.company.Array;

/*

Given a circularly sorted integer array, find a pair with a given sum. Assume there are no duplicates in the array, and the rotation is in an anti-clockwise direction around an unknown pivot.

• The solution can return pair in any order.

Input : nums[] = [10, 12, 15, 3, 6, 8, 9], target = 18
Output: (3, 15) or (15, 3)

Input : nums[] = [5, 8, 3, 2, 4], target = 12
Output: (4, 8) or (8, 4)

• If no pair with the given sum exists, the solution should return null

Input : nums[] = [9, 15, 2, 3, 7], target = 20
Output: null

*/
public class TwoSum2 {
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

    public static Pair<Integer, Integer> findPair(int[] nums, int target){
        if (nums.length < 2)
            return null;

        int low = 0, high = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] > nums[i + 1]){
                high = i;
                low = (i + 1) % nums.length;
                break;
            }
        }

        while (low != high){
            if (nums[low] + nums[high] < target)
                low = (low + 1) % nums.length;
            else if (nums[low] + nums[high] > target)
                high = (high - 1 + nums.length) % nums.length;
            else
                return Pair.of(nums[low], nums[high]);
        }


        return null;
    }
}
