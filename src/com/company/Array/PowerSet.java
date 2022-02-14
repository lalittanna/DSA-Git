package com.company.Array;

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

        int N = (int) (1<<S.length);

        for (int i = 0; i < N; i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < S.length; j++){
                if ((i & (1<<j)) != 0)
                    list.add(S[j]);
            }

            powerset.add(list);
        }

        //sets(S, powerset, new ArrayList<>(), S.length);

        return powerset;
    }

    public static void sets(int[] S, List<List<Integer>> powerset, List<Integer> list, int n){
        if (n == 0){
            List<Integer> ls = new ArrayList<>(list);
            powerset.add(ls);
            return;
        }

        list.add(S[n - 1]);
        sets(S, powerset, list, n - 1);

        list.remove(list.size() - 1);
        sets(S, powerset, list, n - 1);
    }
}
