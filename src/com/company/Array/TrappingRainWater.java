package com.company.Array;

public class TrappingRainWater {
    /*

    Find the maximum amount of water that can be trapped within a given set of bars where each bar’s width is 1 unit.

    Input : [7, 0, 4, 2, 5, 0, 6, 4, 0, 5]
    Output: 25
    Explanation: The maximum amount of water that can be trapped is 25.

    Pictorial representation: https://techiedelight.com/practice/images/TrappingRainWater.png


    Input : [10, 8, 6, 5, 4, 2]
    Output: 0


    */
    public static int trapWater(int[] bars){
        if (bars.length < 2)
            return 0;

        int maxWater = 0;

        int left = 0, right = bars.length - 1;
        int maxLeft = bars[left];
        int maxRight = bars[right];

        while (left < right){
            if (bars[left] <= bars[right]){
                left++;
                maxLeft = Integer.max(maxLeft, bars[left]);
                maxWater += (maxLeft - bars[left]);
            } else {
                right--;
                maxRight = Integer.max(maxRight, bars[right]);
                maxWater += (maxRight - bars[right]);
            }
        }

        return maxWater;

        // if (bars.length < 2)
        // 	return 0;

        // int maxWater = 0;

        // int[] left = new int[bars.length];
        // left[0] = Integer.MIN_VALUE;
        // for (int i = 1; i < bars.length; i++)
        // 	left[i] = Integer.max(left[i - 1], bars[i - 1]);


        // int right = Integer.MIN_VALUE;
        // for (int i = bars.length - 2; i >= 0; i--){
        // 	right = Integer.max(right, bars[i + 1]);

        // 	if (Integer.min(right, left[i]) > bars[i])
        // 		maxWater += Integer.min(right, left[i]) - bars[i];
        // }

        // return maxWater;
    }
}
