package com.company.Array;

public class PreBSTSkewedOrNot {
    public static boolean isSkewedBST(int[] pre){
        int n = pre.length;

        if (n <= 2)
            return true;

        int min = Integer.min(pre[n - 1], pre[n - 2]);
        int max = Integer.max(pre[n - 1], pre[n - 2]);

        for (int i = n - 3; i >= 0; i--){
            if (pre[i] < min)
                min = pre[i];
            else if (pre[i] > max)
                max = pre[i];
            else
                return false;
        }

        return true;

//        for (int i = 0; i < pre.length - 1; i++){
//            if (pre[i + 1] > pre[i]){
//                for (int j = i + 2; j < pre.length; j++){
//                    if (pre[j] < pre[i])
//                        return false;
//                }
//            } else {
//                for (int j = i + 2; j < pre.length; j++){
//                    if (pre[j] > pre[i])
//                        return false;
//                }
//            }
//        }
//
//        return true;
    }
}
