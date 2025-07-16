import java.util.ArrayList;
import java.util.List;

public class City {
    String name;
    List<Trail> trails = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

    public City(String name, List<Trail> trail) {
        this.name = name;
        this.trails = trail;
    }

    @Override
    public String toString() {
        return "Город: " + name + "; " + "Пути в: " + trails;
    }

    public void addTrail(Trail trail){
        this.trails.add(trail);
    }

    public void addTrail(City city, int cost){
        Trail trail = new Trail(city,cost);
        this.trails.add(trail);
    }

    public City travelBy(int n){
        City city = this.trails.get(0).toCity;
        for (int i = 0; i < n-1; i++) {
            city = city.trails.get(0).toCity;
        }
        return city;
    }
}
