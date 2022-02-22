package com.company.Math;

public class Rectangle {
//    Given four positive integers A, B, C, D, determine if there’s a rectangle such that the lengths of its sides are A, B, C and D (in any order).
//    If any such rectangle exist return 1 else return 0.
    public static int solve(int A, int B, int C, int D) {
        if (A == B && C == D) return 1;
        if (A == C && B == D) return 1;
        if (A == D && C == B) return 1;
        return 0;
    }
}
