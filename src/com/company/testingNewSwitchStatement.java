package com.company;

public class testingNewSwitchStatement {

    enum Season {Summer, Spring, Winter, Fall, Invalid}

    public static void test(){
        Season season = Season.Invalid;
        String findSeason;

        // Older way, no default necessary
        switch (season){
            case Fall:
                findSeason = "Fall";
                break;
            case Summer:
                findSeason = "Summer";
                break;
            case Spring:
                findSeason = "Spring";
                break;
            case Winter:
                findSeason = "Winter";
                break;
            default:
                findSeason = "Invalid";
        }
        System.out.println(findSeason);

        // Newer way, default compulsory with yield and a semicolon
        findSeason = switch (season){
            case Fall -> "It's very cold";
            case Summer, Spring -> "It's hot";
            case Winter -> "It's cold";
            default -> {
                System.out.println("Invalid season");
                yield "Invalid Weather";
            }
        };
        System.out.println(findSeason);
    }
}
