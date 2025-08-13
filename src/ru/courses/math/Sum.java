package ru.courses.math;

import java.util.regex.Pattern;

public class Sum {
    public static void main(String[] args) {

        double sum = 0;

        for (String arg : args) {
            boolean isNumber = Pattern.matches("^[0-9]+$", arg);
            System.out.println(arg + isNumber);
            if (isNumber) {
                double number = Double.parseDouble(arg);
                sum += number;
            }
        }
        System.out.println("Сумма равна: " + sum);
    }
}
