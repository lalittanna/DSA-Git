package com.company.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combinations8 {
    /*

    Given a string, return all combinations of non-overlapping substrings of it.

    Input : "ABC"
    Output: {["A", "B", "C"], ["A", "BC"], ["AB", "C"], ["ABC"]}

    Input : "ABCD"
    Output: {["A", "B", "C", "D"], ["A", "B", "CD"], ["A", "BC", "D"], ["A", "BCD"], ["AB", "C", "D"], ["AB", "CD"], ["ABC", "D"], ["ABCD"]}

    */
    public static Set<List<String>> findCombinations(String s){
        Set<List<String>> combinations = new HashSet<>();

        if (s.length() > 0)
            combinations(combinations, new ArrayList<>(), s);

        return combinations;
    }

    public static void combinations(Set<List<String>> combinations, List<String> list, String s) {
        if (s.length() == 0){
            combinations.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < s.length(); i++){
            list.add(s.substring(0, i + 1));

            combinations(combinations, list, s.substring(i + 1));

            list.remove(list.size() - 1);
        }
    }
}
