package ru.courses.math;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class PowerCalculation {

    public static double calculatePower(String baseStr, String exponentStr) {
        int base = parseInt(baseStr);
        int exponent = parseInt(exponentStr);

        return pow(base, exponent);
    }
}