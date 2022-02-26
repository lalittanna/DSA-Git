package com.company.Array;

import java.util.Comparator;
import java.util.List;

public class TruncateArray {
    /*

    Given an array of positive integers, truncate it such that `2×min` becomes more than `max`, and the total number of removals is minimal. The `min` and `max` are the minimum and the maximum elements in the array, respectively. The elements can be removed either from the start or end of the array if the above condition does not meet.

    Input: [4, 6, 1, 7, 5, 9, 2]
    Output: 4
    Explanation: The minimum number of removals is 4. The truncated array is [7, 5, 9] where 9 < 2 × 5.

    Input: [4, 2, 6, 4, 9]
    Output: 3
    Explanation: The minimum number of removals is 3. The truncated array is [6, 4] where 6 < 2 × 4.

    */
    public static int truncate(List<Integer> nums){
        int n = nums.size();

        if (n == 0) return 0;

        int[][] T = new int[n][n];

        for (int diagonal = 0; diagonal < n; diagonal++){
            for (int j = diagonal, i = 0; j < n; j++, i++){
                int min = nums.subList(i, j + 1).stream().min(Comparator.naturalOrder()).get();
                int max = nums.subList(i, j + 1).stream().max(Comparator.naturalOrder()).get();

                if (min * 2 <= max)
                    T[i][j] = Math.min(1 + T[i + 1][j], 1 + T[i][j - 1]);
            }
        }

        return T[0][n - 1];

        //return min(nums, 0, nums.size() - 1);
    }

    public static int min(List<Integer> nums, int low, int high){
        if (high < low) return 0;

        int min = nums.subList(low, high + 1).stream().min(Comparator.naturalOrder()).get();
        int max = nums.subList(low, high + 1).stream().max(Comparator.naturalOrder()).get();

        if (2 * min <= max){
            int L = 1 + min(nums, low + 1, high);
            int R = 1 + min(nums, low, high - 1);

            return Math.min(L, R);
        }

        return 0;
    }
}
