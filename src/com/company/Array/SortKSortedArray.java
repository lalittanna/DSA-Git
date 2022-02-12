package com.company.Array;

import java.util.List;
import java.util.PriorityQueue;

public class SortKSortedArray {
    /*

    Given an integer array whose elements may be misplaced by no more than `k` positions from the correct sorted order, efficiently sort it in linear time and constant space.

    Input: nums[] = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2
    Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    */
    public static void sortKSortedArray(List<Integer> nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(nums.subList(0, k + 1));

        int index = 0;
        for (int i = k + 1; i < nums.size(); i++){
            nums.set(index++, minHeap.poll());
            minHeap.add(nums.get(i));
        }

        while(!minHeap.isEmpty())
            nums.set(index++, minHeap.poll());

        // for (int i = 0; i < nums.size(); i++){
        // 	for (int j = Math.min(nums.size() - 1, i + k); j < nums.size() && j != i; j--){
        // 		if (nums.get(i) > nums.get(j)){
        // 			swap(nums, i, j);
        // 			break;
        // 		}
        // 	}
        // }
    }

    public static void swap(List<Integer> nums, int i, int j){
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
