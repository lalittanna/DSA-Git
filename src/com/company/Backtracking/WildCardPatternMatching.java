package com.company.Backtracking;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class WildCardPatternMatching {
    /*

    Given a binary pattern containing '?' wildcard character at a few positions, return all possible combinations of binary strings that can be formed by replacing the wildcard character by either '0' or '1'.

    Input: "1?11?00?1?"
    Output: {"1011000010", "1011000011", "1011000110", "1011000111", "1011100010", "1011100011", "1011100110", "1011100111", "1111000010", "1111000011", "1111000110", "1111000111", "1111100010", "1111100011", "1111100110", "1111100111"}

    */
    public static Set<String> findCombinations(String s){
        Set<String> combinations = new HashSet<>();

        if (s.length() == 0) return combinations;

        Stack<String> stack = new Stack<>();
        stack.push(s);

        int index;

        while (!stack.isEmpty()){
            String curr = stack.pop();

            if ((index = curr.indexOf('?')) != -1){
                for (char ch = '0'; ch <= '1'; ch++){
                    curr = curr.substring(0, index) + ch + curr.substring(index + 1);
                    stack.push(curr);
                }
            } else
                combinations.add(curr);
        }

        // char[] digits = s.toCharArray();

        // combinations(combinations, digits, 0);

        return combinations;
    }

    public static void combinations(Set<String> combinations, char[] digits, int i){
        if (i == digits.length){
            combinations.add(new String(digits));
            return;
        }

        if (digits[i] == '?'){
            for (char ch = '0'; ch <= '1'; ch++){
                digits[i] = ch;

                combinations(combinations, digits, i + 1);

                digits[i] = '?';
            }
        } else
            combinations(combinations, digits, i + 1);
    }
}
