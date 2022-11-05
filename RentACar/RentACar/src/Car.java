import java.util.HashMap;
import java.util.Map;
import ooc.enums.*;
import ooc.yoursolution.CarInterface;


public class Car implements CarInterface {

    private int id;
    private Make make;
    private double rate;
    private Map<Month, Boolean[]> map;

    public Car(int id, Make make, double rate) {
        this.id = id;
        this.make = make;
        this.rate = rate;
        createAvailability();
    }

    @Override
    public Map createAvailability() {
        map = new HashMap<>();

        map.put(Month.JANUARY, new Boolean[31]);
        map.put(Month.FEBRUARY, new Boolean[28]);
        map.put(Month.MARCH, new Boolean[31]);
        map.put(Month.APRIL, new Boolean[30]);
        map.put(Month.MAY, new Boolean[31]);
        map.put(Month.JUNE, new Boolean[30]);
        map.put(Month.JULY, new Boolean[31]);
        map.put(Month.AUGUST, new Boolean[31]);
        map.put(Month.SEPTEMBER, new Boolean[30]);
        map.put(Month.OCTOBER, new Boolean[31]);
        map.put(Month.NOVEMBER, new Boolean[30]);
        map.put(Month.DECEMBER, new Boolean[31]);

        return map;
    }

    @Override
    public Make getMake() {
        return make;
    }

    @Override
    public void setMake(Make make) {
        this.make = make;
    }

    @Override
    public double getRate() {
        return rate;
    }

    @Override
    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public Map getAvailability() {
        return map;
    }

    @Override
    public void setAvailability(Map availability) {
        this.map = map;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isAvailable(Month month, int day) {
        Boolean[] availability = map.get(month);
        if (availability[day-1] == null) {
            availability[day-1] = true;
        }
        return availability[day-1];
    }

    @Override
    public boolean book(Month month, int day) {
        if (map.get(month)[day-1]) {
            map.get(month)[day-1] = false;
            return true;
        }

        return false;
    }
}