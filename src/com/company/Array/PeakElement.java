package com.company.Array;

public class PeakElement {
    /*

    Given an integer array `A`, find the peak element in it. An element `A[i]` is a peak element if it's greater than its neighbor(s). i.e.,

    • A[i-1] <= A[i] >= A[i+1]	(for 0 < i < n-1)
    • A[i-1] <= A[i]			(if i = n – 1)
    • A[i] >= A[i+1]			(if i = 0)


    Input: [8, 9, 10, 12, 15]
    Output: 15

    Input: [10, 8, 6, 5, 3, 2]
    Output: 10

    • There might be multiple peak elements in an array, the solution should report any peak element.

    Input: [8, 9, 10, 2, 5, 6]
    Output: 10 or 6

    Input: [8, 9, 2, 5, 6, 3]
    Output: 9 or 6

    • If the peak element is not located, the procedure should return -1.

    Input: []
    Output: -1

    */
    public static int findPeakElement(int[] nums){
        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid - 1] <= nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] <= nums[mid]))
                return nums[mid];
            else if (mid - 1 >= 0 && nums[mid - 1] > nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }
}
