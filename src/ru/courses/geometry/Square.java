package ru.courses.geometry;

public class Square {
    private Point point;
    private int sideLength;

    public Square(Point point, int sideLength) {
        this.point = point;
        if (sideLength <= 0) throw new IllegalArgumentException("Side length have to be positive");
        this.sideLength = sideLength;
    }

    public Point getPoint() {
        return point;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + point + " со стороной " + sideLength;
    }
}