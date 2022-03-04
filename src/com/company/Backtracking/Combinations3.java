package com.company.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combinations3 {
    /*

    Given a positive number `n`, find all combinations of `2×n` elements such that every element from 1 to `n` appears exactly twice and the distance between its two appearances is exactly equal to the value of the element.

    Input : n = 3
    Output: {[3, 1, 2, 1, 3, 2], [2, 3, 1, 2, 1, 3]}

    Input : n = 4
    Output: {[4, 1, 3, 1, 2, 4, 3, 2], [2, 3, 4, 2, 1, 3, 1, 4]}

    Input : n = 5
    Output: {}

    */
    public static Set<List<Integer>> findCombinations(int n){
        Set<List<Integer>> combinations = new HashSet<>();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 2 * n; i++)
            list.add(-1);

        combinations(combinations, list, 1, n);

        return combinations;
    }

    public static void combinations(Set<List<Integer>> combinations, List<Integer> list, int x, int n){
        if (x > n){
            List<Integer> combination = new ArrayList<>(list);
            combinations.add(combination);
        }

        for (int i = 0; i < 2 * n; i++){
            if (list.get(i) == -1 && i + x + 1 < 2 * n && list.get(i + x + 1) == -1){
                list.set(i, x);
                list.set(i + x + 1, x);

                combinations(combinations, list, x + 1, n);

                list.set(i, -1);
                list.set(i + x + 1, -1);
            }
        }
    }
}
