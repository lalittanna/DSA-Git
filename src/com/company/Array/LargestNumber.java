package com.company.Array;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {
    /*

Find the largest number possible from a set of given numbers, where the numbers append to each other in any order to form the largest number. The solution should return the string representation of the largest number.

Input : [10, 68, 75, 7, 21, 12]
Output: 77568211210

*/
    public static String findLargestNumber(List<Integer> nums){
        Collections.sort(nums, (a, b) -> (String.valueOf(b) + a).compareTo(String.valueOf(a) + b));
        return nums.stream().map(Object::toString).collect(Collectors.joining(""));
    }
}
