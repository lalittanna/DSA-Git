package com.company.Array;

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
