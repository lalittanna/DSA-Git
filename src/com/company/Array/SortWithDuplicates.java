package com.company.Array;

class Pair{
    private int x;
    private int y;

    Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}

public class SortWithDuplicates {
    /*

Given an integer array with many duplicated elements, efficiently sort it in linear time.

Input : [4, 2, 40, 10, 10, 1, 4, 2, 1, 10, 40]
Output: [1, 1, 2, 2, 4, 4, 10, 10, 10, 40, 40]

Constraints:

• The input elements lie in the range [0, 1000].
• The relative order of equal elements doesn't matter.

*/

    public static void sort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int start, int end){
        if (end <= start)
            return;

        if (end - start == 1){
            if (nums[start] > nums[end])
                swap(nums, start, end);
            return;
        }

        Pair pivotPair = partition(nums, start, end);

        quickSort(nums, start, pivotPair.getX());
        quickSort(nums, pivotPair.getY(), end);
    }

    public static Pair partition(int[] nums, int start, int end){
        int mid = start;
        int pivot = nums[end];

        while (mid <= end){
            if (nums[mid] < pivot){
                swap(nums, mid, start);
                start++;
                mid++;
            } else if (nums[mid] > pivot){
                swap(nums, mid, end);
                end--;
            } else
                mid++;
        }

        return new Pair(start - 1, mid);
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
