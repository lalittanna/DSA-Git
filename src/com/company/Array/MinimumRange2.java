package com.company.Array;

import java.util.List;
import java.util.PriorityQueue;

public class MinimumRange2 {
    static class Node implements Comparable{
        private int value;
        private int i;
        private int index;

        public Node (int value, int i, int index){
            this.value = value;
            this.i = i;
            this.index = index;
        }

        public int getValue(){
            return value;
        }

        public int getListNum(){
            return i;
        }

        public int getIndex(){
            return index;
        }

        public void setValue(int value){
            this.value = value;
        }

        public void setIndex(int index){
            this.index = index;
        }

        @Override
        public int compareTo(Object o){
            Node node = (Node) o;
            return value - node.value;
        }
    }

    /*
Given M sorted lists of variable length, efficiently compute the smallest range, including at least one element from each list.

Input:

mat = [
	[3, 6, 8, 10, 15],
	[1, 5, 12],
	[4, 8, 15, 16],
	[2, 6],
]

Output: (4, 6)

Input:

mat = [
	[2, 3, 4, 8, 10, 15],
	[1, 5, 12],
	[7, 8, 15, 16],
	[3, 6],
]

Output: (4, 7)


If minimum range doesn't exist, the solution should return null.

Input : [[], [], []]
Output: null

*/

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

    public static Pair<Integer, Integer> findMinimumRange(List<List<Integer>> lists){
        if (lists == null || lists.size() == 0)
            return null;

        int high = Integer.MIN_VALUE;

        Pair p = Pair.of(0, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) == null || lists.get(i).size() == 0)
                return null;

            pq.add(new Node(lists.get(i).get(0), i, 0));
            high = Integer.max(high, lists.get(i).get(0));
        }

        while (true){
            Node top = pq.poll();

            int low = top.getValue();
            int i = top.getListNum();
            int j = top.getIndex();

            if (high - low < (int)p.second - (int)p.first)
                p = Pair.of(low, high);

            if (j == lists.get(i).size() - 1)
                return p;

            pq.add(new Node(lists.get(i).get(j + 1), i, j + 1));
            high = Integer.max(high, lists.get(i).get(j + 1));
        }
    }
}
