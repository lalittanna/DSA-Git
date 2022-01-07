package com.company.Queues;

import java.util.List;
import java.util.PriorityQueue;

public class FindMinCost {
    /*
Given n ropes of different lengths, connect them into a single rope with minimum cost. Assume that the cost to connect two ropes is the same as the sum of their lengths.

Input: [5, 4, 2, 8]
Output: 36
Explanation: The total cost for connecting all ropes is 6 + 11 + 19 = 36.

[5, 4, 2, 8] –> First, connect ropes of lengths 4 and 2 that will cost 6.
[5, 6, 8]    –> Next, connect ropes of lengths 5 and 6 that will cost 11.
[11, 8]      –> Finally, connect the remaining two ropes that will cost 19.

*/
    public static int findMinCost(List<Integer> prices)
    {
        // This will be a min heap for the list
        PriorityQueue<Integer> queue = new PriorityQueue<>(prices);

        int cost = 0;

        while (queue.size() > 1){
            // getting the two smallest values each time
            int min1 = queue.poll();
            int min2 = queue.poll();

            int sum = min1 + min2;

            queue.add(sum);

            cost += sum;
        }

        return cost;
    }
}
