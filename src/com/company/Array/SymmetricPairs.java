package com.company.Array;

import java.util.HashSet;
import java.util.Set;

/*

Given a set of pairs of integers, find all symmetric pairs, i.e., pairs that mirror each other. For instance, pairs `(x, y)` and `(y, x)` are mirrors of each other.

Input : {(1, 2), (5, 2), (3, 4), (7, 10), (4, 3), (2, 5)}
Output: {{(2, 5), (5, 2)}, {(3, 4), (4, 3)}}
Explanation: The pairs (2, 5) and (5, 2) mirror each other. Similarly, pairs (3, 4) and (4, 3) are symmetric.

Input : {(1, 2), (5, 2), (3, 4)}
Output: {}
Explanation: No pairs mirror each other

*/
public class SymmetricPairs {
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
    public static Set<Set<Pair>> findSymmetricPairs(Set<Pair> pairs) {
        Set<Set<Pair>> result = new HashSet<>();

        for (Pair pair : pairs){
            if (pairs.contains(Pair.of(pair.second, pair.first))){
                Set<Pair> set = new HashSet<>();
                set.add(pair);
                set.add(Pair.of(pair.second, pair.first));
                result.add(set);
                pairs.remove(pair);
            }
        }

        return result;
    }
}
