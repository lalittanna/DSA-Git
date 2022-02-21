package com.company.Array;

import java.util.Random;

public class WaterJugsProblem {
    //Suppose we are given n red and n blue water jugs, all of different shapes and sizes. All red jugs hold different amounts of water, as do the blue ones. Moreover, there is a blue jug for every red jug that holds the same amount of water and vice versa. The task is to efficiently group the jugs into pairs of red and blue jugs that hold the same amount of water.
    public static void findMatchingPairs(int[] red, int[] blue, int low, int high) {
        if (low >= high)
                return;

        int r = new Random().nextInt(high - low + 1) + low;
        int chosenJug = red[r];

        int pivot = partition(red, low, high, chosenJug);
        partition(blue, low, high, chosenJug);

        findMatchingPairs(red, blue, low, pivot - 1);
        findMatchingPairs(red, blue, pivot + 1, high);
    }

    public static int partition(int[] A, int low, int high, int pivot) {
        int pivotIndex = low;
        for (int i = low; i < high; i++){
            if (A[i] < pivot) {
                swap(A, i, pivotIndex);
                pivotIndex++;
            }
            else if (A[i] == pivot){
                swap(A, i, high);
                i--;
            }
        }

        swap(A, pivotIndex, high);
        return pivotIndex;
    }

    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
