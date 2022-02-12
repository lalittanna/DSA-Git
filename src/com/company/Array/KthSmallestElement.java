package com.company.Array;

import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElement {
    /*

    Given an integer array, find k'th smallest element in the array where k is a positive integer less than or equal to the length of array.

    Input : [7, 4, 6, 3, 9, 1], k = 3
    Output: 4
    Explanation: The 3rd smallest array element is 4

    Input : [1, 5, 2, 2, 2, 5, 5, 4], k = 5
    Output: 4
    Explanation: The 5th smallest array element is 4

    */
    public static int findKthSmallest(List<Integer> nums, int k)
    {
        return quickSelect(nums, 0, nums.size() - 1, k - 1);

//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(nums);
//
//        while (k-- > 1)
//            minHeap.poll();
//
//        return minHeap.poll();
    }

    public static int quickSelect(List<Integer> nums, int low, int high, int k){
        int partition = partition(nums, low, high);

        if (partition == k)
            return nums.get(partition);
        else if (partition > k)
            return quickSelect(nums, low, partition - 1, k);
        else
            return quickSelect(nums, partition + 1, high, k);
    }

    public static int partition (List<Integer> nums, int low, int high){
        int pivot = nums.get(high), pivotloc = low;
        for (int i = low; i < high; i++) {
            // inserting elements of less value
            // to the left of the pivot location
            if (nums.get(i) < pivot) {
                swap(nums, i, pivotloc);
                pivotloc++;
            }
        }

        // swapping pivot to the final pivot location
        swap(nums, high, pivotloc);

        return pivotloc;
    }

    public static void swap(List<Integer> nums, int i, int j){
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
