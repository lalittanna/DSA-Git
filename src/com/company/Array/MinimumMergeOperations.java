package com.company.Array;

public class MinimumMergeOperations {
    /*

    Given a list of non-negative integers, find the minimum number of merge operations to make it a palindrome.

    Input : [6, 1, 3, 7]
    Output: 1
    Explanation: [6, 1, 3, 7] —> Merge 6 and 1 —> [7, 3, 7]

    Input : [6, 1, 4, 3, 1, 7]
    Output: 2
    Explanation: [6, 1, 4, 3, 1, 7] —> Merge 6 and 1 —> [7, 4, 3, 1, 7] —> Merge 3 and 1 —> [7, 4, 4, 7]

    Input : [1, 3, 3, 1]
    Output: 0
    Explanation: The list is already a palindrome

    */
    public static int findMin(int[] nums){
        int merges = 0;
        int low = 0, high = nums.length - 1;

        while (low < high){
            if (nums[low] < nums[high]){
                nums[low + 1] += nums[low];
                low++;
                merges++;
            } else if (nums[high] < nums[low]){
                nums[high - 1] += nums[high];
                high--;
                merges++;
            } else {
                low++;
                high--;
            }
        }

        return merges;
    }
}
