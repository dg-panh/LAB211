/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.FoodList;
import util.Validation;

/**
 *
 * @author PC
 */
public class FoodManager {
    public static void main(String[] args) {
        Menu menu = new Menu("Food Management - @2021 by <SE151396 - Dang Phuong Anh>");
        menu.addNewOption("1. Add a new food");
        menu.addNewOption("2. Search a food by name");
        menu.addNewOption("3. Remove the food by ID");
        menu.addNewOption("4. Print the food list in the descending order of expired date");
        menu.addNewOption("5. Quit");
        
        
        FoodList list = new FoodList();
        int choice;
        
        menu.printMenu();
        System.out.println("Before using this application, please enter the file name in which you want to save the data about the food in the refrigerator");
        String filename = Validation.getString("Enter filename: ", "File name mustn't empty or contains all whitespace characters. Please input file name again!", 1, 15);
        filename = filename + ".dat";

        list = (FoodList) list.readFile(filename);

        do {
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new food");
                    addFood(list);
                    break;
                case 2:
                    System.out.println("You are required to search a food by name");
                    searchFood(list);
                    break;
                case 3:
                    System.out.println("You are required to remove the food by ID");
                    list.removeFood();
                    break;
                case 4: 
                    System.out.println("You are required to print the food list in the descending order of expired date");
                    list.displayAll();
                    break;
                case 5:
                    list.writeFile(filename);
                    break;
            }
            if (choice != 5) menu.printMenu();
        } while (choice != 5);
    }
    
    public static void addFood(FoodList list) {
        String choice;
        do {
            list.addFood();
            choice = Validation.getTwoOption("Do you want to continue adding another food? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
        } while (choice.equalsIgnoreCase("y"));
    }
    
    public static void searchFood(FoodList list) {
        String choice;
        do {
            list.searchFood();
            choice = Validation.getTwoOption("Do you want to continue searching for another food? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
        } while (choice.equalsIgnoreCase("y"));
    }
}
