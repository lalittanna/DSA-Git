package com.company.Array;

public class CountOccurrences {
    /*

    Given a sorted integer array containing duplicates, return the count of occurrences of a given number.

    Input: nums[] = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9], target = 5
    Output: 3
    Explanation: Target 5 occurs 3 times

    Input: nums[] = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9], target = 6
    Output: 2
    Explanation: Target 6 occurs 2 times

    Input: nums[] = [5, 4, 3, 2, 1], target = 6
    Output: 0
    Explanation: Target 6 occurs 0 times

    */
    public static int countOccurrences(int[] nums, int target){
        int result = -1;
        int low = 0, high = nums.length - 1;

        while (low <= high){
            int mid = (low + high) / 2;

            if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] > target)
                high = mid - 1;
            else{
                result = mid;
                boolean searchFirst = true; // search for the starting index and then call the function again for the ending index, return endingIndex - startingIndex + 1;

                if (searchFirst)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }

        return result;
    }
}
