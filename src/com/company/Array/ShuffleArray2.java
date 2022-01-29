package com.company.Array;

import java.util.*;
import java.util.stream.Collectors;

class CustomComparator implements Comparator<Integer> {
    Map<Integer, Integer> map;

    public CustomComparator(Map<Integer, Integer> map){
        this.map = map;
    }

    public int compare(Integer x, Integer y){
        if (map.containsKey(x) && map.containsKey(y))
            return map.get(x) - map.get(y);
        else if (map.containsKey(y))
            return 1;
        else if (map.containsKey(x))
            return -1;
        else
            return x - y;
    }
}

public class ShuffleArray2 {
    /*

Given two integer arrays, reorder elements of the first array by the order of elements defined by the second array.

The elements that are not present in the second array but present in the first array should be appended at the end in sorted order. The second array can contain some extra elements which are not part of the first array.

Input:

nums[] = [5, 8, 9, 3, 5, 7, 1, 3, 4, 9, 3, 5, 1, 8, 4]
 pos[] = [3, 5, 7, 2]

Output : [3, 3, 3, 5, 5, 5, 7, 1, 1, 4, 4, 8, 8, 9, 9]

*/
    public static void shuffle(int[] nums, int[] pos){

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pos.length; i++)
            map.put(pos[i], i);

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        list.sort(new CustomComparator(map));

        for(int i = 0; i < nums.length; i++)
            nums[i] = list.get(i);



        // Map<Integer, Integer> map = new TreeMap<>();

        // for (int num : nums)
        // 	map.put(num, map.getOrDefault(num, 0) + 1);

        // int i = 0;
        // for (int num : pos){
        // 	int count = map.getOrDefault(num, 0);
        // 	while (count-- > 0)
        // 		nums[i++] = num;
        // 	map.remove(num);
        // }

        // for (Integer num : map.keySet()){
        // 	int count = map.get(num);
        // 	while (count-- > 0)
        // 		nums[i++] = num;
        // }
    }
}
