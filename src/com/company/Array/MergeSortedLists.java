package com.company.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedLists {
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

Given `M` sorted lists of variable length, merge them efficiently in sorted order.

Input:

mat = [
	[10, 20, 30, 40],
	[15, 25, 35],
	[27, 29, 37, 48, 93],
	[32, 33]
]

Output: [10, 15, 20, 25, 27, 29, 30, 32, 33, 35, 37, 40, 48, 93]

*/
    public static List<Integer> mergeSortedLists(List<List<Integer>> lists){
        List<Integer> mergeLists = new ArrayList<>();

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.size(); i++){
            if (lists.get(i).size() >= 1)
                pq.add(new Node(lists.get(i).get(0), i, 0));
        }

        while (!pq.isEmpty()){
            Node min = pq.poll();

            mergeLists.add(min.getValue());

            if (min.getIndex() + 1 < lists.get(min.getListNum()).size()){
                min.setIndex(min.getIndex() + 1);
                min.setValue(lists.get(min.getListNum()).get(min.getIndex()));
                pq.add(min);
            }
        }

        return mergeLists;
    }
}
