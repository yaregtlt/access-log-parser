package ru.courses.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PolyLine polyLine = (PolyLine) o;
        for (int i = 0; i<polyLinePoint.size(); i++) {
            if (polyLinePoint.get(i).equals(polyLine.polyLinePoint.get(i))) return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(polyLinePoint);
    }

    @Override
    public String toString() {
        return "Линия " + polyLinePoint.toString();
    }
}
