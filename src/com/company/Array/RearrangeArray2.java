package com.company.Array;

import java.util.List;

public class RearrangeArray2 {
    /*

    Given an integer array, rearrange it such that it contains positive and negative numbers at alternate positions. Assume that all values in the array are non-zero.

    • In case the multiple rearrangement exists, the solution can return any one of them.

    Input : [9, -3, 5, -2, -8, -6, 1, 3]
    Output: [9, -3, 5, -2, 1, -8, 3, -6] or [5, -2, 9, -6, 1, -8, 3, -3] or any other valid combination..

    • If the array contains more positive or negative elements, the solution should move them to the end of the array.

    Input : [9, -3, 5, -2, -8, -6]
    Output: [5, -2, 9, -6, -3, -8] or [-2, 5, -6, 9, -3, -8] or any other valid combination..

    Input : [5, 4, 6, -1, 3]
    Output: [5, -1, 4, 6, 3] or [-1, 5, 4, 6, 3] or any other valid combination..

    */
    public static void rearrange(List<Integer> nums)
    {
        int p = partition(nums);

        for (int i = 0; i < p && p < nums.size(); i += 2, p++)
            swap(nums, i, p);

        // for (int i = 0; i < nums.size() - 1; i++){
        // 	if (nums.get(i) * nums.get(i + 1) > 0){
        // 		for (int  j = i + 2; j < nums.size(); j++){
        // 			if (nums.get(i + 1) * nums.get(j) < 0){
        // 				swap(nums, i + 1, j);
        // 				break;
        // 			}
        // 		}
        // 		if (nums.get(i) * nums.get(i + 1) > 0)
        // 			return;
        // 	}
        // }
    }

    public static void swap(List<Integer> nums, int i, int j){
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    public static int partition (List<Integer> nums){
        int j = 0;
        int pivot = 0;

        for (int i = 0; i < nums.size(); i++){
            if (nums.get(i) < pivot)
                swap(nums, i, j++);
        }

        return j;
    }
}
