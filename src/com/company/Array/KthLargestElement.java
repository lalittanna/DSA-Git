package com.company.Array;

import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElement {
    /*

    Given an integer array, find k'th largest element in the array where k is a positive integer less than or equal to the length of array.

    Input : [7, 4, 6, 3, 9, 1], k = 2
    Output: 7
    Explanation: The 2nd largest array element is 7

    Input : [1, 5, 2, 2, 2, 5, 5, 4], k = 4
    Output: 4
    Explanation: The 4th largest array element is 4

    */
    public static int findKthLargest(List<Integer> nums, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(nums);

        while (k-- > 1)
            maxHeap.poll();

        return maxHeap.peek();

        // PriorityQueue<Integer> minHeap = new PriorityQueue<>(nums.subList(0, k));

        // for (int i = k; i < nums.size(); i++){
        // 	if (nums.get(i) > minHeap.peek()){
        // 		minHeap.poll();
        // 		minHeap.add(nums.get(i));
        // 	}
        // }

        // return minHeap.peek();

        // Collections.sort(nums);
        // return nums.get(nums.size() - k);
    }
}
