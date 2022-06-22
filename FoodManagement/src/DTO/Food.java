/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Food implements Comparable<Food>, Serializable {

    String id, name, type, place, expiredDate;
    double weight;
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public Food(String id, String name, String type, String place, String expiredDate, double weight) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void output() {
        System.out.printf("|%4s|%-15s|%6.1f|%10s|%15s|%15s|\n", id, name, weight, type, place, expiredDate);
    }

    @Override
    public int compareTo(Food o) {
        try {
            Date date1 = formatter.parse(this.expiredDate);
            Date date2 = formatter.parse(o.expiredDate);
            return date1.compareTo(date2);
        } catch (ParseException e) {
            System.out.println("Parse failed!");
            return 0;
        }
    }

}
