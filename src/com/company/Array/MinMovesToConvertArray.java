package com.company.Array;

public class MinMovesToConvertArray {
    /*

    Find the minimum number of moves required for converting an array of zeroes to a given array of non-negative integers using only increment and double operations. The increment operation increases the value of an array element by 1 and the double operation doubles the value of each array element.

    Input: [8, 9, 8]
    Output: 7

    Explanation: The optimal sequence to convert an array [0, 0, 0] to [8, 9, 8] requires 3 increment operations, followed by 3 double operations, and a single increment operation:

    [0, 0, 0] —> [1, 0, 0] —> [1, 1, 0] —> [1, 1, 1] —> [2, 2, 2] —> [4, 4, 4] —> [8, 8, 8] —> [8, 9, 8]

    */
    public static int findMinMoves(int[] nums){
        int minMoves = 0;

        while (true){
            int noOfZeros = 0;

            for (int i = 0; i < nums.length; i++){
                if ((nums[i] & 1) != 0){
                    nums[i]--;
                    minMoves++;
                }

                if (nums[i] == 0)
                    noOfZeros++;
            }

            if (noOfZeros == nums.length)
                break;

            for (int j = 0; j < nums.length; j++)
                nums[j] >>= 1;

            minMoves++;
        }

        return minMoves;
    }
}
