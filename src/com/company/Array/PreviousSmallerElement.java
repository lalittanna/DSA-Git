package com.company.Array;

import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerElement {
    /*

Given an integer array, find the previous smaller element for every array element. The previous smaller element of a number `x` is the first smaller number to the left of `x` in the array.

In other words, for each element A[i] in the array A, find an element A[j] such that j < i and A[j] < A[i] and value of j should be as maximum as possible. If the previous smaller element doesn't in the array for any element, consider it -1.

Input : [2, 5, 3, 7, 8, 1, 9]
Output: [-1, 2, 2, 3, 7, -1, 1]

Input : [5, 7, 4, 9, 8, 10]
Output: [-1, 5, -1, 4, 4, 8]

Note that the first element always has a previous smaller element as -1.

*/
    public static int[] findNextGreaterElements(int[] nums){
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++){
            while(!stack.empty()){
                if (nums[stack.peek()] < nums[i]){
                    arr[i] = nums[stack.peek()];
                    break;
                }
                else
                    stack.pop();
            }

            stack.push(i);
        }

        return arr;
    }
}
