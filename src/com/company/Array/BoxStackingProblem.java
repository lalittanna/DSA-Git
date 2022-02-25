package com.company.Array;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Box {
    // constraint: width is never more than length
    int length, width, height;

    private Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public static Box of(int a, int b, int c) {
        return new Box(a, b, c);
    }
}

public class BoxStackingProblem {
/*

Given a set of rectangular 3D boxes (cuboids), create a stack of boxes as tall as possible and return the maximum height of the stacked boxes.

• A box can be placed on top of another box only if the dimensions of the 2D base of the lower box is each "strictly" larger than of the 2D base of the higher box. i.e., box i can be placed on top of box j if and only if length[i] < length[j] and width[i] < width[j].

• The solution can include "multiple" instances of the same box, such that a box can be rotated to use any of its sides as the base, and does not have to include the every box to achieve the maximum height.

For example,

Input: [(4, 2, 5), (3, 1, 6), (3, 2, 1), (6, 3, 8)]
Output: 22
Explanation: Each of the given box has dimensions L × W × H:

(4 × 2 × 5)
(3 × 1 × 6)
(3 × 2 × 1)
(6 × 3 × 8)

The valid rotations (length more than the width) of the boxes are:

(4 × 2 × 5), (5 × 4 × 2), (5 × 2 × 4)
(3 × 1 × 6), (6 × 3 × 1), (6 × 1 × 3)
(3 × 2 × 1), (3 × 1 × 2), (2 × 1 × 3)
(6 × 3 × 8), (8 × 6 × 3), (8 × 3 × 6)

The maximum height possible is 22, which can be obtained by arranging the boxes in the following order:

(3 × 1 × 6)
(4 × 2 × 5)
(6 × 3 × 8)
(8 × 6 × 3)

Note that (3 × 2 × 1) box is not included to achieve the maximum height.

*/

    /* The Box class have
		1. Three public member variables, length, width, and height.
		2. Factory method `Box.of(length, width, height)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/

    public static int findMaxHeight(List<Box> boxes){
        if (boxes.size() == 0) return 0;

        List<Box> rotations = createAllRotations(boxes);

        rotations.sort((x, y) -> y.length * y.width - x.length * x.width);

        int[] maxHeight = new int[rotations.size()];

        for (int i = 0; i < rotations.size(); i++){
            for (int j = 0; j < i; j++)
                if (rotations.get(i).length < rotations.get(j).length && rotations.get(i).width < rotations.get(j).width)
                    maxHeight[i] = Math.max(maxHeight[i], maxHeight[j]);

            maxHeight[i] += rotations.get(i).height;
        }

        return Arrays.stream(maxHeight).max().getAsInt();
    }

    public static List<Box> createAllRotations(List<Box> boxes){
        List<Box> rotations = new ArrayList<>();

        for (Box box : boxes){
            rotations.add(box);

            rotations.add(Box.of(Math.max(box.length, box.height), Math.min(box.length, box.height), box.width));
            rotations.add(Box.of(Math.max(box.width, box.height), Math.min(box.width, box.height), box.length));
        }

        return rotations;
    }
}
