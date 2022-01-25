package com.company.Array;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestConsecutiveSubsequence {
    /*

    Given an integer array, find the length of the longest subsequence formed by the consecutive integers. The subsequence should contain all distinct values, and the character set should be consecutive, irrespective of its order.

    Input : [2, 0, 6, 1, 5, 3, 7]
    Output: 4
    Explanation: The longest subsequence formed by the consecutive integers is [2, 0, 1, 3]. It has distinct values and length 4.

    Input : [1, 4, 4, 0, 2, 3]
    Output: 5
    Explanation: The longest subsequence formed by the consecutive integers is [1, 4, 4, 0, 2, 3]. The distinct subsequence is [1, 4, 0, 2, 3] having length 5.

    Input : [2, 4, 6, 3, 7, 4, 8, 1]
    Output: 4
    Explanation: The longest subsequence formed by the consecutive integers is [2, 4, 3, 4, 1]. The distinct subsequence is [2, 4, 3, 1] having length 4.

    */
    public static int findMaxLenSubseq(int[] nums){
        Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());

        int maxLength = 0;

        for (int num : nums){
            if (!set.contains(num - 1)){
                int length = 1;

                while (set.contains(num + length))
                    length++;

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;

        // if (nums.length < 1)
        // 	return 0;

        // Arrays.sort(nums);

        // int max = 1;
        // int maxSoFar = 1;

        // for (int i = 1; i < nums.length; i++){
        // 	if (nums[i - 1] != nums[i] - 1){
        // 		if (nums[i - 1] == nums[i])
        // 			continue;
        // 		maxSoFar = 0;
        // 	}
        // 	maxSoFar++;

        // 	max = Integer.max(max, maxSoFar);
        // }

        // return max;
    }
}
