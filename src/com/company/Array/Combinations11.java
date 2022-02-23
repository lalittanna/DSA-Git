package com.company.Array;

import java.util.ArrayList;
import java.util.List;

public class Combinations11 {
    /*

    Given an array of single-digit positive integers, return all possible combinations of words formed by replacing the continuous digits with corresponding character in the English alphabet, i.e., subset [1] can be replaced by A, [2] can be replaced by B, [1, 0] can be replaced by J, [2, 1] can be replaced by U, etc.

    Input: [1, 2, 2]
    Output: ["ABB", "AV", "LB"]
    Explanation:

    [1, 2, 2] = "ABB"
    [1, 22] = "AV"
    [12, 2] = "LB"

    Input: [1, 2, 2, 1]
    Output: ["ABBA", "ABU", "AVA", "LBA", "LU"]
    Explanation:

    [1, 2, 2, 1] = "ABBA"
    [1, 2, 21] = "ABU"
    [1, 22, 1] = "AVA"
    [12, 2, 1] = "LBA"
    [12, 21] = "LU"

    */
    private static final String alphabets = "abcdefghijklmnopqrstuvwxyz";

    public static List<String> findCombinations(int[] digits){
        List<String> list = new ArrayList<>();

        combinations(list, digits, "", 0);

        return list;
    }

    public static void combinations(List<String> list, int[] digits, String s, int i) {
        if (i == digits.length){
            list.add(s);
            return;
        }

        int sum = 0;

        for (int j = i; j <= Integer.min(i + 1, digits.length - 1); j++){
            sum = sum * 10 + digits[j];

            if (sum > 0 && sum < 26)
                combinations(list, digits, s + alphabets.charAt(sum - 1), j + 1);
        }
    }
}
