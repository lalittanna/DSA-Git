package com.company.Math;

public class StepByStep {
//    Given a target A on an infinite number line, i.e. -infinity to +infinity.
//    You are currently at position 0 and you need to reach the target by moving according to the below rule:
//    In ith move you can take i steps forward or backward.
//    Find the minimum number of moves required to reach the target.
    public int solve(int A) {
        A = Math.abs(A);
        int minSteps = (int) Math.sqrt(2 * A);

        while (((minSteps * (minSteps + 1)) / 2) < A) minSteps++;

        if (((minSteps * (minSteps + 1)) / 2) == A) return minSteps;

        while ((((minSteps * (minSteps + 1)) / 2) - A) % 2 == 1) minSteps++;

        return minSteps;
    }
}
