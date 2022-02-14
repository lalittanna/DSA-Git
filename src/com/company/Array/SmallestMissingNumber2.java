package com.company.Array;

public class SmallestMissingNumber2 {
    /*

    Given an unsorted integer array, find the smallest missing positive integer in it.

    Input: [1, 4, 2, -1, 6, 5]
    Output: 3

    Input: [1, 2, 3, 4]
    Output: 5

    */
    public static int findSmallestMissingNumber(int[] nums){
        int k = partition(nums);

        for (int i = 0; i < k; i++){
            int val = Math.abs(nums[i]);

            if (val - 1 < k && nums[val - 1] >= 0)
                nums[val - 1] = -nums[val - 1];
        }

        for (int i = 0; i < k; i++){
            if (nums[i] > 0)
                return i + 1;
        }

        return k + 1;

        // Set<Integer> distinct = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        // int index = 1;
        // while (true){
        // 	if (!distinct.contains(index))
        // 		return index;
        // 	index++;
        // }
    }

    public static int partition(int[] nums){
        int pIndex = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0)
                swap(nums, i, pIndex++);
        }

        return pIndex;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
