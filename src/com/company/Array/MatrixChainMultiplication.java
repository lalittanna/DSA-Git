package com.company.Array;

public class MatrixChainMultiplication {
    /*

    Matrix chain multiplication is an optimization problem that to find the most efficient way to multiply a given sequence of matrices. The problem is not actually to perform the multiplications but merely to decide the sequence of the matrix multiplications involved.

    You're given an array `dims` of `n` positive integers, where matrix `M[i]` has dimension `dims[i-1] × dims[i]` for `i=1…n`. Determine the optimal parenthesization of the product of matrices `M[1…n]`.

    Input: [10, 30, 5, 60]
    Output: 4500
    Explanation: Here A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C is a 5 × 60 matrix. Computing (AB)C needs (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations.

    Note that the order in which the product is parenthesized affects the number of simple arithmetic operations needed to compute the product. For example, computing A(BC) needs (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations. The former ordering is more efficient.

    The matrix multiplication is associative as no matter how the product is parenthesized, the result obtained will remain the same. For example, for four matrices A, B, C, and D, we would have:

    ((AB)C)D = ((A(BC))D) = (AB)(CD) = A((BC)D) = A(B(CD))

    */
    public static int findOptimalProduct(int[] dims){
        int n = dims.length;

        int[][] c = new int[n + 1][n + 1];

        for (int len = 2; len <= n; len++){
            for (int i = 1; i <= n - len + 1; i++){
                int j = i + len - 1;

                c[i][j] = Integer.MAX_VALUE;

                for (int k = i; j < n && k <= j - 1; k++){
                    int cost = c[i][k] + c[k + 1][j] + dims[i - 1] * dims[k] * dims[j];

                    c[i][j] = Math.min(c[i][j], cost);
                }
            }
        }

        return c[1][n - 1];

        //int[][] lookUp = new int[n][n];
        //return matrixChainMultiplication(dims, 0, dims.length - 1, lookUp);
    }

    public static int matrixChainMultiplication(int[] dims, int i, int j, int[][] lookUp){
        if (j <= i + 1)
            return 0;

        int min = Integer.MAX_VALUE;

        if (lookUp[i][j] == 0){
            for (int k = i + 1; k < j; k++){
                int cost = matrixChainMultiplication(dims, i, k, lookUp);
                cost += matrixChainMultiplication(dims, k, j, lookUp);

                cost += dims[i] * dims[k] * dims[j];

                min = Math.min(min, cost);
            }

            lookUp[i][j] = min;
        }

        return lookUp[i][j];
    }
}
