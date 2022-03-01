package com.company.Math;

public class ExcelColumnNumber {
    //Given a column title A as appears in an Excel sheet, return its corresponding column number.
    public static int titleToNumber(String A) {
        int res = 0;

        for (int i = A.length() - 1, j = 0; i >= 0; i--)
            res += (int) Math.pow(26, j++) * (A.charAt(i) - 'A' + 1);

        return res;
    }
}
