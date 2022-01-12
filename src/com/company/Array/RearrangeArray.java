package com.company.Array;

import java.util.List;

public class RearrangeArray {
    /*

Given an integer array, rearrange it such that every second element becomes greater than its left and right elements.

• Assume that no duplicate elements are present in the input array.
• The solution should perform single traveral of the array.
• In case the multiple rearrangement exists, the solution can return any one of them.

Input : [1, 2, 3, 4, 5, 6, 7]
Output: [1, 3, 2, 5, 4, 7, 6] or [1, 5, 2, 6, 3, 7, 4], or any other valid combination..

Input : [6, 9, 2, 5, 1, 4]
Output: [6, 9, 2, 5, 1, 4] or [1, 5, 2, 6, 4, 9], or any other valid combination..

*/
    public static void rearrange(List<Integer> nums)
    {
        for (int i = 1; i < nums.size(); i += 2){
            if (nums.get(i - 1) > nums.get(i))
                swap(nums, i - 1, i);

            if (i + 1 < nums.size() && nums.get(i + 1) > nums.get(i))
                swap(nums, i + 1, i);
        }


        // if (nums.size() < 3)
        // 	return;

        // Collections.sort(nums);

        // int low = 1;
        // int high = (nums.size() % 2 == 0) ? nums.size() - 2 : nums.size() - 1;

        // // every even from begining should be replaced by every odd from second
        // while (low <= high){
        // 	swap(nums, low, high);
        // 	low += 2;
        // 	high -= 2;
        // }
    }

    public static void swap(List<Integer> nums, int i, int j){
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
