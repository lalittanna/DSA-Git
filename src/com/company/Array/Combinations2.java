package com.company.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combinations2 {
    /*

    Find all combinations of positive integers in increasing order that sum to a given positive number `N`.

    Input : N = 3
    Output: {[1, 1, 1], [1, 2], [3]}

    Input : N = 4
    Output: {[1, 1, 1, 1], [1, 1, 2], [1, 3], [2, 2], [4]}

    Input : N = 5
    Output: {[1, 1, 1, 1, 1], [1, 1, 1, 2], [1, 1, 3], [1, 2, 2], [1, 4], [2, 3], [5]}

    */
    public static Set<List<Integer>> findCombinations(int n){
        Set<List<Integer>> combinations = new HashSet<>();

        List<Integer> list = new ArrayList<>();
        combinations(combinations, list, 1, n);

        return combinations;
    }

    public static void combinations(Set<List<Integer>> set, List<Integer> list, int i, int n){
        if (n == 0){
            List<Integer> combination = new ArrayList<>(list);
            set.add(combination);
            return;
        }

        for (int j = i; j <= n; j++){
            list.add(j);
            combinations(set, list, j, n - j);
            list.remove(list.size() - 1);
        }
    }
}
