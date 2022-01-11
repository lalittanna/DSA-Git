package com.company;

public class SumEvenNumbers {
    // return the sum of all even positive integers less than or equal to n.
    public static int sum(int n){
        // 2 + 4 + 6 + 8 + ... + n -> 2 (1 + 2 + 3 + ... + n / 2)
        return 2 * (n * (n + 1) / 2);
    }
}
