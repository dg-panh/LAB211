/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.InjectionList;
import util.Validation;

/**
 *
 * @author PC
 */
public class VaccineManager {
    public static void main(String[] args) {
        Menu menu = new Menu("Vaccine Management - @2021 by <SE151396 - Dang Phuong Anh>");
        menu.addNewOption("1. Build your data structure");
        menu.addNewOption("2. Show information all students have been injected");
        menu.addNewOption("3. Add student's vaccine injection information");
        menu.addNewOption("4. Updating information of students' vaccine injection");
        menu.addNewOption("5. Delete student vaccine injection information");
        menu.addNewOption("6. Search for injection information by studentID");
        menu.addNewOption("7. Others- Quit");
        
        InjectionList list = new InjectionList();
        int choice;
        
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You have requested to build your data structure");
                    
                    break;
                case 2:
                    System.out.println("You have requested to show information all students have been injected");
                    list.displayAll();
                    break;
                case 3:
                    System.out.println("You have requested to add student's vaccine injection information");
                    addInjection(list);
                    break;
                case 4:
                    System.out.println("You have requested to updating information of students' vaccine injection");
                    list.updateInjection();
                    break;
                case 5:
                    System.out.println("You have requested to delete student vaccine injection information");
                    list.removeInjection();
                    break;
                case 6:
                    System.out.println("You have requested to search for injection information by studentID");
                    searchInjection(list);
                    break;
                case 7:
                    System.out.println("Bye bye, see you next time!");
                    break;
            }
        } while (choice != 7);
    }
    
    public static void addInjection(InjectionList list) {
        String choice;
        do {
            list.addInjection();
            choice = Validation.getTwoOption("Do you want to continue adding another student's vaccine injection information? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
        } while (choice.equalsIgnoreCase("y"));
    }
    
    public static void searchInjection(InjectionList list) {
        String choice;
        do {
            list.searchInjection();
            choice = Validation.getTwoOption("Do you want to continue searching for another student's vaccine injection information? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
        } while (choice.equalsIgnoreCase("y"));
    }
}
