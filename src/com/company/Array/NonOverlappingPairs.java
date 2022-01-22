package com.company.Array;

import java.util.*;

public class NonOverlappingPairs {
    /*

Given an unsorted integer array, find all non-overlapping pairs in it having the same sum.

Input : [3, 7, 6, 2]
Output: {{(7, 2), (3, 6)}}
Explanation: The pairs (7, 2) and (3, 6) are non-overlapping (having different indices) and have the same sum.

Input : [3, 4, 7, 4]
Output: {}
Explanation: No non-overlapping pairs are present in the array. The pairs (3, 4) and (3, 4) are overlapping as the index of 3 is the same in both pairs.

• The input can contain multiple non-overlapping pairs with the same sum, the solution should return a set containing all the distinct pairs.

Input : [3, 4, 7, 6, 1]
Output: {{(6, 1), (3, 4)}, {(4, 6), (3, 7)}}

Input : [3, 7, 6, 2, 4, 5]
Output: {{(7, 2), (3, 6)}, {(6, 2), (3, 5)}, {(6, 4), (3, 7)}, {(6, 5), (7, 4)}, {(2, 5), (3, 4)}, {(4, 5), (3, 6)}, {(4, 5), (7, 2)}}

Note: The solution should return all pairs in the same order as they appear in the array.

*/
    private class Pair<U, V>{
        public Integer first;
        public Integer second;
        public Pair(Integer first, Integer second){
            this.first = first;
            this.second = second;
        }
        public static Pair of(int first, int second){
            //Pair<Integer, Integer> pair = new Pair<>(first, second);
            return null;
        }
    }
    /* The Pair<U, V> class have
		1. Two member variables, first and second.
		2. Factory method `Pair.of(U, V)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/

    public static Set<Set<Pair>> findPairs(int[] nums) {
        Set<Set<Pair>> result = new HashSet<>();

        Map<Integer, List<Pair>> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++){
            for (int j = i + 1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                if (map.containsKey(sum)){
                    for (Pair pair : map.get(sum)){
                        int x = (int)pair.first;
                        int y = (int)pair.second;

                        if (x != i && x != j && y != i && y != j) {
                            Set<Pair> set = new HashSet<>();
                            set.add(Pair.of(nums[x], nums[y]));
                            set.add(Pair.of(nums[i], nums[j]));
                            result.add(set);
                        }
                    }
                }

                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(Pair.of(i, j));
            }
        }

        return result;
    }
}
