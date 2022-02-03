package com.company.Array;

public class SearchCircularArray {
    /*

Given a circularly sorted integer array, search a target element in it. If the target exists in the array, the procedure should return the index of it. If the target is not located, the procedure should return -1. You may assume there are no duplicates in the array, and the rotation is in the anti-clockwise direction.

Input: nums[] = [8, 9, 10, 2, 5, 6], target = 10
Output: 2
Explanation: Element found at 3rd (index 2) position.

Input: nums[] = [9, 10, 2, 5, 6, 8], target = 5
Output: 3
Explanation: Element found at 4th (index 3) position.

Input: nums[] = [8, 9, 1, 4, 5], target = 2
Output: -1
Explanation: Target not found

*/
    public static int findIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            int mid = (low + high) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] <= nums[high]){
                if (target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }else {
                if (target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }

        return -1;
    }
}
