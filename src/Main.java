import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//-------------------Task 1-2--------------------------------
//        Point p1 = new Point(1,3);
//        Point p2 = new Point(5,8);
//        Line l1 = new Line(p1, p2);
//        Line l2 = new Line(10,11,15,19);
//        Line l3 = new Line(l1.end,l2.start);
//        System.out.println(l3);
//        l1 = new Line(1,3,l1.end.x+1,l1.end.y+1);
//        l2 = new Line(l2.start.x+1,l2.start.y+1,15,19);
//        l3 = new Line(l1.end,l2.start);
//        System.out.println(l3);
//        System.out.println(l1.getLength(l1)+l2.getLength(l2)+l3.getLength(l3));
//-------------------Task 3--------------------------------
//        List<Point> point = new ArrayList<>();
//        point.add(new Point(1,5));
//        point.add(new Point(2,8));
//        point.add(new Point(5,3));
//        point.add(new Point(8,9));
//        PolyLine pl1 = new PolyLine(point);
//        System.out.print("Ломаная линия: ");
//        System.out.println(pl1);
//        System.out.print("Длина ломанной линии: ");
//        System.out.println(pl1.getLength());
//        System.out.print("Массив линий из ломаной линии: ");
//        System.out.println(pl1.getLines());
//        double length = 0;
//        for (int i = 0; i < pl1.getLines().size(); i++) {
//            Line line = pl1.getLines().get(i);
//            length+=line.getLength();
//        }
//        System.out.print("Длина линий из массива линий: ");
//        System.out.println(length);
//        System.out.print("Сравниваем длину ломаной линии и массива линий: ");
//        System.out.println(pl1.getLength()==length);
//        point.set(1,new Point(12,8));
//        pl1 = new PolyLine(point);
//        System.out.print("Изменили вторую точку ломаной линии: ");
//        System.out.println(pl1);
//        System.out.print("Длина новой ломанной линии: ");
//        System.out.println(pl1.getLength());
//        System.out.print("Новый массив линий из ломаной линии: ");
//        System.out.println(pl1.getLines());

//-------------------Task 4--------------------------------
        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");
        City f = new City("F");

        Trail toA1 = new Trail(a,5);
        Trail toA2 = new Trail(a,6);
        Trail toD1 = new Trail(d,6);
        Trail toD2 = new Trail(d,4);
        Trail toB1 = new Trail(b,5);
        Trail toE1 = new Trail(e,2);
        Trail toB2 = new Trail(b,1);
        a.addTrail(f,1);
        a.addTrail(toD1);
        a.addTrail(toB1);
        b.addTrail(c,3);
        b.addTrail(toA1);
        d.addTrail(toA2);
        d.addTrail(toE1);
        d.addTrail(c,4);
        c.addTrail(toD2);
        c.addTrail(b,3);
        e.addTrail(f,2);
        f.addTrail(e,2);
        f.addTrail(toB2);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println("-----------------------");
        System.out.println(b.travelBy(3));
       }
    }