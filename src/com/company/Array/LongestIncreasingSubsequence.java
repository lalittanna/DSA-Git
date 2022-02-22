package com.company.Array;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    /*

    Given a given sequence, find the length of the longest increasing subsequence (LIS) in it.

    The longest increasing subsequence is a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible.

    Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
    Output: 6
    Explanation: The longest increasing subsequence is [0, 2, 6, 9, 11, 15] having length 6; the input sequence has no 7–member increasing subsequences.

    The longest increasing subsequence is not necessarily unique. For instance, [0, 4, 6, 9, 11, 15] and [0, 4, 6, 9, 13, 15] are other increasing subsequences of equal length in the same input sequence.

    */
    public static int findLISLength(int[] nums){
        List<Integer> list = new ArrayList<>();

        int last = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > last) {
                list.add(num);
                last = num;
            } else {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) >= num) {
                        list.set(j, num);
                        last = list.get(list.size() - 1);
                        break;
                    }
                }
            }
        }

        return list.size();

        //return longestSubSequence(nums, Integer.MIN_VALUE, 0);
    }

    public static int longestSubSequence(int[] nums, int last, int i) {
        if (i == nums.length)
            return 0;

        int excl = longestSubSequence(nums, last, i + 1);

        int incl = 0;
        if (nums[i] > last)
            incl = 1 + longestSubSequence(nums, nums[i], i + 1);


        return Math.max(incl, excl);
    }
}
