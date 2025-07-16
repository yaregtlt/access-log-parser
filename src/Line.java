public class Line {
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
}
