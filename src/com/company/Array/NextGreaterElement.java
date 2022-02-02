package com.company.Array;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    /*

    Given an integer array, find the next greater element for every array element. The next greater element of a number x is the first greater number to the right of x in the array.

    In other words, for each element A[i] in the array A, find an element A[j] such that j > i and A[j] > A[i] and the value of j should be as minimum as possible. If the next greater element doesn't exist in the array for any element, consider it -1.

    Input:  [2, 7, 3, 5, 4, 6, 8]
    Output: [7, 8, 5, 6, 6, 8, -1]

    Input:  [5, 4, 3, 2, 1]
    Output: [-1, -1, -1, -1, -1]

    Note that the next greater element for the last array element is always -1.

    */
    public static int[] findNextGreaterElements(int[] nums){
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                arr[stack.pop()] = nums[i];

            stack.push(i);
        }

        return arr;

        // for (int i = 0; i < nums.length; i++){
        // 	int nextGreater = -1;
        // 	for (int j = i + 1; j < nums.length; j++){
        // 		if (nums[i] < nums[j]){
        // 			nextGreater = nums[j];
        // 			break;
        // 		}
        // 	}
        // 	nums[i] = nextGreater;
        // }

        // return nums;
    }
}
