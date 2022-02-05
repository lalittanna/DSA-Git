package com.company.Array;

public class MissingNumber3 {

    public static int findMissingNumber(int[] nums){
        int constant = (nums[nums.length - 1] - nums[0]) / nums.length;

        int low = 0, high = nums.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if (mid > 0 && nums[mid - 1] + constant != nums[mid])
                return nums[mid - 1] + constant;
            if (mid < nums.length - 1 && nums[mid] + constant != nums[mid + 1])
                return nums[mid] + constant;
            if (nums[mid] - nums[0] != (mid) * constant)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }
}
