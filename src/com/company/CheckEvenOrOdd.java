package com.company;

public class CheckEvenOrOdd {
    // return true if input is odd without using multiplication, modulus, or division.
    public static boolean evenOdd(int i){
        return (i & 1) != 0;
    }
}
