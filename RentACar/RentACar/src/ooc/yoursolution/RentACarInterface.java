package ooc.yoursolution;

import ooc.enums.Make;
import ooc.enums.Month;
import java.util.List;

/**
 * This is one of the interfaces you need to implement
 */
public class RentACarInterface  {
    //ArrayList created to store  the list of  cars imported from Make.class
    private List<CarInterface> cars;
    private String name;

    public RentACarInterface(List<CarInterface> cars, String name) {
        this.cars = cars;
        this.name = name;
    }


    public List getCars() {
        return cars;
    }


    public void setCars(List cars) {
        this.cars = cars;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {// method that checks if the car is available considering user input
        int currentDay, flag;

        for (CarInterface car : cars) {
            if (car.getMake().equals(make)) {
                flag = 0;
                currentDay = day;
                for (int i=0; i<lengthOfRent; i++) {
                    if (!car.isAvailable(month, currentDay++)) {
                        flag = 1;
                        break;
                    }
                }

                if (flag == 0) {
                    return true;
                }
            }
        }

        return false;
    }


    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
        int currentDay, flag;

        for (CarInterface car : cars) {
            if (car.getMake().equals(make)) {
                flag = 0;
                currentDay = day;
                for (int i=0; i<lengthOfRent; i++) {
                    if (!car.isAvailable(month, currentDay++)) {
                        flag = 1;
                        break;
                    }
                }

                if (flag == 0) {
                    return car.getId();
                }
            }
        }

        return -1;
    }


    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {//rent a car method to check car availability using user input

        if (!checkAvailability(month, day, make, lengthOfRent)) {
            return false;
        }

        int carId = getCarAvailable(month, day, make, lengthOfRent);// gives an id number for car available considering user input

        for (CarInterface car : cars) {
            if (car.getId() == carId && car.getMake() == make) {
                int currentDay = day;
                for (int i=0; i<lengthOfRent; i++) {
                    car.book(month, currentDay++);
                }
            }
        }

        return true;
    }


    public int getNumberOfCars() {
        return cars.size();
    }
}