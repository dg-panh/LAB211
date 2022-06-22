/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import util.Validation;

/**
 *
 * @author PC
 */
public class InjectionList extends ArrayList<Injection>{

    final String filename = "Injection.txt";
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
    public InjectionList() {
        this.loadDataFromFile();
    }

    public void addInjection() {
        String injectionID, studentID, vaccineID, place1, date1;
        String place2 = "Not updated yet", date2 = "Not updated yet", choice = "";
        Student stu;
        Vaccine vac;
        int pos;
        do {
            injectionID = Validation.getID("Input injection id(IJxxxxxx): ", "The format of id is IJxxxxxx (x stands for a digit)", "^[I][J]\\d{6}$");
            pos = searchInjectionReturnPos(injectionID);
            if (pos != -1) {
                System.out.println("The id already exists. Input another one!");
            }
        } while (pos != -1);
        
        StudentList sList = new StudentList();
        do {
            studentID = Validation.getID("Input student id(SExxxxxx): ", "The format of id is SExxxxxx (x stands for a digit)", "^[S][E]\\d{6}$");
            stu = sList.searchStudentReturnObj(studentID);
            if (stu == null) {
                System.out.println("Student does not exist!");
                choice = Validation.getTwoOption("Do you want to contiue input another student's id? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            } else if (this.searchInjectionByStudent(studentID) != null) {
                System.out.println("This student has had vaccination information saved.");
                System.out.println("If you want more information about the second vaccination, please choose Updating information of students' vaccine injection.");
                choice = Validation.getTwoOption("Do you want to continue input another student's id? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            } else {
                break;
            }
        } while (choice.equalsIgnoreCase("y"));
        if(choice.equalsIgnoreCase("n")) return;
        
        VaccineList vList = new VaccineList();
        do {
            vaccineID = Validation.getID("Input vaccine id(Vxxx): Covid-", "The format of id is Vxxx (x stands for a digit)", "^[V]\\d{3}$");
            vaccineID = "Covid-" + vaccineID;
            vac = vList.searchVaccineReturnObj(vaccineID);
            if (vac == null) {
                System.out.println("Vaccine does not exist!");
                choice = Validation.getTwoOption("Do you want to continue input another vaccine id? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            }  else {
                break;
            }
        } while (choice.equalsIgnoreCase("y"));
        if(choice.equalsIgnoreCase("n")) return;
        
        String currentDate = formatter.format(new Date());
        place1 = Validation.getString("Input 1st injection place: ", "Place mustn't empty or contains all whitespace characters. Please input place again!", 1, 20);
        date1 = Validation.getDateFormat("Input 1st injection date (d/m/y): ", "Date must be follow format dd/mm/yyyy. Please input date again!", "dd/MM/yyyy", "1/5/2021", currentDate);
        if (this.add(new Injection(injectionID, stu, vac, place1, date1, place2, date2))) {
            this.saveDataToFile();
            System.out.println("A student's vaccine injection information is added successfully!");
        } else {
            System.out.println("A student's vaccine injection information is added failed!");
        }
    }
    
    public void updateInjection() {
        if (this.isEmpty()) {
            System.out.println("The list of student vaccination information is empty. Nothing to print");
            return;
        }
        
        String injectionID, place2, date2, choice = "";
        Injection inj;
        
        injectionID = Validation.getID("Input injection id(IJxxxxxx): ", "The format of id is IJxxxxxx (x stands for a digit)", "^[I][J]\\d{6}$");
        inj = searchInjectionReturnObj(injectionID);
        System.out.println("------------------------------------");
        if (inj == null) {
            System.out.println("Injection does not exist!");
            return;
        }
        
        System.out.println("Here is the student's vaccine injection information before updating");
        String header = String.format("|%-12s|%-10s|%-10s|%20s|%20s|%20s|%20s|", "INJECTION ID", "STUDENT ID", "VACCINE ID", "1st INJECTION PLACE", "1st INJECTION DATE", "2nd INJECTION PLACE", "2nd INJECTION DATE");
        System.out.println(header);
        inj.output();
        
        String currentDate = formatter.format(new Date());
        if (inj.getDate2().equalsIgnoreCase("Not updated yet")) {
            place2 = Validation.getString("Input 2nd injection place: ", "Place mustn't empty or contains all whitespace characters. Please input place again!", 1, 20);
            do {
                choice = "";
                date2 = Validation.getDateFormat("Input 2nd injection date (d/m/y): ", "Date must be follow format dd/mm/yyyy. Please input date again!", "dd/MM/yyyy", inj.date1, currentDate);
                if (inj.checkDate(date2)) {
                    inj.setPlace2(place2);
                    inj.setDate2(date2);
                    this.saveDataToFile();
                    System.out.println("------------------------------------");
                    System.out.println("Here is the student's vaccine injection information after updating");
                    System.out.println(header);
                    inj.output();
                    System.out.println("Student has completed 2 injections!");
                } else {
                    System.out.println("The second dose of vaccine must be given 4 to 12 weeks after the first injection. Please check the date carefully!");
                    choice = Validation.getTwoOption("Do you want to continue input another 2nd injection date? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                }
            } while (choice.equalsIgnoreCase("y"));
        } else {
            System.out.println("Student has completed 2 injections!");
        }
    }
    
    public void displayAll() {
        if (this.isEmpty()) {
            System.out.println("The list of student vaccination information is empty. Nothing to print");
            return;
        }
        
        System.out.println("------------------------------------");
        System.out.println("Here is the information of all students who have been vaccinated");
        String header = String.format("|%-12s|%-10s|%-10s|%20s|%20s|%20s|%20s|", "INJECTION ID", "STUDENT ID", "VACCINE ID", "1st INJECTION PLACE", "1st INJECTION DATE", "2nd INJECTION PLACE", "2nd INJECTION DATE");
        System.out.println(header);
        this.forEach(inj -> {
            inj.output();
        });
    }
    
    public void searchInjection() {
        if (this.isEmpty()) {
            System.out.println("The list of student vaccination information is empty. Please add a student's vaccine injection information!");
            return;
        }

        String studentID;
        Injection x;

        studentID = Validation.getID("Input student id(SExxxxxx): ", "The format of id is SExxxxxx (x stands for a digit)", "^[S][E]\\d{6}$");
        x = searchInjectionByStudent(studentID);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Injection does not exist!");
        } else {
            System.out.println("Here is the student's vaccine injection information that you want to search");
            String header = String.format("|%-12s|%-10s|%-10s|%20s|%20s|%20s|%20s|", "INJECTION ID", "STUDENT ID", "VACCINE ID", "1st INJECTION PLACE", "1st INJECTION DATE", "2nd INJECTION PLACE", "2nd INJECTION DATE");
            System.out.println(header);
            x.output();
        }
    }
    
    public void removeInjection() {
        if (this.isEmpty()) {
            System.out.println("The list of student vaccination information is empty. Please add a student's vaccine injection information!");
            return;
        }

        String injectionID, choice;
        int pos;
        injectionID = Validation.getID("Input injection id(IJxxxxxx): ", "The format of id is IJxxxxxx (x stands for a digit)", "^[I][J]\\d{6}$");
        pos = searchInjectionReturnPos(injectionID);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("Injection does not exist!");
        } else {
            String header = String.format("|%-12s|%-10s|%-10s|%20s|%20s|%20s|%20s|", "INJECTION ID", "STUDENT ID", "VACCINE ID", "1st INJECTION PLACE", "1st INJECTION DATE", "2nd INJECTION PLACE", "2nd INJECTION DATE");
            System.out.println(header);
            this.get(pos).output();
            choice = Validation.getTwoOption("\nAre you sure you want to delete this injection? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                this.remove(pos);
                this.saveDataToFile();
                System.out.println("The selected injection is removed successfully!");
            } else {
                System.out.println("The selected injection is removed failed!");
            }
        }
    }

    public int searchInjectionReturnPos(String id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getInjectionID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
    
    public Injection searchInjectionByStudent(String id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getStudent().getStudentID().equalsIgnoreCase(id)) {
                return this.get(i);
            }
        }
        return null;
    }
    
    public Injection searchInjectionReturnObj(String id) {
        for (Injection injection : this) {
            if (injection.getInjectionID().equalsIgnoreCase(id)) {
                return injection;
            }
        }
        return null;
    }
    
    private void saveDataToFile() {
        try {
            FileDAO.saveDataInjection(filename, this);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void loadDataFromFile() {
        try {
            FileDAO.loadDataInjection(filename, this);
        } catch (FileNotFoundException e) {
            File file = new File(filename);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
