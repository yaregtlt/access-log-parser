package ru.courses.main;

import ru.courses.food.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sauce s1 = new Sauce("Кетчуп",Spiciness.NOT_SPICY);
        System.out.println(s1);
//        Line l1 = new Line(4,5,8,8);
//        Line l2 = l1.copy();
//        System.out.println(l1.equals(l2));
//        System.out.println(l2.equals(l1));
//        Point p1 = new Point(4,5);
//        Point p2 = p1.copy();
//        System.out.println(p1.equals(p2));
//        System.out.println(p2.equals(p1));
//        Fraction f1 = new Fraction(3,9);
//        Fraction f2 = f1.copy();
//        System.out.println(f1.equals(f2));
//        Point p1 = new Point(1,5);
//        ru.courses.geometry.Point p2 = new ru.courses.geometry.Point(4,8);
//        System.out.println(p1);
//        System.out.println(p2);
//        Fraction f1 = new Fraction(1,3);
//        System.out.println(f1);
//        Fraction f2 = new Fraction(2,5);
//        System.out.println(f2);
//        Fraction f3 = new Fraction(7,8);
//        System.out.println(f3);
//        System.out.println(f1.sum(f2).sum(f3).minus(5));
//        Student s1 = new Student("Kolya");
//        s1.addGrade(2);
//        s1.addGrade(5);
//        s1.addGrade(3);
//        s1.addGrade(4);
//        System.out.println(s1);
//        System.out.println(s1.getGrades());
//        Point3D p1 = new Point3D(5,8,3);
//        System.out.println(p1);

//        Line line = new Line(8,9,1,5);
//
//        List<Point> polyLineList = new ArrayList<>();
//        polyLineList.add(new Point(1,5));
//        polyLineList.add(new Point(2,8));
//        polyLineList.add(new Point(5,3));
//        polyLineList.add(new Point(8,9));
//
//        PolyLine polyLine = new PolyLine(polyLineList);
//        ClosedPolyLine closedPolyLine = new ClosedPolyLine(polyLineList);
//
//        System.out.println(polyLine.getLength());
//        System.out.println(closedPolyLine.getLength());
//        System.out.println(line.getLength());
//        List<IMeasurable> measurables = new ArrayList<>();
//        measurables.add(line);
//        measurables.add(polyLine);
//        measurables.add(closedPolyLine);
//        System.out.println(countLength(measurables));
//        System.out.println(sumAll(2,new Fraction(3,5), 2.3));

    }

//    public static double sumAll(Fraction... fractions){
//        double totalSum = 0;
//        Fraction f = null;
//        for (Fraction a : fractions) {
//            f=a;
//            f=f.sum(a);
//        }
//        return f.doubleValue();
//    }

//    public static double sumAll(Number... numbers) {
//        double sum = 0;
//        for (Number number : numbers) {
//            sum += number.doubleValue();
//        }
//        return sum;
//    }

//    public static double countLength(List<IMeasurable> measurables) {
//        double totalLength = 0;
//        for (IMeasurable m : measurables) {
//            totalLength += m.getLength();
//        }
//        return totalLength;
//    }

}