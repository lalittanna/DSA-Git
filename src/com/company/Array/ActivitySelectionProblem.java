package com.company.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Activity {
    public final int start;     // start field of a job
    public final int finish;    // finish field of a job

    // Constructs a new Job with specified values
    private Activity(int start, int finish)
    {
        this.start = start;
        this.finish = finish;
    }

    // Factory method for creating a Job immutable instance
    public Activity of(int a, int b)
    {
        // calls private constructor
        return new Activity(a, b);
    }
}
public class ActivitySelectionProblem {

    /* The Activity class have
		1. Two member variables, start and finish.
		2. Factory method `Activity.of(start, finish)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/

    public static List<Activity> selectActivity(List<Activity> activities) {
        Collections.sort(activities, Comparator.comparingInt(x -> x.start));

        List<List<Activity>> L = new ArrayList<>();
        for (var activity: activities)
            L.add(new ArrayList<>());

        for (int i = 0; i < activities.size(); i++){
            for (int j = 0; j < i; j++){
                if (activities.get(j).finish < activities.get(i).start &&
                        L.get(i).size() < L.get(j).size())
                    L.set(i, new ArrayList<>(L.get(j)));
            }

            L.get(i).add(activities.get(i));
        }

        List<Activity> max = L.stream().max(Comparator.comparingInt(x -> x.size())).get();
        return max;
    }
}
