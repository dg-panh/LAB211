/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import util.Validation;

/**
 *
 * @author PC
 */
public class FoodList extends ArrayList<Food> {

    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public void addFood() {
        String id, name, type, place, expiredDate, currentDate;
        double weight;
        int pos;
        do {
            id = Validation.getID("Input food's id(Fxxx): ", "The format of id is Fxxx (x stands for a digit)", "^[F|f]\\d{3}$");
            pos = searchFoodReturnPos(id);
            if (pos != -1) {
                System.out.println("The id already exists. Input another one!");
            }
        } while (pos != -1);
        currentDate = formatter.format(new Date());
        name = Validation.getString("Input food name: ", "Name mustn't empty or contains all whitespace characters. Please input food name again!", 1, 15).toUpperCase();
        weight = Validation.getADouble("Input food weight(kg): ", "Weight must be from 0.1kg to 50kg. Please input weight again!", 0.1, 50.0);
        type = Validation.getString("Input type of food: ", "Type mustn't empty or contains all whitespace characters. Please input type again!", 1, 10);
        place = Validation.getString("Input location of food: ", "Location mustn't empty or contains all whitespace characters. Please input location again!", 1, 15);
        expiredDate = Validation.getDateFormat("Input expiration date of food (d/m/y): ", "Date must be follow format dd/mm/yyyy. Please input date again!", "dd/MM/yyyy", currentDate, "1/10/2023");
        if (this.add(new Food(id, name, type, place, expiredDate, weight)) == true) {
            System.out.println("A food information is added successfully!");
        } else {
            System.out.println("A food information is added failed!");
        }
    }

    public void displayAll() {
        if (this.isEmpty()) {
            System.out.println("The food list is empty. Nothing to print");
            return;
        }
        Collections.sort(this);
//        Collections.sort(this, Collections.reverseOrder()); //descending
        
        System.out.println("------------------------------------");
        System.out.println("Here is the food list in the descending order of expired date");
        String header = String.format("|%4s|%-15s|%6s|%10s|%15s|%15s|", "ID", "NAME", "WEIGHT", "TYPE", "PLACE", "EXPIRATION DATE");
        System.out.println(header);
        this.forEach(food -> {
            food.output();
        });
    }

    public void searchFood() {
        if (this.isEmpty()) {
            System.out.println("The list of food is empty. Please add a new food!");
            return;
        }

        String keyword;
        int count = 0;

        keyword = Validation.getString("Input the keyword name of the food you want to find: ", "Keyword mustn't empty or contains all whitespace characters. Please input keyword again!", 1, 15).toUpperCase();
        System.out.println("------------------------------------");

        String header = String.format("|%4s|%-15s|%6s|%10s|%15s|%15s|", "ID", "NAME", "WEIGHT", "TYPE", "PLACE", "EXPIRATION DATE");
        System.out.println(header);
        for (Food f : this) {
            if (f.getName().contains(keyword)) {
                f.output();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("This food does not exist!");
        }
    }

    public int searchFoodReturnPos(String id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public Food searchFoodReturnObj(String keyword) {
        for (Food f : this) {
            if (f.getName().contains(keyword)) {
                return f;
            }
        }
        return null;
    }

    public void removeFood() {
        if (this.isEmpty()) {
            System.out.println("The list of food is empty. Please add a new food!");
            return;
        }

        String id, choice;
        int pos;
        id = Validation.getID("Input food's id(Fxxx): ", "The format of id is Fxxx (x stands for a digit)", "^[F|f]\\d{3}$");
        pos = searchFoodReturnPos(id);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("This food does not exist!");
        } else {
            String header = String.format("|%4s|%-15s|%6s|%10s|%15s|%15s|", "ID", "NAME", "WEIGHT", "TYPE", "PLACE", "EXPIRATION DATE");
            System.out.println(header);
            this.get(pos).output();
            choice = Validation.getTwoOption("\nAre you sure you want to delete this food? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                this.remove(pos);
                System.out.println("The selected food is removed successfully!");
            } else {
                System.out.println("The selected food is removed failed!");
            }
        }
    }

    public void writeFile(String filename) {
        try {
            FileDAO.writeBinaryFile(filename, this);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public FoodList readFile(String filename) {
        try {
            FoodList list = FileDAO.readBinaryFile(filename);
            return list;
        } catch (FileNotFoundException e) {
            this.writeFile(filename);
            return this;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
}
