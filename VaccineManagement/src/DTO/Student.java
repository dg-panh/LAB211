/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author PC
 */
public class Student {
    final String studentID;
    String name;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    @Override
    public String toString() {
        return studentID + ", " + name;
    }
    
}
