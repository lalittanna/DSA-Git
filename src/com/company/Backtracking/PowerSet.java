package com.company.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    /*

    Given a set S, return all subsets of it, i.e., find the power set of S. A power set of a set S is the set of all subsets of S, including the empty set and S itself.

    Input : S[] = [1, 2, 3]
    Output: [[3, 2, 1], [3, 2], [3, 1], [3], [2, 1], [2], [1], []]

    Input : S[] = [1, 2, 1]
    Output: [[1, 2, 1], [1, 2], [1, 1], [1], [2, 1], [2], [1], []]

    Input : S[] = [1, 1]
    Output: [[1, 1], [1], [1], []]

    Input : S[] = []
    Output: [[]]

    Note: The solution can return elements of a subsets in any order.

    */
    public static List<List<Integer>> findPowerSet(int[] S){
        List<List<Integer>> powerset = new ArrayList<>();

        // for (int i = 0; i < Math.pow(2, S.length); i++){
        // 	List<Integer> set = new ArrayList<>();

        // 	for (int k = 0; k < S.length; k++)
        // 		if ((i & (1 << k)) != 0) set.add(S[k]);

        // 	powerset.add(set);
        // }

        powerSet(powerset, new ArrayList<>(), S, S.length - 1);

        return powerset;
    }

    public static void powerSet(List<List<Integer>> powerset, List<Integer> set, int[] S, int n){
        if (n < 0) {
            powerset.add(new ArrayList<>(set));
            return;
        }

        set.add(S[n]);

        powerSet(powerset, set, S, n - 1);

        set.remove(set.size() - 1);

        powerSet(powerset, set, S, n - 1);
    }
}
