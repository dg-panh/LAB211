/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class StudentList extends ArrayList<Student>{
    final String filename = "Student.txt";
    
    public StudentList() {
        this.loadDataFromFile();
    }
    
    public int searchStudentReturnPos(String id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getStudentID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
    
    public Student searchStudentReturnObj(String id) {
        for (Student student : this) {
            if (student.getStudentID().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }
    
    public void addData() {
        this.add(new Student("SE140001", "Nguyen Van An"));
        this.add(new Student("SE140002", "Tran Thanh Binh"));
        this.add(new Student("SE150003", "Pham Ngoc Mai"));
        this.add(new Student("SE150004", "Nguyen Huu Cuong"));
        this.add(new Student("SE160005", "Truong Tan Phat"));
        this.saveDataToFile();
    }
    
    private void saveDataToFile() {
        try {
            FileDAO.saveDataStudent(filename, this);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void loadDataFromFile() {
        try {
            FileDAO.loadDataStudent(filename, this);
        } catch (FileNotFoundException e) {
            File file = new File(filename);
            this.addData();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
}
