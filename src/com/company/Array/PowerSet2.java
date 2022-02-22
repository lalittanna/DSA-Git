package com.company.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet2 {
    /*

    Given a set S, return all distinct subsets of it, i.e., find distinct power set of set S. A power set of any set S is the set of all subsets of S, including the empty set and S itself.

    Input : S[] = [1, 2, 3]
    Output: [[1, 2, 3], [2, 3], [1, 3], [3], [1, 2], [2], [1], []]

    Input : S[] = [1, 2, 1]
    Output: [[1, 1, 2], [1, 2], [2], [1, 1], [1], []]

    Input : S[] = [1, 1]
    Output: [[1, 1], [1], []]

    Input : S[] = []
    Output: [[]]

    Note: The solution can return elements of a subsets in any order.

    */
    public static List<List<Integer>> findPowerSet(int[] S){
        List<List<Integer>> powerset = new ArrayList<>();

        Arrays.sort(S);

        int N = (int)Math.pow(2, S.length);

        for (int i = 0; i < N; i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < S.length; j++){
                if ((i & (1 << j)) != 0)
                    list.add(S[j]);
            }

            powerset.add(list);
        }

        return powerset;

        // List<List<Integer>> powerset = new ArrayList<>();

        // Arrays.sort(S);

        // powerSet(powerset, new ArrayList<>(), S, S.length - 1);

        // return powerset;
    }

    public static void powerSet(List<List<Integer>> powerset, List<Integer> list, int[] S, int i) {
        if (i < 0){
            List<Integer> set = new ArrayList<>(list);
            powerset.add(set);
            return;
        }

        list.add(S[i]);
        powerSet(powerset, list, S, i - 1);
        list.remove(list.size() - 1);

        while (i > 0 && S[i] == S[i - 1])
            i--;

        powerSet(powerset, list, S, i - 1);
    }
}
