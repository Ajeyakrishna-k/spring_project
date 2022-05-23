package com.spring_project.springboot.utils;

public class GenericUtils {
    public static String getDayOfWeekString(int day){
        return switch (day) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Mayday";
        };
    }
}
