package com.company.Array;

public class SearchNearlySortedArray {
    /*

    Given a nearly sorted array such that each of its elements may be misplaced by no more than one position from the correct sorted order, efficiently search a given element in it and return its index.

    An element at index `i` in a correctly sorted order can be misplaced by the ±1 position, i.e., it can be present at index `i-1` or `i` or `i+1` in the input array.

    Input: nums[] = [2, 1, 3, 5, 4, 7, 6, 8, 9], target = 5
    Output: 3
    Explanation: Target 5 found at index 3

    • If there are duplicate elements in the array, the procedure may return any index whose element is equal to the target.

    Input: nums[] = [2, 1, 3, 5, 4, 5, 6, 8, 9], target = 5
    Output: 3 (or 5)
    Explanation: Target 5 found at index 3 and 5

    • If the target is not located, the procedure should return -1.

    Input: nums[] = [2, 1, 3, 5, 4, 7, 6, 8, 9], target = 10
    Output: -1

    */
    public static int findIndex(int[] nums, int target){
        int low = 0, high = nums.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;
            else if (mid + 1 <= high && nums[mid + 1] == target)
                return mid + 1;
            else if (mid - 1 >= low && nums[mid - 1] == target)
                return mid - 1;
            else if (nums[mid] > target)
                high = mid - 2;
            else
                low = mid + 2;
        }

        return -1;
    }
}
