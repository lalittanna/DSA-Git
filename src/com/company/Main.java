package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Universe");
        int[] arr = {1, 2, 3};
        System.out.println(findPowerSet(arr));
    }

    public static List<List<Integer>> findPowerSet(int[] S){
        List<List<Integer>> powerset = new ArrayList<>();

        Arrays.sort(S);

        powerSet(powerset, new ArrayList<>(), S, S.length - 1);

        return powerset;
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
