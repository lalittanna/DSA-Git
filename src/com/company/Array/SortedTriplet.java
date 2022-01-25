package com.company.Array;

/*

Given an integer array `nums`, efficiently find a sorted triplet such that `nums[i] < nums[j] < nums[k]` where `i < j < k`.

Input : [7, 3, 4, 2, 6]
Output: (3, 4, 6)

• If the input contains several sorted triplets, the solution can return any one of them.

Input : [5, 4, 3, 7, 6, 1, 9]
Output: (5, 7, 9) or (4, 7, 9) or (3, 7, 9) or (5, 6, 9) or (4, 6, 9) or (3, 6, 9)

• If no triplet exists, return null.

Input : [5, 4, 3]
Output: null

*/
class Tuple<X, Y, Z>
{
    public final X first;       // first field of a tuple
    public final Y second;      // second field of a tuple
    public final Z third;       // third field of a tuple

    // Constructs a new Tuple with specified values
    private Tuple(X first, Y second, Z third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    // Factory method for creating a Typed Tuple immutable instance
    public static <X, Y, Z> Tuple <X, Y, Z> of(X a, Y b, Z c)
    {
        // calls private constructor
        return new Tuple<>(a, b, c);
    }
}
public class SortedTriplet {
    /* Assume that the Tuple<X, Y, Z> class
		1. Has member variables first, second, and third
		2. Provides factory method `Tuple.of(X, Y, Z)` for creating its immutable instance
		3. Its `equals()` and `hashCode()` methods are overridden
	*/

    public static Tuple<Integer, Integer, Integer> findSortedTriplet(int[] nums)
    {
        if (nums.length < 3)
            return null;

        int minIndex = 0, lowIndex = 0, midIndex = -1;

        for (int i = 1; i < nums.length; i++){
            if (nums[i] <= nums[minIndex])
                minIndex = i;
            else if (midIndex == -1 || nums[i] <= nums[midIndex]){
                lowIndex = minIndex;
                midIndex = i;
            } else
                return Tuple.of(nums[lowIndex], nums[midIndex], nums[i]);
        }

        return null;
    }
}
