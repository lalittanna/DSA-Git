package com.company.Array;

import java.util.Arrays;

public class MinimumPlatforms {
    /*

    Given a schedule containing the arrival and departure time of trains in a station, find the minimum number of platforms needed to avoid delay in any train’s arrival.

    Input:

    arrival = [2.00, 2.10, 3.00, 3.20, 3.50, 5.00]
    departure = [2.30, 3.40, 3.20, 4.30, 4.00, 5.20]

    Output: 2

    Explanation: The minimum platforms needed is 2

    The train arrived at 2.00 on platform 1
    The train arrived at 2.10 on platform 2
    The train departed at 2.30 from platform 1
    The train arrived at 3.00 on platform 1
    The train departed at 3.20 from platform 1
    The train arrived at 3.20 on platform 1
    The train departed at 3.40 from platform 2
    The train arrived at 3.50 on platform 2
    The train departed at 4.00 from platform 2
    The train departed at 4.30 from platform 1
    The train arrived at 5.00 on platform 1
    The train departed at 5.20 from platform 1

    */
    public static int findMinPlatforms(double[] arrival, double[] departure){
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int minimumPlatforms = 0;
        int platformOccupied = 0;

        int i = 0, j = 0;

        while (i < arrival.length){
            // if train is arriving before any departure
            if (arrival[i] < departure[j]){
                minimumPlatforms = Math.max(minimumPlatforms, ++platformOccupied);
                i++;
            }
            // if a train is departuring before any arrival, i.e. platform not occupied
            else{
                platformOccupied--;
                j++;
            }
        }

        return minimumPlatforms;
    }
}
