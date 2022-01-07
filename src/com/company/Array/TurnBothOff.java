package com.company.Array;

/*
Given a binary array of size two having at least one element as zero,
write a single line function to set both its elements to zero.
Use of ternary operator and direct assignment of elements are not allowed.
 */
public class TurnBothOff {
    public static void transform(int[] array){
        // [0, 1] or [1, 0] or [0, 0]

        array[0] = array[1] = array[0] & array[1];
        array[0] = array[1] -= array[1];
        array[array[1]] = array[array[0]];
        array[array[1]] = 0;
    }
}
