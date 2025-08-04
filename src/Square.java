public class Square {
    Point point;
    int sideLength;

    public Square(Point point, int sideLength) {
        this.point = point;
        if (sideLength <= 0) throw new IllegalArgumentException("Side length have to be positive");
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + point + " со стороной " + sideLength;
    }
}