package ru.сourses.geometry;

import java.util.ArrayList;
import java.util.List;

public class PolyLine implements IMeasurable {
    List<Point> polyLinePoint;

    public PolyLine(List<Point> point) {
        this.polyLinePoint = point;
    }

    public List<Line> getLines() {
        List<Line> lines = new ArrayList<>();
        Point prevPoint = null;
        for (Point currPoint : polyLinePoint) {
            if (prevPoint != null) {
                Line line = new Line(prevPoint, currPoint);
                lines.add(line);
            }
            prevPoint = currPoint;
        }
        return lines;
    }

    public double getLength() {
        double length = 0;
        List<Point> points = polyLinePoint; // Пусть polyLine — список точек
        Point previousPoint = null;
        for (Point current : points) {   // Используем foreach
            if (previousPoint != null) {
                Line line = new Line(previousPoint, current);
                length += line.getLength();
            }
            previousPoint = current;
        }
        return length;
    }

    @Override
    public String toString() {
        return "Линия " + polyLinePoint.toString();
    }
}
