package ru.courses.geometry;

import java.util.Objects;

public class Point implements Cloneable{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + x +";" + y +'}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    public Point copy() {
        try {
            return (Point) clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Ошибка клонирования.", e);
        }
    }
}