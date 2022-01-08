package com.company;

import java.util.Scanner;

public class testingScannerClass {
    public static void test(){
        Scanner scanner = new Scanner((System.in));
        System.out.println("Your age is " + scanner.nextInt());

        System.out.println("typed this string: " + scanner.next());

        // hasNext, hasNextInt, hasNextLine, findInLine all three will check on the first input entered here
        if (scanner.hasNext())
            System.out.println("has next");
        else
            System.out.println("Doesn't have next");

        if (scanner.hasNextInt())
            System.out.println("has next int");
        else
            System.out.println("Doesn't have next int");

        if (scanner.hasNextLine())
            System.out.println("has next line");
        else
            System.out.println("Doesn't have next line");

        if (scanner.hasNextLine()) {
            String test =  scanner.findInLine("Lalit");
            System.out.println(test);
        }

        System.out.print("Enter integer: ");
        while (!scanner.hasNextInt()){
            scanner.nextLine();
            System.out.println("Invalid integer");
        }
        int input = scanner.nextInt();
        System.out.println("Input entered: " + input);
    }
}
