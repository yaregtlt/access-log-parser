package ru.courses.geometry;
import java.util.List;

public class ClosedPolyLine extends PolyLine{

    public ClosedPolyLine(List<Point> point) {
        super(point);
    }

    public double getLength() {
        double lastLineLength = new Line(super.polyLinePoint.get(super.polyLinePoint.size()-1),super.polyLinePoint.get(0)).getLength();
        return super.getLength() + lastLineLength;
    }

}
