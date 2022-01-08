package com.company.Array;

/*

Given a monotonically increasing function f(x) on positive numbers, find the value of x when f(x) becomes positive for the first time. In other words, find a positive number x such that f(x-1), f(x-2), … are negative and f(x+1), f(x+2), … are positive.

A function is called monotonically increasing if f(x) <= f(y) is true for all x and y, where x <= y. For example,

Input: f(x) = 2x - 100
Output: 51
Explanation: f(x) becomes positive for the first time when x = 51.

Input: f(x) = 3x - 100
Output: 34
Explanation: f(x) becomes positive for the first time when x = 34.

*/
public class UnboundedSearchSorted {
    /*
		Return value x where Function.f(x) becomes positive for the first time.
	*/

    public class Function{
        public static int f(int x){
            return (x*x - 10*x - 20);
        }
    }

    public static int findValue()
    {
        if (Function.f(0) > 0)
            return 0;

        int i = 1;

        while (Function.f(i) <= 0)
            i *= 2;

        int low = i / 2;
        int high = i;

        while (low <= high){
            int mid = (low + high) / 2;

            if (Function.f(mid) > 0 && (mid == low || Function.f(mid - 1) <= 0))
                return mid;

            if (Function.f(mid) <= 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}
