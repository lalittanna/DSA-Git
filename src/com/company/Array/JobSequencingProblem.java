package com.company.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Job
{
    public int taskId, deadline, profit;

    public Job(int taskId, int deadline, int profit)
    {
        this.taskId = taskId;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencingProblem {
    /*

Given a list of tasks with deadlines and total profit earned on completing a task, find the maximum profit earned by executing the tasks within the specified deadlines. Assume that each task takes one unit of time to complete, and a task can't execute beyond its deadline.

Input: (Task Id, Deadline, Profit)

[(1, 9, 15), (2, 2, 2), (3, 5, 18), (4, 7, 1), (5, 4, 25), (6, 2, 20), (7, 5, 8), (8, 7, 10), (9, 4, 12), (10, 3, 5)]

Output: {1, 3, 4, 5, 6, 7, 8, 9}
Explanation: The maximum profit that can be achieved is 109 by leaving tasks 2 and 10 out.

Constraints:

• Only a single task can be executed at a time.
• The maximum number of tasks are 100.
• The maximum deadline that can be associated with a job is 1000.

*/

    /* The Job class have
		1. Three member variables, taskId, deadline and profit.
		2. Factory method `Job.of(taskId, deadline, profit)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/

    public static Set<Integer> scheduleJobs(List<Job> jobs){
        int maxDeadline = 1000;

        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        int[] slot = new int[maxDeadline];
        Arrays.fill(slot, -1);

        for(Job job : jobs){
            for (int i = job.deadline - 1; i >= 0; i--){
                if (slot[i] == -1){
                    slot[i] = job.taskId;
                    break;
                }
            }
        }

        Set<Integer> set = Arrays.stream(slot).filter(val -> val != -1).boxed().collect(Collectors.toSet());

        return set;
    }
}
