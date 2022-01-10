package com.company.Array;

import java.util.*;

public class GetAllZeroSumArrays {
    /*

    Given an integer array, find all contiguous subarrays with zero-sum.

    Input : [4, 2, -3, -1, 0, 4]
    Output: {[-3, -1, 0, 4], [0]}

    Input : [3, 4, -7, 3, 1, 3, 1, -4, -2, -2]
    Output: {[3, 4, -7], [4, -7, 3], [-7, 3, 1, 3], [3, 1, -4], [3, 1, 3, 1, -4, -2, -2], [3, 4, -7, 3, 1, 3, 1, -4, -2, -2]}

    Input : [0, 0]
    Output: {[0], [0, 0]}

    Input : [1, 2, 3]
    Output: {}

    Note: Since an input can have multiple subarrays with zero-sum, the solution should return a set containing all the distinct subarrays.

    */

    /* first solution could be taken to O(n^2) if we just want to have the starting and ending index of the subarray rather than
     all elements.
    */
    public static Set<List<Integer>> getAllZeroSumSubarrays(List<Integer> nums)
    {
        Set<List<Integer>> subarrays = new HashSet<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        List<Integer> initialList = new ArrayList<>();
        initialList.add(-1);
        map.put(0, initialList);

        int sum = 0;

        for (int i = 0; i < nums.size(); i++){
            sum += nums.get(i);

            if (map.containsKey(sum)){
                // [1, 3]
                List<Integer> list = map.get(sum);
                for (int index : list){
                    List<Integer> tempList = new ArrayList<>();
                    for (int j = index + 1; j <= i; j++){
                        tempList.add(nums.get(j));
                    }
                    subarrays.add(tempList);
                }
            }

            insert(map, sum, i);
        }

        return subarrays;

        // for (int i = 0; i < nums.size(); i++)
        //       {
        //           int sum = 0;

        //           // consider all subarrays ending at `j`
        //           for (int j = i; j < nums.size(); j++)
        //           {
        //               // sum of elements so far
        //               sum += nums.get(j);

        //               // if the sum is seen before, we have found a subarray with zero-sum
        //               if (sum == 0) {
        //               	List<Integer> list = new ArrayList<>();
        //                   for (int k = i; k <= j; k++){
        //                   	list.add(nums.get(k));
        //                   }
        //                   subarrays.add(list);
        //               }
        //           }
        //       }
    }

    public static void insert(Map<Integer, List<Integer>> map, int key, int value){
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(value);
    }
}
