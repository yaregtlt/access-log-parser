package ru.courses.geometry;

import java.util.Objects;

public class Line implements IMeasurable {
    Point start;
    Point end;

    public Line(int xStart, int yStart, int xEnd, int yEnd) {
        this.start = new Point(xStart,yStart);
        this.end = new Point(xEnd,yEnd);
    }

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }


    public double getLength() {
        int xLength = this.end.x - this.start.x;
        int yLength = this.end.y - this.start.y;
        return Math.sqrt((xLength*xLength)+(yLength*yLength));
    }

    @Override
    public String toString() {
            return "Линия от " + start + " до " + end;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(start, line.start) && Objects.equals(end, line.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Line(new Point(start.x, start.y), new Point(end.x, end.y));
    }

    public Line copy() {
        try {
            return (Line) clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Ошибка клонирования.", e);
        }
    }
}
