package com.company.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combinations5 {
    /*

    Given a positive integer `n`, find all combinations of numbers between 1 and `n` having sum `n`.

    Input : n = 4
    Output: {[4], [1, 3], [2, 2], [1, 1, 2], [1, 1, 1, 1]}

    Input : n = 5
    Output: {[5], [1, 4], [2, 3], [1, 1, 3], [1, 2, 2], [1, 1, 1, 2], [1, 1, 1, 1, 1]}

    The solution should return a set containing all the distinct combinations in increasing order.

    */
    public static Set<List<Integer>> findCombinations(int n){
        Set<List<Integer>> combinations = new HashSet<>();

        combinations(combinations, new ArrayList<>(), 1, n);

        return combinations;
    }

    public static void combinations(Set<List<Integer>> combinations, List<Integer> list, int j, int n){
        if (n == 0){
            List<Integer> combination = new ArrayList<>(list);
            combinations.add(combination);
            return;
        }

        for (int i = j; i <= n; i++){
            if (n - i < 0) break;

            list.add(i);

            combinations(combinations, list, i, n - i);

            list.remove(list.size() - 1);
        }
    }
}
