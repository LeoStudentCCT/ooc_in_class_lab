/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ooc.enums.Make;
import ooc.enums.Month;
import java.util.Map;

/**
 * To implement this interface you must to create some private variables to be used only in our classes.
 */
public class CarInterface  {

    private int id; 
    private Make make; //Variable to import the car list
    private double rate; // Variable to define the price of the rent
    private Map<Month, Boolean[]> hmap; //Varible of the HashMap

    public CarInterface(int id, Make make, double rate) {
        this.id = id;
        this.make = make;
        this.rate = rate;
        createAvailability();
    }

//HashMap imported from the Month.class
    public Map createAvailability() {
        hmap = new HashMap<>();

        hmap.put(Month.JANUARY, new Boolean[31]);
        hmap.put(Month.FEBRUARY, new Boolean[28]);
        hmap.put(Month.MARCH, new Boolean[31]);
        hmap.put(Month.APRIL, new Boolean[30]);
        hmap.put(Month.MAY, new Boolean[31]);
        hmap.put(Month.JUNE, new Boolean[30]);
        hmap.put(Month.JULY, new Boolean[31]);
        hmap.put(Month.AUGUST, new Boolean[31]);
        hmap.put(Month.SEPTEMBER, new Boolean[30]);
        hmap.put(Month.OCTOBER, new Boolean[31]);
        hmap.put(Month.NOVEMBER, new Boolean[30]);
        hmap.put(Month.DECEMBER, new Boolean[31]);

        return hmap;
    }

//Getter and Setters
    public Make getMake() {
        return make;
    }


    public void setMake(Make make) {
        this.make = make;
    }


    public double getRate() {
        return rate;
    }


    public void setRate(double rate) {
        this.rate = rate;
    }


    public Map getAvailability() {
        return hmap;
    }


    public void setAvailability(Map availability) {
        this.hmap = hmap;
    }


    public int getId() {
        return id;
    }

//Variable to check if the day in the month is available, else it will return false, which means that is not available.
    public boolean isAvailable(Month month, int day) {
        Boolean[] availability = hmap.get(month);
        if (availability[day-1] == null) {
            availability[day-1] = true;
        }
        return availability[day-1];
    }

//Variable to make the booking in the day of the month. else it will return false, which means that is not available
    public boolean book(Month month, int day) {
        if (hmap.get(month)[day-1]) {
            hmap.get(month)[day-1] = false;
            return true;
        }

        return false;
    }
}