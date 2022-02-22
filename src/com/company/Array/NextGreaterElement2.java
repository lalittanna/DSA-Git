package com.company.Array;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    /*

    Given a circular integer array, find the next greater element for every element in it. The next greater element of an element `x` in the array is the first larger number to the next of `x`.

    In a circular array, the indices will wrap around as if it were connected end-to-end. In other words, the end of the array wraps around to the start of the array. This facilitate searching circularly to find the next greater number. If the next greater element doesn't exist, consider it to be -1.

    Input : [3, 5, 2, 4]
    Output: [5, -1, 4, 5]

    Input : [7, 5, 3, 4]
    Output: [-1, 7, 4, 7]

    */
    public static int[] findNextGreaterElements(int[] nums){
        int[] output = new int[nums.length];
        Arrays.fill(output, -1);

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < 2 * nums.length; i++){
            while (!stack.empty() && nums[stack.peek()] < nums[i % nums.length])
                output[stack.pop()] = nums[i % nums.length];

            stack.push(i % nums.length);
        }

        return output;

        // int[] output = new int[nums.length];
        // Arrays.fill(output, -1);

        // for (int i = 0; i < nums.length; i++){
        // 	int j = (i + 1) % nums.length;
        // 	while (j != i){
        // 		if (nums[j] > nums[i]){
        // 			output[i] = nums[j];
        // 			break;
        // 		}

        // 		j = (j + 1) % nums.length;
        // 	}
        // }

        // return output;
    }
}
