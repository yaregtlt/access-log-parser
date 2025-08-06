package ru.сourses.math;

public class Fraction extends Number{
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator < 0)
            throw new IllegalArgumentException("Знаменатель должен быть положительным");
        this.denominator = denominator;
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction sum(Fraction drob){
        int commonDenominator = this.denominator * drob.denominator;
        int sumNumerator = (this.numerator * drob.denominator) + (drob.numerator * this.denominator);
        Fraction drobOut = new Fraction(sumNumerator,commonDenominator);
        return simplifier(drobOut);
    }
    public Fraction sum(int number){
        return sum(new Fraction(number,1));
    }
    public Fraction minus(Fraction drob){
        int commonDenominator = this.denominator * drob.denominator;
        int minusNumerator = (this.numerator * drob.denominator) - (drob.numerator * this.denominator);
        Fraction drobOut = new Fraction(minusNumerator,commonDenominator);
        return simplifier(drobOut);
    }
    public Fraction minus(int number){
        return minus(new Fraction(number,1));
    }
    public static int egcd(int a, int b) {
        if (a < 0 ) a = a * -1;
        if (b < 0 ) b = b * -1;
        if (b == 0)
            return a;
        else
            return egcd(b, a % b);
    }
    public Fraction simplifier(Fraction drob){
        //System.out.println("Simplifier numerator: " + drob.numerator + " Simplifier denominator: " + drob.denominator);
        int egcd = egcd(drob.numerator, drob.denominator);
        return new Fraction(drob.numerator/egcd, drob.denominator/egcd);
    }
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
    @Override
    public int intValue() {
        return numerator / denominator;
    }
    @Override
    public long longValue() {
        return numerator / denominator;
    }
    @Override
    public float floatValue() {
        return ((float)numerator) / denominator;
    }
    @Override
    public double doubleValue() {
        return ((double)numerator) / denominator;
    }
    @Override
    public short shortValue() {
        return (short)(numerator / denominator);
    }
    @Override
    public byte byteValue() {
        return (byte)(numerator / denominator);
    }
}