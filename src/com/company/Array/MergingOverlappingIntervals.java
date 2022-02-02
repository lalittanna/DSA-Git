package com.company.Array;

import java.util.*;

class Interval
{
    int begin, end;

    Interval(int begin, int end)
    {
        this.begin = begin;
        this.end = end;
    }

    public static Interval of(int x, int y){
        return new Interval(x, y);
    }

    @Override
    public String toString() {
        return "{" + begin + ", " + end + "}";
    }
}

public class MergingOverlappingIntervals {
    /*

Given a set of intervals, return all non-overlapping intervals after merging the overlapping intervals.

Input : [(1, 5), (2, 3), (4, 6), (7, 8), (8, 10), (12, 15)]
Output: {(1, 6), (7, 10), (12, 15)}

*/

    /* The Interval class have
		1. Two non-final public member variables, begin and end.
		2. Factory method `Interval.of(begin, end)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/
    public static Set<Interval> mergeIntervals(List<Interval> intervals){
        Set<Interval> set = new HashSet<>();

        if (intervals.size() < 1)
            return set;

        //Collections.sort(intervals, (a, b) -> a.begin - b.begin);
        Collections.sort(intervals, Comparator.comparingInt(a -> a.begin));

        Interval start = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++){
            if (intervals.get(i).begin <= start.end){
                if (intervals.get(i).end > start.end)
                    start = Interval.of(start.begin, intervals.get(i).end);
            } else {
                set.add(start);
                start = intervals.get(i);
            }
        }

        set.add(start);

        return set;
    }
}
