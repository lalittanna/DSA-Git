package com.company.Array;

public class OddOccurringElement4 {
    public static int findOddOccurringElement(int[] nums){
        int low = 0, high = nums.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid - 1] != nums[mid]) && (mid == nums.length - 1 || nums[mid] != nums[mid + 1]))
                return nums[mid];
            if ((mid & 1) == 0){
                if (nums[mid] == nums[mid + 1])
                    low = mid + 2;
                else
                    high = mid - 1;
            }
            else{
                if (nums[mid] == nums[mid - 1])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return - 1;
    }
}
