package com.company.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupElements {
    /*

    Given an unsorted integer array containing many duplicate elements, rearrange it such that the same element appears together and the relative order of the first occurrence of each element remains unchanged.

    Input : [1, 2, 3, 1, 2, 1]
    Output: [1, 1, 1, 2, 2, 3]

    Input : [5, 4, 5, 5, 3, 1, 2, 2, 4]
    Output: [5, 5, 5, 4, 4, 3, 1, 2, 2]

    Input : [7, 0, 4, 2, 5, 0, 6, 4, 0, 5]
    Output: [7, 0, 0, 0, 4, 4, 2, 5, 5, 6]

    */
    public static List<Integer> sortArray(List<Integer> nums)
    {
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (Integer num : nums){
            if (map.containsKey(num)) {
                int frequency = map.get(num);

                while (frequency > 0) {
                    list.add(num);
                    frequency--;
                }

                map.remove(num);
            }
        }

        return list;
    }
}
