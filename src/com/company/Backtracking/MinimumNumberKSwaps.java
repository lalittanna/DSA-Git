package com.company.Backtracking;

public class MinimumNumberKSwaps {
    /*

    Given string representation of a positive integer, find the minimum number possible by doing at-most `k` swap operations upon its digits.

    Input : s = "934651", k = 1
    Output: 134659

    Input : s = "934651", k = 2
    Output: 134569

    Input : s = "52341", k = 2
    Output: 12345 (Only 1 swap needed)

    Input : s = "12345", k = 2
    Output: 12345 (no change as all digits are already sorted in increasing order)

    */
    public static String findMinNumber(String s, int k){
        if (s.length() == 0) return s;

        char[] digits = s.toCharArray();
        return min(digits, k, s);
    }

    public static String min(char[] digits, int k, String minSoFar){
        String curr = new String(digits);
        if (curr.compareTo(minSoFar) < 0)
            minSoFar = curr;

        if (k < 1) return minSoFar;

        for (int i = 0; i < digits.length - 1; i++){
            for (int j = i + 1; j < digits.length; j++){
                if (digits[j] < digits[i]){
                    swap(digits, i, j);

                    minSoFar = min(digits, k - 1, minSoFar);

                    swap(digits, i, j);
                }
            }
        }

        return minSoFar;
    }

    public static void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
}
