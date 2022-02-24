package com.company.Math;

public class PowerOf2Integers {
    //Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.
    public int isPower(int A) {
        if (A == 1) return 1;

        for (int i = 2; i <= Math.sqrt(A); i++){
            int j = 2;
            int p = (int) Math.pow(i, j);

            while (p < A)
                p = (int) Math.pow(i, ++j);

            if (p == A) return 1;
        }

        return 0;
    }
}
