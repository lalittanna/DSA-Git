package com.company.Array;

import java.util.*;

public class GeometricTriplets {
    /*

    Given a sorted array of distinct positive integers, return all triplets that forms a geometric progression with an integral common ratio. A geometric progression is a sequence of numbers where each term after the first is found by multiplying the previous one by a fixed, non-zero number called the common ratio.

    Input : [1, 2, 6, 10, 18, 54]
    Output: {[2, 6, 18], [6, 18, 54]}

    Input : [2, 8, 10, 15, 16, 30, 32, 64]
    Output: {[2, 8, 32], [8, 16, 32], [16, 32, 64]}

    Input : [1, 2, 6, 18, 36, 54]
    Output: {[2, 6, 18], [1, 6, 36], [6, 18, 54]}

    Input : [1, 2, 4, 16]
    Output: {[1, 2, 4], [1, 4, 16]}

    Input : [1, 2, 3, 6, 18, 22]
    Output: {[2, 6, 18]}

    */
    public static Set<List<Integer>> findTriplets(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();

        for (int j = 1; j < nums.length - 1; j++){
            int i = j - 1, k = j + 1;

            while (i >= 0 && k < nums.length){
                if (nums[i] * nums[k] == nums[j] * nums[j]){
                    List<Integer> list = new ArrayList<>();
                    Collections.addAll(list, nums[i], nums[j], nums[k]);
                    triplets.add(list);
                    i--; k++;
                } else if (nums[i] * nums[k] < nums[j] * nums[j])
                    k++;
                else
                    i--;
            }
        }

        return triplets;
    }
}
