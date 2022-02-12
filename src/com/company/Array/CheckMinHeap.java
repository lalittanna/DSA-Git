package com.company.Array;

public class CheckMinHeap {
    /*

    Given an integer array, check if it represents min-heap or not.

    Input : [2, 3, 4, 5, 10, 15]
    Output: true
    Explanation: The input represents a min-heap.

               2
             /   \
            /	  \
           3	   4
          / \	  /
         /   \   /
        5	 10 15

    Input : [2, 10, 4, 5, 3, 15]
    Output: false
    Explanation: The input is not a min-heap, as it violate the heap property.

               2
             /   \
            /	  \
           10	   4
          / \	  /
         /   \   /
        5	  3 15

    */
    public static boolean checkMinHeap(int[] nums){
        if (nums.length < 2)
            return true;

        for (int i = 0; i <= (nums.length - 2) / 2; i++){
            if ((nums[i] > nums[2 * i + 1]) || (2 * i + 2 < nums.length && nums[i] > nums[2 * i + 2]))
                return false;
        }

        return true;
    }
}
