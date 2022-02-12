package com.company.Array;

import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElement {

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
