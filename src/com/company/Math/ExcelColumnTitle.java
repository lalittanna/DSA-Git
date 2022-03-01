package com.company.Math;

public class ExcelColumnTitle {
    //Given a positive integer A, return its corresponding column title as appear in an Excel sheet.
    public String convertToTitle(int A) {
        StringBuilder s = new StringBuilder("");

        while (A != 0){
            A = A - 1;

            char ch = (char)(A % 26 + 65);

            s.insert(0, ch);
            A /= 26;
        }

        return s.toString();
    }
}
