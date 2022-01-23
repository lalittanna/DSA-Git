package com.company.Array;

public class DistinctAbsoluteCount {
/*

Given an array of sorted integers that may contain several duplicate elements, count the total number of distinct absolute values in it.

Input : [-1, -1, 0, 1, 1, 1]
Output: 2
Explanation: There are 2 distinct absolutes in the array [0, 1]

Input : [-2, -1, 0, 1, 2, 3]
Output: 4
Explanation: There are 4 distinct absolutes in the array [0, 1, 2, 3]

Input : [-1, -1, -1, -1]
Output: 1
Explanation: There is only 1 distinct absolute in the array [1]

*/
    public static int findDistinctCount(int[] nums)
    {
        int distinct = nums.length;

        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            while (left < right && nums[left] == nums[left + 1]){
                distinct--;
                left++;
            }

            while (left < right && nums[right - 1] == nums[right]){
                distinct--;
                right--;
            }

            if (right == left)
                break;

            int sum = nums[left] + nums[right];

            if (sum == 0){
                distinct--;
                left++;
                right--;
            } else if (sum < 0)
                left++;
            else
                right--;
        }

        return distinct;

        // Set<Integer> set = new HashSet<>();

        // for (int num : nums)
        // 	set.add(Math.abs(num));

        // return set.size();
    }
}
