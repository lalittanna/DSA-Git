package com.company.Array;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WeightedIntervalScheduling {
    class Job
    {
        int start, finish, profit;

        Job(int start, int finish, int profit)
        {
            this.start = start;
            this.finish = finish;
            this.profit = profit;
        }
    }

/*

Given a list of jobs where each job has a start and finish time, and a profit associated with it, find a maximum profit subset of non-overlapping jobs.

Input: jobs = [(0, 6, 60), (5, 9, 50), (1, 4, 30), (5, 7, 30), (3, 5, 10), (7, 8, 10)]		// (starting time, finishing time, associated profit)
Output: 80
Explanation: The jobs involved in the maximum profit are: (1, 4, 30) and (5, 9, 50).

*/

    /* The Job class have
		1. Three public member variables, start, finish, and profit.
		2. Factory method `Job.of(start, finish, profit)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/

    public static int findMaxProfit(List<Job> jobs){
        Collections.sort(jobs, Comparator.comparingInt(x -> x.finish));

        int n = jobs.size();

        if (n == 0)
            return 0;

        int[] maxProfit = new int[n];

        maxProfit[0] = jobs.get(0).profit;

        for (int i = 1; i < n; i++){
            // int index = -1;
            // for (int j = i - 1; j >= 0; j--){
            // 	if (jobs.get(j).finish <= jobs.get(i).start){
            // 		index = j;
            // 		break;
            // 	}
            // }

            int index = findLastNonConflicting(jobs, i);

            int include = jobs.get(i).profit;
            if (index != -1)
                include += maxProfit[index];

            maxProfit[i] = Math.max(include, maxProfit[i - 1]);
        }

        return maxProfit[n - 1];

        //return profit(jobs, 0, 0, 0);
    }

    public static int findLastNonConflicting(List<Job> jobs, int n){
        int low = 0, high = n - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if (jobs.get(mid).finish <= jobs.get(n).start){
                if (jobs.get(mid + 1).finish <= jobs.get(n).start)
                    low = mid + 1;
                else
                    return mid;
            } else
                high = mid - 1;
        }

        return -1;
    }

    public static int profit(List<Job> jobs, int profit, int i, int finish){
        if (i == jobs.size())
            return profit;

        if (finish <= jobs.get(i).start)
            return Integer.max(profit(jobs, profit, i + 1, finish), profit(jobs, profit + jobs.get(i).profit, i + 1, jobs.get(i).finish));
        else
            return profit(jobs, profit, i + 1, finish);
    }
}
