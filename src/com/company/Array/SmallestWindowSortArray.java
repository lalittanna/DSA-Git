package com.company.Array;
/*

Given an integer array, find the smallest window sorting which will make the entire array sorted in increasing order. The solution should return a pair consisting of the starting and ending index of the smallest window.

Input : [1, 2, 3, 7, 5, 6, 4, 8]
Output: (3, 6)
Explanation: The array can be sorted from index 3 to 6 to get sorted version.

Input : [1, 3, 2, 7, 5, 6, 4, 8]
Output: (1, 6)
Explanation: The array can be sorted from index 1 to 6 to get sorted version.

If the array is already sorted, the solution should return null.

Input : [1, 2, 3, 4, 5]
Output: null
Explanation: The array is already sorted.

*/


public class SmallestWindowSortArray {
    /* The Pair<U, V> class have
		1. Two member variables, first and second.
		2. Factory method `Pair.of(U, V)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/
    private class  Pair<E, V> {
        public static int[] of(int U, int V){
            int[] array = {U, V};
            return array;
        }
    }
    public static int[] findSmallestWindow(int[] nums)
    {
        int start = -1;
        int end = -1;

        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] > nums[i + 1] && start > 0){
                end = i + 1;
                smallest = Math.min(smallest, nums[i + 1]);
            } else if (nums[i] > nums[i + 1]){
                smallest = Math.min(smallest, nums[i + 1]);
                start = i;
                end = i + 1;
            }
        }

        if (start < 0)
            return null;

        for (int i = 0; i < start; i++){
            if (nums[i] >= smallest)
                return Pair.of(i, end);
        }

        return Pair.of(start, end);


        // int leftIndex = -1;
        // int rightIndex = -1;

        // int maxSoFar = Integer.MIN_VALUE;
        // for (int i = 0; i < nums.length; i++){
        // 	maxSoFar = Math.max(maxSoFar, nums[i]);

        // 	if (nums[i] < maxSoFar)
        // 		rightIndex = i;
        // }

        // int minSoFar = Integer.MAX_VALUE;
        // for (int i = nums.length - 1; i >= 0; i--){
        // 	minSoFar = Math.min(minSoFar, nums[i]);

        // 	if (nums[i] > minSoFar)
        // 		leftIndex = i;
        // }

        // if (rightIndex < 0)
        // 	return null;

        // return Pair.of(leftIndex, rightIndex);
    }
}
