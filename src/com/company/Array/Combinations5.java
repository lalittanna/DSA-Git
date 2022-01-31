package com.company.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Combinations5 {
    /*

    Given a positive integer `n`, find all combinations of numbers between 1 and `n` having sum `n`.

    Input : n = 4
    Output: {[4], [1, 3], [2, 2], [1, 1, 2], [1, 1, 1, 1]}

    Input : n = 5
    Output: {[5], [1, 4], [2, 3], [1, 1, 3], [1, 2, 2], [1, 1, 1, 2], [1, 1, 1, 1, 1]}

    The solution should return a set containing all the distinct combinations in increasing order.

    */
    public static Set<List<Integer>> findCombinations(int n)
    {
        Set<List<Integer>> combinations = new HashSet<>();

        findAllCombinations(combinations, 1, n, new int[n], 0);

        return combinations;
    }

    public static void findAllCombinations(Set<List<Integer>> set, int i, int n, int[] output, int index){
        if (n == 0)
            set.add(Arrays.stream(output).limit(index).boxed().collect(Collectors.toList()));


        for (int j = i; j <= n; j++){
            output[index] = j;
            findAllCombinations(set, j, n - j, output, index + 1);
        }
    }
}
