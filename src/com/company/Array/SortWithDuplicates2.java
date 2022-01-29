package com.company.Array;

import java.util.Map;
import java.util.TreeMap;

public class SortWithDuplicates2 {
    /*

    Given an integer array with many duplicated elements, efficiently sort it in linear time.

    Input : [4, 2, 40, 10, 10, 1, 4, 2, 1, 10, 40]
    Output: [1, 1, 2, 2, 4, 4, 10, 10, 10, 40, 40]

    Constraints:

    • The input elements lie in the range [0, 1000].
    • The relative order of equal elements doesn't matter.

    */

    public static void sort(int[] nums){
        Map<Integer, Integer> map = new TreeMap<>();

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        int k = 0;
        for (Integer key : map.keySet()){
            int count = map.get(key);
            while (count-- > 0)
                nums[k++] = key;
        }

        // final int RANGE = 1000;

        // int[] arr = new int[RANGE];

        // for (int i : nums)
        // 	arr[i]++;

        // int k = 0;
        // for (int i = 0; i < arr.length; i++){
        // 	while (arr[i]-- > 0)
        // 		nums[k++] = i;
        // }
    }
}
