package com.company;

public class TotalMovesForBishop {
//    Given the position of a Bishop (A, B) on an 8 * 8 chessboard.
//
//    Your task is to count the total number of squares that can be visited by the Bishop in one move.
//
//    The position of the Bishop is denoted using row and column number of the chessboard.
    int solve(int A, int B) {
        return (Math.min(A - 1, B - 1) + Math.min(8 - A, 8 - B) + Math.min(8 - A, B - 1) + Math.min(8 - B, A - 1));
    }
}
