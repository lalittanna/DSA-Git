package com.company.Array;



public class MinimumRange {

    /* The Pair<U, V> class have
		1. Two member variables, first and second.
		2. Factory method `Pair.of(U, V)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/

    class Pair<U, V>
    {
        private final U first;      // first field of a pair
        private final V second;     // second field of a pair

        // Constructs a new Pair with specified values
        private Pair(U first, V second)
        {
            this.first = first;
            this.second = second;
        }

        // Factory method for creating a Typed Pair immutable instance
        public static <U, V> Pair<U, V> of(U a, V b)
        {
            // calls private constructor
            //return new Pair<>(a, b);
            return null;
        }

        @Override
        public String toString() {
            return "[" + first + ", " + second + ']';
        }
    }

    public static Pair<Integer, Integer> findMinRange(int[] X, int[] Y, int[] Z){
        int minDiff = Integer.MAX_VALUE;
        Pair pair = null;

        int i = 0, j = 0, k = 0;

        while (i < X.length && j < Y.length && k < Z.length){
            int low = Math.min(Math.min(X[i], Y[j]), Z[k]);
            int high = Math.max(Math.max(X[i], Y[j]), Z[k]);

            if (high - low < minDiff){
                minDiff = high - low;
                pair = Pair.of(low, high);
            }

            if (low == X[i])
                i++;
            else if (low == Y[j])
                j++;
            else
                k++;
        }

        return pair;
    }
}
