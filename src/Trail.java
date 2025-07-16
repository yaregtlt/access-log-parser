public class Trail {
    City toCity;
    int cost;
    //Trail trail;

    public Trail(City toCity, int cost) {
        this.toCity = toCity;
        this.cost = cost;
    }

//    public Trail(Trail trail) {
//        this.trail = trail;
//    }

    @Override
    public String toString() {
        return toCity.name +": " + cost;
    }
}
