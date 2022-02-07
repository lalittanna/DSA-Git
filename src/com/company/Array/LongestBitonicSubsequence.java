package com.company.Array;

public class LongestBitonicSubsequence {
    /*

Given a sequence, find the longest bitonic subsequence in which the subsequence's elements are first sorted in increasing order, then in decreasing order.

Input: [4, 2, 5, 9, 7, 6, 10, 3, 1]
Output: 7
Explanation: The longest bitonic subsequence is [4, 5, 9, 7, 6, 3, 1].

For sequences sorted in increasing or decreasing order, the output is the same as the input sequence, i.e.,

Input: [1, 2, 3, 4, 5]
Output: 5

Input: [5, 4, 3, 2, 1]
Output: 5

*/
    public static int findLBSLength(int[] nums){
        int n = nums.length;
        int max = 0;

        if (n == 0)
            return max;

        int[] I = new int[n];
        int[] D = new int[n];

        I[0] = 1;
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i] && I[j] > I[i])
                    I[i] = I[j];
            }
            I[i]++;
        }

        D[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--){
            for (int j = n - 1; j > i; j--){
                if (nums[j] < nums[i] && D[j] > D[i])
                    D[i] = D[j];
            }
            D[i]++;
        }

        for (int i = 0; i < n; i++)
            max = Integer.max(max, I[i] + D[i] - 1);

        return max;
    }
}
