package com.company.Array;

/*

Given two sorted integer arrays, `X[]` and `Y[]`, and an integer `k`, find a pair `(x, y)` whose sum is closest to `k`, where the pair consists of elements from each array. The solution should return the pair `(x, y)` `x` is taken from the first array, and `y` from the second array.

Input:

X[] = [1, 8, 10, 12]
Y[] = [2, 4, 9, 15]
k = 11

Output: (1, 9)


• For some inputs, the multiple pairs are feasible. For such cases, the pair should contain elements with the least index. For example, the solution should return pair (2, 1), and not (2, 3) for the following example:

Input:

X[] = [2, 4, 6, 8, 10]
Y[] = [1, 3, 5, 7, 9]
k = 4

Output: (2, 1)


• If no pair exists, the solution should return null.

Input:

X[] = [1, 2, 3]
Y[] = []
k = 4

Output: null

*/
public class ClosestPair {
    private class Pair<U, V>{
        public Integer first;
        public Integer second;
        public Pair(Integer first, Integer second){
            this.first = first;
            this.second = second;
        }
        public static Pair of(int first, int second){
            //Pair<Integer, Integer> pair = new Pair<>(first, second);
            return null;
        }
    }

    /* The Pair<U, V> class have
		1. Two member variables, first and second.
		2. Factory method `Pair.of(U, V)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/

    public static Pair<Integer, Integer> findClosestPair(int[] X, int[] Y, int k)
    {
        if (X.length == 0 || Y.length == 0)
            return null;

        int U = 0, V = Y.length - 1;

        for (int i = 0, j = Y.length - 1; i < X.length && j >= 0;){
            if (Math.abs(X[i] + Y[j] - k) < Math.abs(X[U] + Y[V] - k)){
                U = i;
                V = j;
            }

            if (X[i] + Y[j] > k)
                j--;
            else if (X[i] + Y[j] < k)
                i++;
            else {
                i++;
                j--;
            }
        }

        return Pair.of(X[U], Y[V]);

        // int closestSum = Integer.MAX_VALUE;
        // int U = -1, V = -1;

        // for (int i = 0; i < X.length; i++){
        // 	for (int j = 0; j < Y.length; j++){
        // 		int sum = X[i] + Y[j];

        // 		if (sum == k)
        // 			return Pair.of(X[i], Y[j]);

        // 		if (Math.abs(sum - k) < closestSum){
        // 			closestSum = Math.abs(sum - k);
        // 			U = i;
        // 			V = j;
        // 		}

        // 		if (sum > k)
        // 			break;
        // 	}
        // }

        // if (U == -1)
        // 	return null;

        // return Pair.of(X[U], Y[V]);
    }
}
