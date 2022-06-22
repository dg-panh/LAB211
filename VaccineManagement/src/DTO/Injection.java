/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author PC
 */
public class Injection {
    final String injectionID;
    Student student;
    Vaccine vaccine;
    String place1, place2, date1, date2;

    public Injection(String injectionID, Student student, Vaccine vaccine, String place1, String date1, String place2, String date2) {
        this.injectionID = injectionID;
        this.student = student;
        this.vaccine = vaccine;
        this.place1 = place1;
        this.place2 = place2;
        this.date1 = date1;
        this.date2 = date2;
    }
    
    public String getInjectionID() {
        return injectionID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public String getPlace1() {
        return place1;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public String getPlace2() {
        return place2;
    }

    public void setPlace2(String place2) {
        this.place2 = place2;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }
    
    public void output() {
        System.out.printf("|%-12s|%-10s|%-10s|%20s|%20s|%20s|%20s|\n", injectionID, student.getStudentID(), vaccine.getVaccineID(), place1, date1, place2, date2);
    }

    @Override
    public String toString() {
        return injectionID + ", " + student.getStudentID() + ", " + vaccine.getVaccineID() + ", " + place1 + ", " + date1 + ", " + place2 + ", " + date2;
    }
    
    public boolean checkDate(String date) {
        LocalDate d1 = LocalDate.parse(this.date1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate d2 = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return d2.isAfter(d1.plusWeeks(4)) && d2.isBefore(d1.plusWeeks(12));
    }
    
}
