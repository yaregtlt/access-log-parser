import java.util.ArrayList;
import java.util.List;

public class PolyLine {
    List<Point> polyLine = new ArrayList<>();

    public PolyLine() {
    }

    public PolyLine(List<Point> line) {
        this.polyLine = line;
    }

    public List<Line> getLines(){
        List<Line> lines = new ArrayList<>();
        Point point;
        for (int i = 0;i<this.polyLine.size()-1;i++){
            Line line = new Line(polyLine.get(i),polyLine.get(i+1));
            lines.add(i,line);
        }
        return lines;
    }

    public double getLength() {
        double length = 0;
        for (int i = 0; i < this.polyLine.size()-1; i++) {
            Line line = new Line(polyLine.get(i),polyLine.get(i+1));
            length+=line.getLength();
        }
        return length;
    }

    @Override
    public String toString() {
        return "Линия " + polyLine.toString();
    }
}
