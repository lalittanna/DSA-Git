package com.company.Array;

/*

Given a binary array and a positive integer `k`, return the indices of the maximum sequence of continuous 1’s that can be formed by replacing at most `k` zeroes by ones.

• The solution should return a pair of the starting and the ending index of the maximum sequence.
• For invalid inputs, the solution should return null.
• In case multiple sequence of continuous 1’s of maximum length exists, the solution can return any one of them.

Input : nums[] = [1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0], k = 0
Output: (6, 9)
Explanation: The longest sequence of continuous 1’s is formed by index 6 to 9.

Input : nums[] = [1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0], k = 1
Output: (3, 9)
Explanation: The longest sequence of continuous 1’s is formed by index 3 to 9 on replacing zero at index 5.

Input : nums[] = [1, 1, 1, 1, 1], k = 1
Output: (0, 4)

Input : nums[] = [1, 0, 1, 1, 0, 0, 1, 1, 0, 1], k = 1
Output: (0, 3) or (6, 9)

Input : nums[] = [], k = 1
Output: null

*/

public class MaximumBinaryContinuousSequence {
    private class  Pair<E, V> {
        public static int[] of(int U, int V){
            int[] array = {U, V};
            return array;
        }
    }
    public static int[] findLongestSequence(int[] nums, int k)
    {
        int window = 0;
        int leftIndex = 0;

        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++){
            if (nums[right] == 0)
                count++;

            while (count > k){
                if (nums[left] == 0)
                    count--;

                left++;
            }

            if (window < right - left + 1){
                window = right - left + 1;
                leftIndex =  left;
            }
        }

        if (window == 0)
            return null;

        return Pair.of(leftIndex, leftIndex + window - 1);

        // if (nums.length == 0)
        // 	return null;

        // int maxLength = 0;
        // int endingIndex = -1;

        // int maxLengthSoFar = 0;

        // Queue<Integer> queue = new LinkedList<Integer>();

        // int tempK = k;

        // for (int i = 0; i < nums.length; i++){
        // 	if (nums[i] == 1)
        // 		maxLengthSoFar++;
        // 	else if (tempK > 0){
        // 		tempK--;
        // 		maxLengthSoFar++;
        // 		queue.add(i);
        // 	} else {
        // 		if (queue.size() > 1){
        // 			queue.poll();
        // 			queue.add(i);
        // 			maxLengthSoFar = i - queue.poll();
        // 		} else if (queue.size() == 1){
        // 			maxLengthSoFar = i - queue.poll();
        // 			queue.add(i);
        // 		} else {
        // 			maxLengthSoFar = 0;
        // 		}
        // 	}

        // 	if (maxLength < maxLengthSoFar){
        // 			maxLength = maxLengthSoFar;
        // 			endingIndex = i;
        // 	}
        // }

        // if (endingIndex == -1)
        // 	return null;

        // int U = endingIndex - maxLength + 1;
        // int V = endingIndex;

        // return Pair.of(U, V);
    }
}
