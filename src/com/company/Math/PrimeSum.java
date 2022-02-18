package com.company.Math;

public class PrimeSum {
//    Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
//    NOTE A solution will always exist. read Goldbach’s  conjecture
    public static int[] primesum(int A){
        int a = 2, b = A - a;
        int[] arr = new int[2];
        while(b >= a) {
            if(isPrime(a) && isPrime(b)) {
                arr[0] = a;
                arr[1] = b;
                break;
            }
            else {
                a++;
                b--;
            }
        }
        return arr;
    }

    public static boolean isPrime(int n){
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;


        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0) return false;

        return true;
    }
}
